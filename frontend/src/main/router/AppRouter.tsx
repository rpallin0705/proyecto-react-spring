import { createBrowserRouter, Router } from "react-router-dom"
import VideoGameListPage from "../../presentation/pages/VideoGamesListPage"

export const appRouter = createBrowserRouter([
    {
        path: "/",
        index: true,
        element: <VideoGameListPage/>
    }
])
