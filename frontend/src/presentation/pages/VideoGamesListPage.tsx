import styles from "../styles/VideoGameList.module.css";
import { useVideoGames } from "../context/VideoGameContext";
import { useNavigate, useParams } from "react-router-dom";
import React, { useEffect, useState } from "react";
import { VideoGame } from "../../domain/entities/VideoGame";
import VideoGameDialog from "../dialog/VideoGameDialog";
import VideoGameCard from "../components/VideoGameCard";
import { Platform } from "../../domain/entities/Platform";
import { useAuth } from "../context/AuthContext";

const VideoGameListPage: React.FC = () => {
    const { category, platform } = useParams();
    const { videoGames, deleteVideoGame, platforms } = useVideoGames(); 
    const { user } = useAuth();
    const navigate = useNavigate();

    const [selectedGame, setSelectedGame] = useState<VideoGame | null>(null);
    const [selectedPlatform, setSelectedPlatform] = useState<Platform | null>(null);

    useEffect(() => {
        const platformId = platform ? Number(platform) : null;
        setSelectedPlatform(platforms.find(plat => plat.id === platformId) || null);
    }, [platform, platforms]);

    const filteredVideoGames = videoGames.filter(game => {
        if (!user) return false; 
        const platformId = platform ? Number(platform) : null;
        return (
            (!category || category === "none" || game.category === category) &&
            (!platformId || game.platformIds.includes(platformId))
        );
    });

    return (
        <div className={styles.videoGamesContainer}>
            <h1>{user ? "Tus videojuegos" : "Inicia sesión para ver los videojuegos"}</h1>

            {(category !== undefined || selectedPlatform !== null) && user && (
                <div className={styles.categoryInfo}>
                    <h2>
                        Filtrando por
                        {category && category !== "none" && (
                            <>
                                {" Categoría: "}{category}
                                <button onClick={() => navigate(platform ? `/video-games/none/${platform}` : "/video-games")} title="Eliminar Categoría">X</button>
                            </>
                        )}
                        {category !== "none" && platform && " y "}
                        {platform && (
                            <>
                                {" Plataforma: "}{selectedPlatform?.name}
                                <button onClick={() => navigate(category ? `/video-games/${category}` : "/video-games")} title="Eliminar Plataforma">X</button>
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
