import axios from "axios";

//todo hacer todas las peticiones a la api
const api = axios.create({
    headers: {
      'Content-Type': 'application/json',
      'Accept':'application/json'
    },
    baseURL: 'http://localhost:8080/api',
  });
  
export default api;