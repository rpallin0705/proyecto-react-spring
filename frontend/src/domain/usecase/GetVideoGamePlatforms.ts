import { VideoGameRepository } from "../../data/repository/VideoGameRepository";

export class GetVideoGamePlatforms {
    static async execute() : Promise<number[]> {
        return await VideoGameRepository.getGamePlatforms()
    }
}