import { useEffect, useState } from "react"
import { VideoGame } from "../../domain/entities/VideoGame"
import { GetVideoGames } from "../../domain/usecase/GetVideoGames"
import { GetVideoGameCategories } from "../../domain/usecase/GetVideoGameCategories"
import { GetVideoGameByName } from "../../domain/usecase/GetVideoGamesByName"
import { DeleteVideoGameById } from "../../domain/usecase/DeleteVideoGameByName"
import { GetVideoGamePlatforms } from "../../domain/usecase/GetVideoGamePlatforms"
import { GetVideoGameIdsByPlatformId } from "../../domain/usecase/GetVideoGamesIdsByPlatformId"
import { Platform } from "../../domain/entities/Platform"
import { useAuth } from "../context/AuthContext"


export const useVideoGames = () => {

    const [videoGames, setVideoGames] = useState<VideoGame[]>([])
    const [categories, setCategories] = useState<string[]>([])
    const [platforms, setPlatforms] = useState<Platform[]>([])
    const [selectedGame, setSelectedGame] = useState<VideoGame | null>(null)
    const [deletedVideoGame, setDeletedVideoGame] = useState<boolean>(false)
    const {user} = useAuth()
    

    useEffect(() => {
        GetVideoGames.execute().then(setVideoGames)
    }, [])

    useEffect(() => {
        GetVideoGameCategories.execute().then(setCategories)
    }, [user])

    useEffect(() => {
        GetVideoGamePlatforms.execute().then(setPlatforms)
    }, [user])

    // TODO revisar porque no se actualizaban en el VideoGameList
    const getVideoGameIdsByPlatformId = async (id: number) => {
        const result = await GetVideoGameIdsByPlatformId.execute(id)
        console.log(result)
        return result
    }

    const getVideoGameByName = async (name: string) => {
        const game = await GetVideoGameByName.execute(name);
        setSelectedGame(game);
    };

    const deleteVideoGame = async (id: number) => {
        const result = await DeleteVideoGameById.execute(id)
        setDeletedVideoGame(result)
        if (result)
            setVideoGames(prevGames => prevGames.filter(game => game.id !== id))
        return result
    }

    return {
        videoGames, selectedGame
        , categories, platforms
        , getVideoGameByName
        , deletedVideoGame, deleteVideoGame
        , getVideoGameIdsByPlatformId, 
    }
}