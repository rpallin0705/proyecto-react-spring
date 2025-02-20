import { createBrowserRouter } from "react-router-dom"
import VideoGameListPage from "../../presentation/pages/VideoGamesListPage"
import { RootLayout } from "../../presentation/components/RootLayout"

export const appRouter = createBrowserRouter([
    {
        path: "/",
        element: <RootLayout />,
        children: [
            // Ruta para /video-games o la raíz / que es equivalente
            {
                path: "video-games/:category?", 
                element: <VideoGameListPage />,
            },
            {
                path: "/",
                index: true,
                element: <VideoGameListPage />
            },
        ],
    },
]);
