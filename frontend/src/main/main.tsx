import { createRoot } from "react-dom/client";
import App from "./App";
import { AuthProvider } from "../presentation/context/AuthContext";
import { VideoGameProvider } from "../presentation/context/VideoGameContext"; // 🔥 Importamos el nuevo contexto

createRoot(document.getElementById("root")!).render(
  <AuthProvider>
    <VideoGameProvider>
      <App />
    </VideoGameProvider>
  </AuthProvider>
);
