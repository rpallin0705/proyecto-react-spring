import { VideoGame } from "../../domain/entities/VideoGame";


type VideoGameCardProps = {
    videoGame : VideoGame
}

const VideoGameCard = ({videoGame} : VideoGameCardProps) => {
    return ( 
        <>
            <p>{videoGame.name}</p>
            <p>{videoGame.description}</p>
            <p>{videoGame.price}</p>
        </>
     );
}
 
export default VideoGameCard;