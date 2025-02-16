import { VideoGameRepository } from "../../data/repository/VideoGameRepository";

export class GetVideoGameCategories {
    static async execute() : Promise<String[]> {
        return await VideoGameRepository.getCategories()
    }
}