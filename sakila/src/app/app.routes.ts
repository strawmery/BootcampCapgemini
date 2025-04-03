import { RouterModule, Routes } from '@angular/router';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { FilmListComponent } from './components/Film-list/film-list.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    { path: 'categorias', component: CategoryListComponent},
    { path: 'peliculas', component: FilmListComponent},
    { path: '', redirectTo: '/peliculas', pathMatch: 'full' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
