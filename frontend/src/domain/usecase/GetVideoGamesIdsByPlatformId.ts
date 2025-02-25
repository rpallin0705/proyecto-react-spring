import { VideoGameRepository } from "../../data/repository/VideoGameRepository";

export class GetVideoGameIdsByPlatformId {
    static async execute(id: number): Promise<number[]> {
        return await VideoGameRepository.getVideoGameIdsByPlatform(id)
    }
}