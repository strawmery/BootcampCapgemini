import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
 
  private apiUrl = '${enviroment.apiUrl}/category/v1';

  constructor(private http: HttpClient) { }

  obtenerCategorias(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl)
  }

  obtenerCategoriasPaginadas(page: number = 0, size: number = 10, sortBy: string = 'categoryId'): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}?page=${page}&size=${size}&sortBy=${sortBy}`);
  }

  obtenerCategoriaPorId(id: number): Observable<any[]> {
    return this.http.get<any>('${this.apiUrl}/${id}');
  }

  crearCategorias(categoria: {name:string}): Observable<any> {
    return this.http.post<any>(this.apiUrl, categoria);
  }

  actualizarCategoria(id:number, categoria: {name: string}): Observable<any> {
    return this.http.put<any>('${this.apiUrl}/${id}', categoria);
  }

  eliminarCategoria(id:number): Observable<any> {
    return this.http.delete<any>('${this.apiUrl}/${id');
  }
}
