import { Outlet } from "react-router-dom";
import { Header } from "./Header";

export const RootLayout = () => {
    return (
        <div className="root-layout">
            <Header />
            <div>
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
