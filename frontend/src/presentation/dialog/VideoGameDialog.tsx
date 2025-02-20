import { VideoGame } from "../../domain/entities/VideoGame";
import styles from "../styles/VideoGameDialog.module.css";
import { useState } from "react";

type VideoGameDialogProps = {
  game: VideoGame | null;
  onClose: () => void;
  onDelete: (id: number) => Promise<boolean>;
};

const VideoGameDialog: React.FC<VideoGameDialogProps> = ({ game, onClose, onDelete }) => {
  const [isDeleted, setIsDeleted] = useState<boolean>(false);
  const [errorMessage, setErrorMessage] = useState<string | null>(null);

  if (!game) return null;

  const handleDelete = async () => {
    if (game) {
      const success = await onDelete(game.id);
      if (success) {
        setIsDeleted(true);
        setTimeout(() => {
          setIsDeleted(false);
          onClose();
        }, 2000);
      } else {
        setErrorMessage("Error al eliminar el videojuego.");
        setTimeout(() => setErrorMessage(null), 3000);
      }
    }
  };

  return (
    <>
      <div className={styles.modal}>
        {isDeleted ? (
          <div className={styles.successMessage}>
            Videojuego eliminado correctamente.
          </div>
        ) : (
          <>
            <div
              className={styles.dialogHeader}
              style={{
                backgroundImage: "url('https://gaming-cdn.com/img/products/16809/pcover/1920x620/16809.jpg?v=1715614171')",
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
              <p>PlayStation</p>

              {errorMessage && <p className={styles.errorMessage}>{errorMessage}</p>}

              <div className={styles.contentButton}>
                <button onClick={onClose}>Cerrar</button>
                <button onClick={handleDelete}>Borrar</button>
              </div>
            </div>
          </>
        )}
      </div>

      <div className={styles.overlay} onClick={onClose} role="button" />
    </>
  );
};

export default VideoGameDialog;
