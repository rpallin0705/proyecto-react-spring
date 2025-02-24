import { useVideoGames } from "../hooks/useVideoGame";
import { useNavigate, useParams } from "react-router-dom";
import styles from "../styles/RootLayout.module.css";
import { useEffect, useState } from "react";
import { Platform } from "../../domain/entities/Platform";

export const Header = () => {
    const { categories, platforms, getVideoGameIdsByPlatformId, } = useVideoGames();
    const { category, platform } = useParams(); // Obtener valores actuales de la URL
    const [isSelected, setIsSelected] = useState<boolean>(false);
    const navigate = useNavigate();

   
    const updateRoute = (newCategory?: string, newPlatform?: string) => {
        let finalCategory = newCategory || category || "none"; 
        let finalPlatform = newPlatform || platform || ""; 

        let newPath = `/video-games/${finalCategory}`;
        if (finalPlatform) newPath += `/${finalPlatform}`;

        navigate(newPath);
    };

    const handleCategoryClick = (selectedCategory: string) => {
        updateRoute(selectedCategory, platform); 
    };

    const handlePlatformClick = async (platform: Platform) => {  
        updateRoute(category || "none", `${platform.id}` );
    };
    
    return (
        <header className={styles.header}>
            <div className={styles.headerLogo}>
                <img className={styles.headerTitleImg} src="./title.png" alt="Logo" />
            </div>
            <div className={styles.headerFilter}>
                <div className={styles.categoriesContainer}>
                    <h2>
                        <nav onClick={() => setIsSelected(false)} style={{ color: isSelected ? 'white' : '#00ffff' }}>
                            Categories
                        </nav>
                    </h2>
                    <h2>
                        <nav onClick={() => setIsSelected(true)} style={{ color: isSelected ? '#00ffff' : 'white' }}>
                            Platforms
                        </nav>
                    </h2>
                </div>
                <nav className={styles.categoriesNav} style={{ display: isSelected ? 'none' : 'flex' }}>
                    {categories.map((cat, index) =>
                        <li className={styles.category} key={index}>
                            <span onClick={() => handleCategoryClick(cat)}>{cat}</span>
                        </li>
                    )}
                </nav>
                <nav className={styles.platformNav} style={{ display: isSelected ? 'flex' : 'none' }}>
                    {platforms.map((plat, index) =>
                        <li className={styles.category} key={index}>
                            <span onClick={() => handlePlatformClick(plat)}>{plat.name}</span>
                        </li>
                    )}
                </nav>
            </div>
        </header>
    );
};
