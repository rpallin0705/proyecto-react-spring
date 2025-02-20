import { useEffect, useState } from "react"
import { VideoGame } from "../../domain/entities/VideoGame"
import { GetVideoGames } from "../../domain/usecase/GetVideoGames"
import { GetVideoGameCategories } from "../../domain/usecase/GetVideoGameCategories"
import { GetVideoGameByName } from "../../domain/usecase/GetVideoGamesByName"
import { DeleteVideoGameById } from "../../domain/usecase/DeleteVideoGameByName"


export const useVideoGames = () => {
    const [videoGames, setVideoGames] = useState<VideoGame[]>([])
    const [categories, setCategories] = useState<string[]>([])
    const [selectedGame, setSelectedGame] = useState<VideoGame | null>(null)
    const [deletedVideoGame, setDeletedVideoGame] = useState<boolean>(false)

    useEffect(() => {
        GetVideoGames.execute().then(setVideoGames)
    }, [])

    useEffect(() => {
        GetVideoGameCategories.execute().then(setCategories)
    }, [])

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

    return { videoGames, selectedGame, categories, getVideoGameByName, deletedVideoGame, deleteVideoGame }
}