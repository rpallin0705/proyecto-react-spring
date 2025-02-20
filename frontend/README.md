```typescript
import React from "react";
import styles from "../styles/VideoGameAlert.module.css"; // Puedes definir estilos en un archivo CSS separado

const VideoGameAlert = ({ game, onClose }) => {
  if (!game) return null; // Si no hay juego seleccionado, no renderiza nada

  return (
    <>
      {/* Contenedor del Modal */}
      <div className={styles.modal}>
        <h3>{game.title}</h3>
        <p>{game.description}</p>
        <button onClick={onClose}>Cerrar</button>
      </div>

      {/* Fondo Oscuro para cerrar la alerta al hacer clic fuera */}
      <div className={styles.overlay} onClick={onClose} />
    </>
  );
};

export default VideoGameAlert;
```

```ts
import React, { useState } from "react";
import VideoGameCard from "../components/VideoGameCard";
import VideoGameAlert from "../components/VideoGameAlert";
import styles from "../styles/VideoGameList.module.css";
import { useVideoGames } from "../hooks/useVideoGame";
import { useNavigate, useParams } from "react-router-dom";

const VideoGameListPage = () => {
    const { category } = useParams();
    const { videoGames } = useVideoGames();
    const navigate = useNavigate();

    const [selectedGame, setSelectedGame] = useState(null);

    return (
        <div className={styles.videoGamesContainer}>
            {category && (
                <div className={styles.categoryInfo}>
                    <h2>Buscando juegos por categoría {category}</h2>
                    <button onClick={() => navigate('/')} title="Borrar Categoría">X</button>
                </div>
            )}

            <div className={styles.videoGames}>
                {(category?.length === undefined ? videoGames : videoGames.filter(game => game.category === category))
                    .map(game => (
                        <div 
                            key={game.id} 
                            className={styles.videoGame} 
                            onClick={() => setSelectedGame(game)}
                        >
                            <VideoGameCard videoGame={game} />
                        </div>
                    ))}
            </div>

            {/* Alerta Modal usando el componente separado */}
            <VideoGameAlert game={selectedGame} onClose={() => setSelectedGame(null)} />
        </div>
    );
};

export default VideoGameListPage;
```

```css
.modal {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    z-index: 1000;
    width: 300px;
    text-align: center;
}

.overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    background: rgba(0, 0, 0, 0.5);
    z-index: 999;
}
```

```css
@keyframes fadeIn {
    from {
        opacity: 0;
    }
    to {
        opacity: 1;
    }
}

@keyframes fadeOut {
    from {
        opacity: 1;
    }
    to {
        opacity: 0;
    }
}

.modal {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    z-index: 1000;
    width: 300px;
    text-align: center;
    animation: fadeIn 0.3s ease-in-out;
}

.overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    background: rgba(0, 0, 0, 0.5);
    z-index: 999;
    animation: fadeIn 0.3s ease-in-out;
}
```

```css
@keyframes slideDown {
    from {
        transform: translate(-50%, -70%);
        opacity: 0;
    }
    to {
        transform: translate(-50%, -50%);
        opacity: 1;
    }
}

.modal {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    z-index: 1000;
    width: 300px;
    text-align: center;
    animation: slideDown 0.3s ease-out;
}
```
```css
@keyframes zoomIn {
    from {
        transform: translate(-50%, -50%) scale(0.8);
        opacity: 0;
    }
    to {
        transform: translate(-50%, -50%) scale(1);
        opacity: 1;
    }
}

.modal {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    z-index: 1000;
    width: 300px;
    text-align: center;
    animation: zoomIn 0.3s ease-in-out;
}
```

```css
@keyframes slideFromRight {
    from {
        transform: translate(30%, -50%);
        opacity: 0;
    }
    to {
        transform: translate(-50%, -50%);
        opacity: 1;
    }
}

.modal {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    z-index: 1000;
    width: 300px;
    text-align: center;
    animation: slideFromRight 0.3s ease-in-out;
}
```

```ts
import React, { useState, useEffect } from "react";
import styles from "../styles/Header.module.css"; // Archivo de estilos

const Header = () => {
    const [scrolled, setScrolled] = useState(false);

    useEffect(() => {
        const handleScroll = () => {
            if (window.scrollY > 50) {
                setScrolled(true);
            } else {
                setScrolled(false);
            }
        };

        window.addEventListener("scroll", handleScroll);
        return () => window.removeEventListener("scroll", handleScroll);
    }, []);

    return (
        <header className={`${styles.header} ${scrolled ? styles.scrolled : ""}`}>
            <div className={styles.headerLogo}>
                <img src="/logo.png" alt="Logo" className={styles.headerImg} />
                <h1>Mi Sitio Web</h1>
            </div>
        </header>
    );
};

export default Header;
```

```css
/* Estilo inicial cuando está arriba */
.header {
    width: 100%;
    position: absolute;
    top: 0;
    left: 0;
    background-image: linear-gradient(to bottom, #00ffff36, rgba(0, 255, 255, 0));
    padding: 15px 20px;
    transition: all 0.3s ease-in-out;
    z-index: 100;
}

/* Estilo cuando haces scroll */
.scrolled {
    position: fixed;
    background-color: rgba(0, 0, 0, 0.8); /* Se oscurece */
    backdrop-filter: blur(10px); /* Efecto de desenfoque */
    padding: 10px 20px; /* Ajusta el tamaño */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
}
```