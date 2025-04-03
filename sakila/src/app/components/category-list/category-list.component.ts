import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CategoryService } from '../../services/category/category.service';

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css',
})
export class CategoryListComponent implements OnInit {
  categories: any[] = [];
  newCategory: string = '';
  page = 0;
  size = 5;
  totalPages = 1;
  editCategory: any = { id: null, name: '' };
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private categoryService: CategoryService) {}

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

  crearCategorias() {
    if (!this.newCategory) {
      console.error('El nombre de la categoría no puede estar vacío');
      return;
    }

    const categoria = { name: this.newCategory }; // Solo enviar el nombre
    this.categoryService.crearCategorias(categoria).subscribe(
      (data) => {
        console.log('Categoría creada con éxito:', data);
        this.obtenerCategorias();
      },
      (error) => {
        console.error('Error al crear categoría:', error);
      }
    );
  }

  prepararEdicion(category: any) {
    this.editCategory = { id: category.categoryId, name: category.name };
  }

  actualizarCategoria(): void {
    console.log('Datos que se van a enviar: ', this.editCategory);

    if (!this.editCategory.name.trim()) {
      console.error('El nombre de la categoría no puede estar vacío');
      return;
    }

    this.categoryService
      .actualizarCategoria(this.editCategory.id!, this.editCategory)
      .subscribe({
        next: (response) => {
          this.successMessage = 'Categoría actualizada con éxito!';
          this.errorMessage = '';
          this.editCategory = { id: null, name: '' };
          this.obtenerCategorias();
        },
        error: (error) => {
          this.successMessage = '';
          this.errorMessage ='Hubo un problema al actualizar la categoría. Intenta nuevamente.';
        },
      });
  }

  eliminarCategoria(id: number) {
    this.categoryService.eliminarCategoria(id).subscribe(() => {
      this.obtenerCategorias();
    });
  }
}
