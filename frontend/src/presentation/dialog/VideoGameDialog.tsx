
import { VideoGame } from "../../domain/entities/VideoGame";
import styles from "../styles/VideoGameDialog.module.css"; // Puedes definir estilos en un archivo CSS separado

type VideoGameDialogProps = {
  game: VideoGame | null,
  onClose: () => void
}

const VideoGameDialog: React.FC<VideoGameDialogProps> = ({ game, onClose }: VideoGameDialogProps) => {
  if (!game) return null;

  return (
    <>
      <div className={styles.modal}>
        <div
          className={styles.dialogHeader}
          style={{
            backgroundImage: "url('https://gaming-cdn.com/img/products/16809/pcover/1920x620/16809.jpg?v=1715614171')"
          }}
        >
          <img src="https://gaming-cdn.com/images/products/16809/616x353/call-of-duty-2026-pc-juego-cover.jpg?v=1715614171" />
          <div className={styles.gameInfo}>
            <h3>{game.name}</h3>
            <p>${game.price}</p>
          </div>
        </div>
        <div className={styles.content}>
          <p>{game.description}</p>
          <p>{game.category}</p>
          <p> playSTation</p>
          <div className={styles.contentButton}>
            <button onClick={onClose}>Cerrar</button>
            <button onClick={onClose}>Borrar</button>
          </div>
        </div>
      </div>

      <div className={styles.overlay} onClick={onClose} role="button" />
    </>
  );
};

export default VideoGameDialog;