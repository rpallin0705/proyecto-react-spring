import styles from "../styles/VideoGameList.module.css";
import { useVideoGames } from "../hooks/useVideoGame";
import { useNavigate, useParams } from "react-router-dom";
import React, { useEffect, useState } from "react";
import { VideoGame } from "../../domain/entities/VideoGame";
import VideoGameDialog from "../dialog/VideoGameDialog";
import VideoGameCard from "../components/VideoGameCard";

const VideoGameListPage: React.FC = () => {
    const { category, platform } = useParams(); // Obtener valores desde la URL
    const { videoGames, deleteVideoGame, platforms } = useVideoGames();
    const navigate = useNavigate();

    const [selectedGame, setSelectedGame] = useState<VideoGame | null>(null);
    const [displayedVideoGames, setDisplayedVideoGames] = useState<VideoGame[]>([]);

    useEffect(() => {

        
        
        const filteredGames = videoGames.filter(game => {

            const categoryMatch = !category || category === "none" || game.category === category;
            const platformMatch = !platform || game.platformIds.includes(Number(platform))
            return categoryMatch && platformMatch;
        });

        setDisplayedVideoGames(filteredGames);

    }, [category, platform, videoGames]);



    const handleDelete = async (id: number): Promise<boolean> => {
        const success = await deleteVideoGame(id);
        return success;
    };

    const handleClearCategory = () => {
        navigate(platform ? `/video-games/none/${platform}` : "/video-games");
    };

    const handleClearPlatform = () => {
        navigate(category && category !== "none" ? `/video-games/${category}` : "/video-games");
    };

    return (
        <div className={styles.videoGamesContainer}>
            {(category !== "none" || platform) && (
                <div className={styles.categoryInfo}>
                    <h2>
                        Filtrando por
                        {category && category !== "none" && (
                            <>
                                {" Categoría: "}{category}
                                <button onClick={handleClearCategory} title="Eliminar Categoría">X</button>
                            </>
                        )}
                        {category !== "none" && platform && " y"}
                        {platform && (
                            <>
                                {" Plataforma: "}{platform}
                                <button onClick={handleClearPlatform} title="Eliminar Plataforma">X</button>
                            </>
                        )}
                    </h2>
                </div>
            )}

            <div className={styles.videoGames}>
                {displayedVideoGames.map(game => (
                    <div
                        key={game.id}
                        className={styles.videoGame}
                        onClick={() => setSelectedGame(game)}
                    >
                        <VideoGameCard videoGame={game} />
                    </div>
                ))}
            </div>

            <VideoGameDialog
                game={selectedGame}
                onClose={() => setSelectedGame(null)}
                onDelete={handleDelete}
            />
        </div>
    );
};

export default VideoGameListPage;
