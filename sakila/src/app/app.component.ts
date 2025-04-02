import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CategoryListComponent } from './components/category-list/category-list.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CategoryListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'sakila';
}
