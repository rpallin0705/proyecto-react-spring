
import { VideoGame } from "../../domain/entities/VideoGame";
import styles from "../styles/VideoGameDialog.module.css"; // Puedes definir estilos en un archivo CSS separado

type VideoGameDialogProps = {
    game : VideoGame | null,
    onClose: () => void
}

const VideoGameDialog = ({ game, onClose } : VideoGameDialogProps) => {
  if (!game) return null; 

  return (
    <>
      <div className={styles.modal}>
        <h3>{game.name}</h3>
        <p>{game.description}</p>
        <button onClick={onClose}>Cerrar</button>
      </div>

      <div className={styles.overlay} onClick={onClose} role="button"/>
    </>
  );
};

export default VideoGameDialog;