export class FilmRequestDTO {
    title: string;
    releaseYear: number;
    languageId: number;
    rentalDuration: number;
    rentalRate: number;
    cost: number;
  
    constructor(
      title: string = '',
      releaseYear: number = new Date().getFullYear(),
      languageId: number = 1, // Un valor por defecto, puedes ajustarlo
      rentalDuration: number = 1,
      rentalRate: number = 0,
      cost: number = 0
    ) {
      this.title = title;
      this.releaseYear = releaseYear;
      this.languageId = languageId;
      this.rentalDuration = rentalDuration;
      this.rentalRate = rentalRate;
      this.cost = cost;
    }
  }
  