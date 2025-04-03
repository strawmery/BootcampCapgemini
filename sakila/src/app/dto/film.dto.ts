export class FilmDTO {
    filmId: number;
    title: string;
    releaseYear: number;
    languageId: number;
    rentalDuration: number;
    rentalRate: number;
    cost: number;
  
    constructor(
      filmId: number,
      title: string,
      releaseYear: number,
      languageId: number,
      rentalDuration: number,
      rentalRate: number,
      cost: number
    ) {
      this.filmId = filmId;
      this.title = title;
      this.releaseYear = releaseYear;
      this.languageId = languageId;
      this.rentalDuration = rentalDuration;
      this.rentalRate = rentalRate;
      this.cost = cost;
    }
  } 