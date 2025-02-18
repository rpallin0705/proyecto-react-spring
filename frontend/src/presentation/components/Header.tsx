import { useVideoGames } from "../hooks/useVideoGame";
import { useNavigate } from "react-router-dom";
import styles from "../styles/RootLayout.module.css"

export const Header = () => {
    const { categories } = useVideoGames();
    const navigate = useNavigate();

    const handleCategoryClick = (category: string) => {
        navigate(`/video-games/${category}`);
    };

    return (
        <header className={styles.header}>
            <div className={styles.headerLogo}>
                <img className="headerImg" src="./logo.png" alt="Logo" />
                <h1>Gamer Vault</h1>
            </div>
            <div className={styles.categoriesContainer}>
                <h2>Categories</h2>
                <nav className={styles.categoriesNav}>
                    {categories.map((category, index) =>
                        <li className={styles.category} key={index} onClick={() => handleCategoryClick(category)}>
                            <span>{category}</span>
                        </li>
                    )}
                </nav>
            </div>
        </header>
    );
};