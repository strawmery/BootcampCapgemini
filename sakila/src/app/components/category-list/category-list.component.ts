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

  category: any[] = [];
  newCategory: string = '';
  page = 0;
  size = 5;
  totalPages = 0;
  editCategory: any ={ id:null, name:''};

  constructor (private categoryService: CategoryService) {}

  ngOnInit() {
    this.obtenerCategorias();
  }

  obtenerCategorias() {
    this.categoryService.obtenerCategoriasPaginadas(this.page, this.size).subscribe(data => {
      this.category = data.content;
      this.totalPages = data.totalPages;
    });
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
        this.obtenerCategorias();
        this.newCategory = '';
      })
    }
  }

  prepararEdicion(categoria: any) {
    this.editCategory = { id: categoria.categoryId, name: categoria.name };
  }

  actualizarCategoria() {
    if (this.editCategory.name.trim()) {
      this.categoryService.actualizarCategoria(this.editCategory.id, { name: this.editCategory.name })
        .subscribe(() => {
          this.obtenerCategorias();
          this.editCategory = { id: null, name: '' };
        });
    }
  }
  

  eliminarCategoria(id: number) {
    this.categoryService.eliminarCategoria(id).subscribe(() => {
      this.obtenerCategorias(); // Recargar lista
    });
  }

}
