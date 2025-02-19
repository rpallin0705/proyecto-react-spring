import VideoGameCard from "../components/VideoGameCard";
import styles from "../styles/VideoGameList.module.css"
import { useVideoGames } from "../hooks/useVideoGame";
import { useNavigate, useParams } from "react-router-dom";

const VideoGameListPage = () => {

    const { category } = useParams()
    const { videoGames } = useVideoGames()
    const navigate = useNavigate()

    return (

        <div className={styles.videoGamesContainer}>
            {category &&
                <div className={styles.categoryInfo}>
                    <h2>Buscando juegos por categoría {category} </h2>
                    <button
                        onClick={() => (navigate('/'))}
                        title="Borrar Categoría">X</button>
                </div>
            }
            <div className={styles.videoGames}>
                {category?.length === undefined
                    ?
                    videoGames.map(game => (
                        <div key={game.id} className={styles.videoGame}>
                            <VideoGameCard videoGame={game} />
                        </div>
                    ))
                    : videoGames.filter(game => game.category === category)
                        .map(game => (
                            <div key={game.id} className={styles.videoGame}>
                                <VideoGameCard videoGame={game} />
                            </div>
                        ))
                }
            </div>
        </div>
    )
}

export default VideoGameListPage;