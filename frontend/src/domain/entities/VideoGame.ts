export class VideoGame {
    constructor(
        public id: number,
        public name: string,
        public description: string,
        public price: number,
        public category: string,
        public urlImage: string,
        public urlCoverImage: string,
        public platformIds: number[]
    ) { }
}