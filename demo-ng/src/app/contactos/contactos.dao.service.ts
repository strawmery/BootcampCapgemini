import { Injectable } from '@angular/core';
import { RESTDAOService } from './restdao.service';

@Injectable({
  providedIn: 'root',
})
export class ContactosDAOService extends RESTDAOService<any, any> {
  constructor() {
    super('contactos');
  }
}
