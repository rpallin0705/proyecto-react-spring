import { VideoGameRepository } from "../../data/repository/VideoGameRepository";
import { Platform } from "../entities/Platform";

export class GetVideoGamePlatforms {
    static async execute() : Promise<Platform[]> {
        return await VideoGameRepository.getGamePlatforms()
    }
}