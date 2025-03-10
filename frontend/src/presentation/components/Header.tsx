import { useVideoGames } from "../context/VideoGameContext"; 
import { useNavigate, useParams } from "react-router-dom";
import styles from "../styles/RootLayout.module.css";
import { useState } from "react";
import { Platform } from "../../domain/entities/Platform";
import { useAuth } from "../context/AuthContext";
import { Button } from "@mui/material";

export const Header: React.FC = () => {
    const { categories, platforms } = useVideoGames(); 
    const { category, platform } = useParams();
    const [isSelected, setIsSelected] = useState<boolean>(false);
    const navigate = useNavigate();
    const { user, logout } = useAuth();

    const updateRoute = (newCategory?: string, newPlatform?: string) => {
        let finalCategory = newCategory || category || "none";
        let finalPlatform = newPlatform || platform || "";

        let newPath = `/videogames/${finalCategory}`;
        if (finalPlatform) newPath += `/${finalPlatform}`;

        navigate(newPath);
    };

    const handleCategoryClick = (selectedCategory: string) => {
        updateRoute(selectedCategory, platform);
    };

    const handlePlatformClick = async (platform: Platform) => {
        updateRoute(category || "none", `${platform.id}`);
    };

    return (
        <header className={styles.header}>
            <div className={styles.headerLogo}>
                <img className={styles.headerTitleImg} src="./title.png" alt="Logo" />
            </div>

            {user ? (
                <div className={styles.headerFilter}>
                    <div className={styles.categoriesContainer}>
                        <h2>
                            <nav onClick={() => setIsSelected(false)} style={{ color: isSelected ? "white" : "#00ffff" }}>
                                Categories
                            </nav>
                        </h2>
                        <h2>
                            <nav onClick={() => setIsSelected(true)} style={{ color: isSelected ? "#00ffff" : "white" }}>
                                Platforms
                            </nav>
                        </h2>
                    </div>
                    <nav className={styles.categoriesNav} style={{ display: isSelected ? "none" : "flex" }}>
                        {categories.map((cat, index) => (
                            <li className={styles.category} key={index}>
                                <span onClick={() => handleCategoryClick(cat)}>{cat}</span>
                            </li>
                        ))}
                    </nav>
                    <nav className={styles.platformNav} style={{ display: isSelected ? "flex" : "none" }}>
                        {platforms.map((plat, index) => (
                            <li className={styles.category} key={index}>
                                <span onClick={() => handlePlatformClick(plat)}>{plat.name}</span>
                            </li>
                        ))}
                    </nav>
                </div>
            ) : (
                <div className={styles.authButtons}>
                    <nav className={styles.authButton} onClick={() => navigate("/login")}>
                        Iniciar Sesión
                    </nav>
                    <nav className={styles.authButton} onClick={() => navigate("/register")}>
                        Registrarse
                    </nav>
                </div>
            )}

            {user && (
                <div className={styles.logoutContainer}>
                    <Button variant="outlined" color="error" onClick={logout}>
                        Cerrar Sesión
                    </Button>
                </div>
            )}
        </header>
    );
};