import axios from "axios";
import { API_BASE_URL } from "../../shared/utils/constants";

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    "Content-Type": "application/json",
    "Accept": "application/json"
  },
  withCredentials: true
});

api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token) {
      config.headers["Authorization"] = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

api.interceptors.response.use(
  (response) => response, 
  (error) => {
    if (error.response && error.response.status === 403) {
      console.warn("Token inválido o expirado, redirigiendo a /login...");
      localStorage.removeItem("token");
      localStorage.removeItem("user")
      window.location.href = "/login"; 
    }
    return Promise.reject(error); 
  }
);

export default api;