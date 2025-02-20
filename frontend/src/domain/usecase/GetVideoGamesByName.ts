import { VideoGameRepository } from "../../data/repository/VideoGameRepository";
import { VideoGame } from "../entities/VideoGame";

export class GetVideoGameByName {
    static async execute(name : string) : Promise<VideoGame> {
        return await VideoGameRepository.getByName(name)
    }
}