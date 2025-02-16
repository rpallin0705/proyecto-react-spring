import { VideoGameRepository } from "../../data/repository/VideoGameRepository";
import { VideoGame } from "../entities/VideoGame";

export class GetVideoGames {
    static async execute() : Promise<VideoGame[]> {
        return await VideoGameRepository.getAll()
    }
}