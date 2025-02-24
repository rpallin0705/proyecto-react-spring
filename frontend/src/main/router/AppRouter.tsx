import { createBrowserRouter } from "react-router-dom"
import VideoGameListPage from "../../presentation/pages/VideoGamesListPage"
import { RootLayout } from "../../presentation/components/RootLayout"

export const appRouter = createBrowserRouter([
    {
        path: "/",
        element: <RootLayout />,
        children: [
            {
                path: "video-games/:category?/:platform?", 
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
