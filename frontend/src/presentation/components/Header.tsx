import { useVideoGames } from "../hooks/useVideoGame";
import { useNavigate } from "react-router-dom";
import styles from "../styles/RootLayout.module.css"
import { useState } from "react";

export const Header = () => {
    const { categories, platforms, setSelectedPlatform } = useVideoGames()
    const [isSelected, setIsSelected] = useState<boolean>(false)
    const navigate = useNavigate();

    const handleCategoryClick = (category: string) => {
        navigate(`/video-games/${category}`);
    };

    const handlePlatformClick = (id: number) => {
        setSelectedPlatform(id)
    };

    return (
        <header className={styles.header}>
            <div className={styles.headerLogo}>
                <img className={styles.headerTitleImg} src="./title.png" alt="Logo" />
            </div>
            <div className={styles.headerFilter}>
                <div className={styles.categoriesContainer}>
                    <h2><nav onClick={() => setIsSelected(false)} style={{ color: isSelected ? 'white' : '#00ffff' }}>Categories</nav></h2>
                    <h2><nav onClick={() => setIsSelected(true)} style={{ color: isSelected ? '#00ffff' : 'white' }}>Platforms</nav></h2>
                </div>
                <nav className={styles.categoriesNav} style={{ display: isSelected ? 'none' : 'flex' }}>
                    {categories.map((category, index) =>
                        <li className={styles.category} key={index} >
                            <span onClick={() => handleCategoryClick(category)}>{category}</span>
                        </li>
                    )}
                </nav>
                <nav className={styles.platformNav} style={{ display: isSelected ? 'flex' : 'none' }}>
                    {platforms.map((platform, index) =>
                        <li className={styles.category} key={index}>
                            <span onClick={() => handlePlatformClick(platform.id)}>{platform.name}</span>
                        </li>
                    )}
                </nav>
            </div>
        </header>
    );
};