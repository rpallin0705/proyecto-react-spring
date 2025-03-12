import styles from "../styles/VideoGameList.module.css";
import { useVideoGames } from "../context/VideoGameContext";
import { useNavigate, useParams } from "react-router-dom";
import React, { useEffect, useState } from "react";
import { VideoGame } from "../../domain/entities/VideoGame";
import VideoGameDialog from "../dialog/VideoGameDialog";
import VideoGameCard from "../components/VideoGameCard";
import { Platform } from "../../domain/entities/Platform";
import { useAuth } from "../context/AuthContext";
import { InputAdornment, TextField } from "@mui/material";
import { Search } from "@mui/icons-material";

const VideoGameListPage: React.FC = () => {
    const { category, platform } = useParams();
    const { videoGames, deleteVideoGame, platforms } = useVideoGames();
    const { user } = useAuth();
    const navigate = useNavigate();

    const [selectedGame, setSelectedGame] = useState<VideoGame | null>(null);
    const [selectedPlatform, setSelectedPlatform] = useState<Platform | null>(null);
    const [searchText, setSearchText] = useState<string>("")

    useEffect(() => {
        const platformId = platform ? Number(platform) : null;
        setSelectedPlatform(platforms.find(plat => plat.id === platformId) || null);
    }, [platform, platforms]);

    const filteredVideoGames = videoGames.filter(game => {
        if (!user) return false;
        console.log("hola")
        const platformId = platform ? Number(platform) : null;
        return (
            (!category || category === "none" || game.category === category) &&
            (!platformId || game.platformIds.includes(platformId)) &&
            (game.name.toLocaleLowerCase().includes(searchText.toLowerCase()))

        );
    });

    return (
        <div className={styles.videoGamesContainer}>
            <div className={styles.videoGameListHeader}>
                <h1>{user ? `Bienvenido ${user}` : "Inicia sesión para ver los videojuegos"}</h1>
                <TextField
                    label="search" type="text" margin="normal" value={searchText}
                    onChange={(e) => setSearchText(e.target.value)}
                    slotProps={{
                        input: {
                            startAdornment: (
                                <InputAdornment position="start">
                                    <Search sx={{ color: "#00ffff" }} />
                                </InputAdornment>
                            ),
                        },
                    }}
                    sx={{
                        "& label": { color: "#00ffff" },
                        "& label.Mui-focused": { color: "#00aaaa" },
                        "& .MuiOutlinedInput-root": {
                            "& fieldset": { borderColor: "#00ffff", borderWidth: "2px" },
                            "&:hover fieldset": { borderColor: "#00aaaa" },
                            "&.Mui-focused fieldset": { borderColor: "#00cccc" },
                            backgroundColor: "rgba(0, 0, 0, 0.5)",
                            borderRadius: "8px",
                        },
                        input: { color: "#ffffff" },
                    }}
                />
            </div>

            {(category !== undefined || selectedPlatform !== null) && user && (
                <div className={styles.categoryInfo}>
                    <h2>
                        Filtrando por
                        {category && category !== "none" && (
                            <>
                                {" Categoría: "}{category}
                                <button onClick={() => navigate(platform ? `/videogames/none/${platform}` : "/videogames")} title="Eliminar Categoría">X</button>
                            </>
                        )}
                        {category !== "none" && platform && " y "}
                        {platform && (
                            <>
                                {" Plataforma: "}{selectedPlatform?.name}
                                <button onClick={() => navigate(category ? `/videogames/${category}` : "/videogames")} title="Eliminar Plataforma">X</button>
                            </>
                        )}
                    </h2>
                </div>
            )}

            <div className={styles.videoGames}>
                {user ? (
                    filteredVideoGames.length > 0 ? (
                        filteredVideoGames.map(game => (
                            <div key={game.id} className={styles.videoGame} onClick={() => setSelectedGame(game)}>
                                <VideoGameCard videoGame={game} />
                            </div>
                        ))
                    ) : (
                        <p>No hay videojuegos disponibles.</p>
                    )
                ) : (
                    <p>Por favor, inicia sesión para ver los videojuegos.</p>
                )}
            </div>

            <VideoGameDialog
                game={selectedGame}
                onClose={() => setSelectedGame(null)}
                onDelete={deleteVideoGame}
            />
        </div>
    );
};

export default VideoGameListPage;
