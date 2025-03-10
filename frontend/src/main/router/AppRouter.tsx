import { createBrowserRouter, Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../../presentation/context/AuthContext";
import { RootLayout } from "../../presentation/components/RootLayout";
import LoginPage from "../../presentation/pages/Login";
import RegisterPage from "../../presentation/pages/Register";
import VideoGameListPage from "../../presentation/pages/VideoGamesListPage";

export const ProtectedRoute = () => {
  const { user } = useAuth();
  return user ? <Outlet /> : <Navigate to="/login" />;
};


export const PublicOnlyRoute = () => {
  const { user } = useAuth();
  return user ? <Navigate to="/videogames" /> : <Outlet />;
};


export const appRouter = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    children: [
      { index: true, element: <Navigate to="/login" /> },
      {
        path: "/videogames/:category?/:platform?",
        element: <ProtectedRoute />,
        children: [{ index: true, element: <VideoGameListPage /> }],
      },
      {
        element: <PublicOnlyRoute />,
        children: [
          { path: "/login", element: <LoginPage /> },
          { path: "/register", element: <RegisterPage /> },
        ],
      },
    ],
  },
]);