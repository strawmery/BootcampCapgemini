import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent implements OnInit{

  categories: any[] = [];
  newCategory: string = '';
  page = 0;
  size = 5;
  totalPages = 1;
  editCategory: any ={ id:null, name:''};

  constructor (private categoryService: CategoryService) {}

  ngOnInit() {
    this.obtenerCategorias();
  }

  obtenerCategorias() {
    this.categoryService.obtenerCategoriasPaginadas(this.page).subscribe(
      (data: any) => {
        this.categories = data;
      },
      (error) => console.error('Error obteniendo categorías:', error)
    );
  }

  paginaAnterior() {
    if (this.page > 0) {
      this.page--;
      this.obtenerCategorias();
    }
  }

  paginaSiguiente() {
    if (this.page < this.totalPages - 1) {
      this.page++;
      this.obtenerCategorias();
    }
  }

  crearCategorias(){
    if(this.newCategory.trim()){
      this.categoryService.crearCategorias({name: this.newCategory}).subscribe(() => {
        this.newCategory = '';
        this.obtenerCategorias();
      })
    }
  }

  prepararEdicion(category: any) {
    this.editCategory = { id: category.categoryId, name: category.name };
  }

  actualizarCategoria() {
    if (!this.editCategory.name.trim()) return;
    this.categoryService.actualizarCategoria(this.editCategory.id, { name: this.editCategory.name }).subscribe(() => {
      this.editCategory = { id: null, name: '' };
      this.obtenerCategorias();
    });
  }
  

  eliminarCategoria(id: number) {
    this.categoryService.eliminarCategoria(id).subscribe(() => {
      this.obtenerCategorias(); // Recargar lista
    });
  }

}
