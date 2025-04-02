import { HttpContextToken } from '@angular/common/http';
import { Injectable } from '@angular/core';

export type ModoCRUD = 'list' | 'add' | 'edit' | 'view' | 'delete';
export const AUTH_REQUIRED = new HttpContextToken<boolean>(() => false);

@Injectable({
  providedIn: 'root'
})


export class ServiciosService {


  

  constructor() { }
}
