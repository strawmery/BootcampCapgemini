import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FilmDTO } from '../../dto/film.dto';
import { FilmRequestDTO } from '../../dto/film-request.dto';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  private apiUrl = 'http://localhost:8080/film/v1';  // URL base para la API

  constructor(private http: HttpClient) { }

  obtenerPeliculas(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  actualizarPelicula(id: number, pelicula: FilmDTO): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, pelicula);
  }

  agregarPelicula(pelicula: FilmRequestDTO): Observable<any> {
    return this.http.post(this.apiUrl, pelicula);
  }

  eliminarPelicula(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }

  buscarPeliculas(tipo: string, valor: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/search?type=${tipo}&value=${valor}`);
  }
}

