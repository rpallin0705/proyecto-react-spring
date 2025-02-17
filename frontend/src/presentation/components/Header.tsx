import { useVideoGames } from "../hooks/useVideoGame";
import { useNavigate } from "react-router-dom";
import "../styles/App.css";

export const Header = () => {
    const { categories } = useVideoGames();
    const navigate = useNavigate();

    const handleCategoryClick = (category: String) => {
        navigate(`/video-games/${category}`);
    };

    return (
        //todo hacer header añadiendo la propiedad sticky al header y  envolviendo todo en un contenedor
        //todo hacer el el root layout ocupe todo el body y el footer esté siempre abajo
        // todo porque la imagen ahora no se ve
        <header>
            <div className="header">
                <div className="header-logo">
                    <img className="header-img" src="./logo.png" alt="Logo" />
                    <h1>Gamer Vault</h1>
                </div>
                <div className="categories-container">
                    <h2>Categories</h2>
                    <nav className="categories-nav">
                        {categories.map((category, index) =>
                            <li className="category" key={index} onClick={() => handleCategoryClick(category)}>
                                {category}
                            </li>
                        )}
                    </nav>
                </div>
            </div>
        </header>


    );
};