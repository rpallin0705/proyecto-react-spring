import { useEffect, useState } from "react"
import { VideoGame } from "../../domain/entities/VideoGame"
import { GetVideoGames } from "../../domain/usecase/GetVideoGames"
import { GetVideoGameCategories } from "../../domain/usecase/GetVideoGameCategories"
import { GetVideoGameByName } from "../../domain/usecase/GetVideoGamesByName"
import { DeleteVideoGameById } from "../../domain/usecase/DeleteVideoGameByName"
import { GetVideoGamePlatforms } from "../../domain/usecase/GetVideoGamePlatforms"
import { GetVideoGameIdsByPlatformId } from "../../domain/usecase/GetVideoGamesIdsByPlatformId"


export const useVideoGames = () => {

    const [videoGames, setVideoGames] = useState<VideoGame[]>([])
    const [categories, setCategories] = useState<string[]>([])
    const [platforms, setPlatforms] = useState<number[]>([])
    const [selectedGame, setSelectedGame] = useState<VideoGame | null>(null)
    const [deletedVideoGame, setDeletedVideoGame] = useState<boolean>(false)
    const [filteredVideoGames, setFilteredVideogames] = useState<VideoGame[]>()
    const [selectedPlatform, setSelectedPlatform] = useState<number | null>(null)
    const [platformGameIds, setPlatformGameIds] = useState<number[]>([])

    useEffect(() => {
        GetVideoGames.execute().then(setVideoGames)
    }, [])

    useEffect(() => {
        GetVideoGameCategories.execute().then(setCategories)
    }, [])

    useEffect(() => {
        GetVideoGamePlatforms.execute().then(setPlatforms)
    }, [])

    useEffect(() => {
        if (selectedPlatform !== null) {
            GetVideoGameIdsByPlatformId.execute(selectedPlatform).then(setPlatformGameIds)
        }
    }, [selectedPlatform])

    useEffect(() => {
        if (platformGameIds.length > 0) {
            videoGames.filter(game => platformGameIds.includes(game.id))
        } else {
            setFilteredVideogames(videoGames)
        }
    }, [platformGameIds, videoGames])

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
        videoGames, filteredVideoGames, selectedGame
        , categories, platforms, selectedPlatform
        , setSelectedPlatform, getVideoGameByName
        , deletedVideoGame, deleteVideoGame
    }
}