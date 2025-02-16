import { VideoGame } from "../../domain/entities/VideoGame";
import VideoGameCard from "../components/VideoGameCard";
import { useVideoGames } from "../hooks/useVideoGame";

const VideoGameListPage = () => {

    const { videoGames, categories } = useVideoGames()

    return (
        <>
            {videoGames.map(game => (
                <VideoGameCard key={game.id} videoGame={game} />
            ))}
        </>
    );
}

export default VideoGameListPage;