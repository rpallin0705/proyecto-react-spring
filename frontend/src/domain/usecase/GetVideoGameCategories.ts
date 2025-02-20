import { VideoGameRepository } from "../../data/repository/VideoGameRepository";

export class GetVideoGameCategories {
    static async execute() : Promise<string[]> {
        return await VideoGameRepository.getCategories()
    }
}