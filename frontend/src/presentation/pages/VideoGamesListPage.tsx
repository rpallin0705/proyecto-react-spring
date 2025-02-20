import styles from "../styles/VideoGameList.module.css";
import { useVideoGames } from "../hooks/useVideoGame";
import { useNavigate, useParams } from "react-router-dom";
import React, { useState } from "react";
import { VideoGame } from "../../domain/entities/VideoGame";
import VideoGameDialog from "../dialog/VideoGameDialog";
import VideoGameCard from "../components/VideoGameCard";

const VideoGameListPage: React.FC = () => {
    const { category } = useParams();
    const { videoGames, deleteVideoGame } = useVideoGames();
    const navigate = useNavigate();

    const [selectedGame, setSelectedGame] = useState<VideoGame | null>(null);

    const handleDelete = async (id: number): Promise<boolean> => {
        const success = await deleteVideoGame(id);
        return success;
    };

    return (
        <div className={styles.videoGamesContainer}>
            {category && (
                <div className={styles.categoryInfo}>
                    <h2>Buscando juegos por categoría {category}</h2>
                    <button onClick={() => navigate('/')} title="Borrar Categoría">X</button>
                </div>
            )}

            <div className={styles.videoGames}>
                {(category?.length === undefined ? videoGames : videoGames.filter(game => game.category === category))
                    .map(game => (
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
