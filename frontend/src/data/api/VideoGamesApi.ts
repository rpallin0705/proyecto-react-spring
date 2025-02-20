import { ENDPOINTS } from "../../shared/utils/constants"
import api from "./api"

export const fetchVideoGames = async () => {
    const response = await api.get(ENDPOINTS.VIDEOGAMES)
    return response.data
}

export const fetchVideoGamesByName = async (name: string) => {
    const response = await api.get(`${ENDPOINTS.VIDEOGAMES}/${name}`)
    return response.data
}

export const fetchVideoGamesCategories = async () => {
    const response = await api.get(ENDPOINTS.VIDEOGAMES_CATEGORIES)
    return response.data
}

export const deleteVideoGameById = async (id: number) => {
    const response = await api.delete(`${ENDPOINTS.VIDEOGAMES}/${id}`);
    return response.status === 204
        ? true
        : false
};