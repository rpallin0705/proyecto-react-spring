import { Outlet } from "react-router-dom";
import { Header } from "./Header";
import styles from "../styles/RootLayout.module.css"

export const RootLayout = () => {
    return (
        <div className={styles.rootLayout}>
            <Header />
            <div className={styles.content}>
                <Outlet />
            </div>
            <footer>
                <p>{new Date().getFullYear()}</p>
                <p>Gamer Vault</p>
                <p>Proyecto Rafael Álvaro Palomares Linares</p>
            </footer>
        </div>
    );
}
