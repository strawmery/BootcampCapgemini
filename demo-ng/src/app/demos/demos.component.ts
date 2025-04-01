import { Component, computed, OnDestroy, OnInit, signal, ɵINPUT_SIGNAL_BRAND_WRITE_TYPE } from '@angular/core';
import { NotificationService, NotificationType } from '../common-services';
import { Unsubscribable } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-demos',
  imports: [FormsModule, CommonModule],
  templateUrl: './demos.component.html',
  styleUrl: './demos.component.css'
})
export class DemosComponent implements OnInit, OnDestroy{
  private fecha = new Date('2025-03-31');
  public readonly nombre = signal<string>('mundo')
  public readonly fontSize = signal<number>(24)
  public readonly listado = signal([
    {id:1, nombre: 'maria'},
    {id:2, nombre: 'adrian'},
    {id:3, nombre: 'oscar'},
    {id:4, nombre: 'luna'}
  ])
  public readonly idNombre = signal<number>(2)

  public resultado = signal<string>('')
  public visible = signal<boolean>(true)
  public invisible = computed<boolean>(() => !this.visible())
  public readonly estetica = signal({importante: true, urgente: true, error : false})

  private suscriptor: Unsubscribable | undefined;
  
  constructor(public vm: NotificationService) { }

  public get Fecha() : string { return this.fecha.toISOString(); }
  public set Fecha( value: Date){
    this.fecha = new Date(value)
  }

  saluda() {
    this.resultado.set('Hola ${this.nombre()}');
  }

  despide() {
    this.resultado.set('Adios ${this.nombre()}');
  }

  dice(algo: string ) {
    this.resultado.set('Dice ${algo}');
  }

  cambia( ) {
    this.resultado.update(valor => valor )
  }

  add(provincia: string) {
    const id = this.listado()[this.listado().length - 1].id + 1;
    this.listado.update(valor => [...valor, { id, nombre: provincia }]);
    this.idNombre.set(id);
  }

  calcula(a: number, b:number) { return a + b; }

  ngOnInit(): void {
    this.suscriptor = this.vm.Notificacion.subscribe(n => {
    if (n.Type !== NotificationType.error) { return; }
    window.alert(`Suscripción: ${n.Message}`);
    this.vm.remove(this.vm.Listado.length - 1);
    });
  }

  ngOnDestroy(): void {
    if (this.suscriptor) {
    this.suscriptor.unsubscribe();
    }
  }
}
