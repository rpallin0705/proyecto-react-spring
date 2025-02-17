import { VideoGame } from "../../domain/entities/VideoGame";
import "../styles/VideoGameCard.css"

 type VideoGameCardProps = {
     videoGame: VideoGame;
 };

 const VideoGameCard = ({ videoGame }: VideoGameCardProps) => {
     return (
         <div className="videogame-card">
             <img src="https://gaming-cdn.com/images/products/16809/616x353/call-of-duty-2026-pc-juego-cover.jpg?v=1715614171" 
                  alt={videoGame.name} 
                  className="videogame-image" />
             <div className="videogame-info">
                 <h2 className="videogame-title">{videoGame.name}</h2>
                 {/* <p className="description">{videoGame.description}</p> */}
                 <p className="price">${videoGame.price}</p>
                 <button className="buy-button">Comprar</button>
             </div>
         </div>
     );
 };

 export default VideoGameCard;