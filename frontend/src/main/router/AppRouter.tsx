import { createBrowserRouter, Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../../presentation/context/AuthContext";
import { RootLayout } from "../../presentation/components/RootLayout";
import LoginPage from "../../presentation/pages/Login";
import RegisterPage from "../../presentation/pages/Register";
import VideoGameListPage from "../../presentation/pages/VideoGamesListPage";

const ProtectedRoute = () => {
  const { user } = useAuth();
  return user ? <Outlet /> : <Navigate to="/login" />;
};

export const appRouter = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    children: [
      { path: "video-games/:category?/:platform?", element: <ProtectedRoute />, children: [{ index: true, element: <VideoGameListPage /> }] },
      { path: "/login", element: <LoginPage /> },
      { path: "/register", element: <RegisterPage /> }
    ],
  },
]);