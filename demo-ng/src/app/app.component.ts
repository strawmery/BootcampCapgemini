import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoggerService } from '@my/core';
import { NotificationComponent, NotificationModalComponent } from './main';
import { NotificationService, NotificationType } from './common-services';
import { FormulariosComponent } from './examples/formularios/formularios.component';
import { ContactosComponent } from "./contactos/componente.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormulariosComponent, NotificationComponent, ContactosComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'world';

  // constructor(out: LoggerService) {
  //   out.error('Es un error')
  //   out.warn('Es un warn')
  //   out.info('Es un info')
  //   out.log('Es un log')
  // }
  
}
