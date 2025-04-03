import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
 
  private apiUrl = `${environment.apiUrl}/category/v1`;

  constructor(private http: HttpClient) { }

  obtenerCategorias(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl)
  }

  obtenerCategoriasPaginadas(page: number = 0, size: number = 10, sortBy: string = 'categoryId'): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}?page=${page}&size=${size}&sortBy=${sortBy}`);
  }

  obtenerCategoriaPorId(id: number): Observable<any[]> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  crearCategorias(categoria: {name:string}): Observable<any> {
    return this.http.post<any>(this.apiUrl, categoria);
  }

  actualizarCategoria(id: number, categoria: { name: string }): Observable<any> {
    if (id === null || id === undefined) {
      console.error("El ID de la categoría es inválido.");
      return throwError(() => new Error("El ID es inválido."));
    }
  
    return this.http.put<any>(`${this.apiUrl}/${id}`, categoria).pipe(
      catchError((error) => {
        console.error('Error al actualizar la categoría', error);
        return throwError(() => error);
      })
    );
  }

  eliminarCategoria(id:number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
