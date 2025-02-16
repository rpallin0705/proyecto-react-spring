import { ENDPOINTS } from "../../shared/utils/constants"
import api from "./api"

export const fetchVideoGames = async () => {
    const response = await api.get(ENDPOINTS.VIDEOGAMES)
    return response.data
}

export const fetchVideoGamesByName = async (name : string) => {
    const response = await api.get(`${ENDPOINTS.VIDEOGAMES}/${name}`)
    return response.data
}

export const fetchVideoGamesCategories = async () => {
    const response = await api.get(`${ENDPOINTS.VIDEOGAMES}/categories`)
    return response.data
}