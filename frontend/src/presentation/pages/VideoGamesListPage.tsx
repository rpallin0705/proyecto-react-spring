import VideoGameCard from "../components/VideoGameCard";
import styles from "../styles/VideoGameList.module.css"
import { useVideoGames } from "../hooks/useVideoGame";
import { useParams } from "react-router-dom";

const VideoGameListPage = () => {

    const { category } = useParams()
    const { videoGames } = useVideoGames()

    return (
        <div className={styles.videoGamesContainer}>
            {category && <h2>Categoría {category}</h2>}
            <div className={styles.videoGames}>

                {category?.length === 0
                    ?
                    videoGames.map(game => (
                        <VideoGameCard key={game.id} videoGame={game} />
                    ))
                    : videoGames.filter(game => game.category === category)
                        .map(game => (<VideoGameCard key={game.id} videoGame={game} />))
                }
            </div>
        </div>
    )
}

export default VideoGameListPage;