import { Platform } from "../../domain/entities/Platform";
import { VideoGame } from "../../domain/entities/VideoGame";
import { fetchVideoGames, fetchVideoGamesByName, fetchVideoGamesCategories, deleteVideoGameById, getVideoGamePlatforms, getVideoGameIdsByPlatformId } from "../api/VideoGamesApi";
import { VideoGameDTO } from "../dto/VideoGameDTO";

export class VideoGameRepository {
    static async getAll() : Promise<VideoGame[]> {
        const dtos : VideoGameDTO[] = await fetchVideoGames()
        return dtos.map( dto => new VideoGame(dto.id, dto.name, dto.description, dto.price, dto.category, dto.vgCoverImage, dto.vgImage, dto.platformsIds))
    }

    static async getByName(name : string) : Promise<VideoGame> {
        const dto : VideoGameDTO = await fetchVideoGamesByName(name)
        return new VideoGame(dto.id, dto.name, dto.description, dto.price, dto.category, dto.vgCoverImage, dto.vgImage, dto.platformsIds)
    }

    static async getCategories() : Promise<string[]> {
        return  await fetchVideoGamesCategories()
    }

    static async deleteById(id: number): Promise<boolean> {
        return await deleteVideoGameById(id); 
    } 

    static async getGamePlatforms() : Promise<Platform[]> {
        return await getVideoGamePlatforms()
    }

    static async getVideoGameIdsByPlatform(id : number) : Promise<number[]> {
        return await getVideoGameIdsByPlatformId(id)
    }
}