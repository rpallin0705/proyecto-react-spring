import { VideoGameRepository } from "../../data/repository/VideoGameRepository";

export class DeleteVideoGameById {
    static async execute(id: number) {
        return await VideoGameRepository.deleteById(id)
    }
}