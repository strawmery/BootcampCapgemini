import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilmDTO } from '../../dto/film.dto';
import { FilmService } from '../../services/film/film.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-pelicula',
  imports: [FormsModule, CommonModule],
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css']
})
export class FilmListComponent implements OnInit {

  Films: any[] = [];
  newFilm = {
    title: '',
    releaseYear: 0,
    languageId: 0,
    rentalDuration: 0,
    rentalRate: 0,
    cost: 0
  };
  editFilm: FilmDTO = { filmId: 0, title: '', releaseYear: 0, languageId: 0, rentalDuration: 0, rentalRate: 0, cost: 0 };

  constructor(private filmService: FilmService) { }

  ngOnInit(): void {
    this.obtenerPeliculas();
  }

  obtenerPeliculas(): void {
    this.filmService.obtenerPeliculas().subscribe((data) => {
      this.Films = data;
    });
  }

  prepararEdicion(pelicula: any): void {
    this.editFilm = { filmId: pelicula.filmId, title: pelicula.title, releaseYear: pelicula.releaseYear, languageId: pelicula.language.languageId, rentalDuration: pelicula.rentalDuration, rentalRate: pelicula.rentalRate, cost: pelicula.replacementCost };
  }

  actualizarPelicula(): void {
    if (!this.editFilm.title.trim()) return;
    this.filmService.actualizarPelicula(this.editFilm.filmId, this.editFilm).subscribe(() => {
      this.obtenerPeliculas();
    });
  }

  eliminarPelicula(id: number): void {
    this.filmService.eliminarPelicula(id).subscribe(() => {
      this.obtenerPeliculas();
    });
  }

  agregarPelicula(): void {
    this.filmService.agregarPelicula(this.editFilm).subscribe(() => {
      this.obtenerPeliculas();
    });
  }
}

