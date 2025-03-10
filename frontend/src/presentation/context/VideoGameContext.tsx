import { createContext, useContext, useEffect, useState, ReactNode } from "react";
import { VideoGame } from "../../domain/entities/VideoGame";
import { GetVideoGames } from "../../domain/usecase/GetVideoGames";
import { GetVideoGameCategories } from "../../domain/usecase/GetVideoGameCategories";
import { GetVideoGameByName } from "../../domain/usecase/GetVideoGamesByName";
import { DeleteVideoGameById } from "../../domain/usecase/DeleteVideoGameByName";
import { GetVideoGamePlatforms } from "../../domain/usecase/GetVideoGamePlatforms";
import { GetVideoGameIdsByPlatformId } from "../../domain/usecase/GetVideoGamesIdsByPlatformId";
import { Platform } from "../../domain/entities/Platform";
import { useAuth } from "../context/AuthContext"; 

interface VideoGameContextType {
    videoGames: VideoGame[];
    categories: string[];
    platforms: Platform[];
    selectedGame: VideoGame | null;
    getVideoGameByName: (name: string) => Promise<void>;
    deleteVideoGame: (id: number) => Promise<boolean>;
    getVideoGameIdsByPlatformId: (id: number) => Promise<number[]>;
}

const VideoGameContext = createContext<VideoGameContextType | undefined>(undefined);

export const VideoGameProvider = ({ children }: { children: ReactNode }) => {
    const [videoGames, setVideoGames] = useState<VideoGame[]>([]);
    const [categories, setCategories] = useState<string[]>([]);
    const [platforms, setPlatforms] = useState<Platform[]>([]);
    const [selectedGame, setSelectedGame] = useState<VideoGame | null>(null);
    const { user } = useAuth(); 

    useEffect(() => {
        if (user) {
            GetVideoGames.execute().then(setVideoGames);
            GetVideoGameCategories.execute().then(setCategories);
            GetVideoGamePlatforms.execute().then(setPlatforms);
        } else {
            setVideoGames([]);
            setCategories([]);
            setPlatforms([]);
        }
    }, [user]);

    const getVideoGameByName = async (name: string) => {
        const game = await GetVideoGameByName.execute(name);
        setSelectedGame(game);
    };

    const deleteVideoGame = async (id: number) => {
        const result = await DeleteVideoGameById.execute(id);
        if (result) setVideoGames(prevGames => prevGames.filter(game => game.id !== id));
        return result;
    };

    const getVideoGameIdsByPlatformId = async (id: number) => {
        return await GetVideoGameIdsByPlatformId.execute(id);
    };

    return (
        <VideoGameContext.Provider value={{ videoGames, categories, platforms, selectedGame, getVideoGameByName, deleteVideoGame, getVideoGameIdsByPlatformId }}>
            {children}
        </VideoGameContext.Provider>
    );
};

export const useVideoGames = () => {
    const context = useContext(VideoGameContext);
    if (!context) {
        throw new Error("useVideoGames debe ser usado dentro de un VideoGameProvider");
    }
    return context;
};
