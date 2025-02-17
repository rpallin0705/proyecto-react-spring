import { VideoGame } from "../../domain/entities/VideoGame";
import styles from "../styles/VideoGameCard.module.css"; // Importa los estilos como módulo

type VideoGameCardProps = {
    videoGame: VideoGame;
};

const VideoGameCard = ({ videoGame }: VideoGameCardProps) => {
    return (
        <div className={styles.videogameCard}>
            <img src="https://gaming-cdn.com/images/products/16809/616x353/call-of-duty-2026-pc-juego-cover.jpg?v=1715614171" 
                alt={videoGame.name} 
                className={styles.videogameImage} />
            <div className={styles.videogameInfo}>
                <p className={styles.videogameTitle}>{videoGame.name}</p>
                <p className={styles.price}>${videoGame.price}</p>
            </div>
        </div>
    );
};

export default VideoGameCard;
