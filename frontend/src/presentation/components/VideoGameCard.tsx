import { VideoGame } from "../../domain/entities/VideoGame";
import styles from "../styles/VideoGameCard.module.css"; 

type VideoGameCardProps = {
    videoGame: VideoGame;
};

const VideoGameCard: React.FC<VideoGameCardProps> = ({ videoGame }) => {

    return (
        <div className={styles.videogameCard}>
            <img src={videoGame.urlImage}
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
