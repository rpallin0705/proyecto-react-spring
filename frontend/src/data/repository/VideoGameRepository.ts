import { VideoGame } from "../../domain/entities/VideoGame";
import { fetchVideoGames, fetchVideoGamesByName, fetchVideoGamesCategories } from "../api/VideoGamesApi";
import { VideoGameDTO } from "../dto/VideoGameDTO";

export class VideoGameRepository {
    static async getAll() : Promise<VideoGame[]> {
        const dtos : VideoGameDTO[] = await fetchVideoGames()
        return dtos.map( dto => new VideoGame(dto.id, dto.name, dto.description, dto.price))
    }

    static async getByName(name : string) : Promise<VideoGame> {
        const dto : VideoGameDTO = await fetchVideoGamesByName(name)
        return new VideoGame(dto.id, dto.name, dto.description, dto.price)
    }

    static async getCategories() : Promise<String[]> {
        return  await fetchVideoGamesCategories()
    }
}