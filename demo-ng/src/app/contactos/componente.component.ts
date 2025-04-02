import { DatePipe } from '@angular/common';
import {
  Component,
  forwardRef,
  Input,
  OnChanges,
  OnDestroy,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { FormsModule } from '@angular/forms';

import { ContactosViewModelService } from './ContactosViewModelService';
import { ErrorMessagePipe } from 'src/lib/my-core/pipes/cadenas.pipe';
import { TypeValidator } from 'src/lib/my-core/directives/mis-validadores.directive';
import { ActivatedRoute, ParamMap, Router, RouterLink } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-contactos',
  templateUrl: './tmpl-anfitrion.component.html',
  styleUrls: ['./componente.component.css'],
  imports: [
    forwardRef(() => ContactosAddComponent),
    forwardRef(() => ContactosEditComponent),
    forwardRef(() => ContactosViewComponent),
    forwardRef(() => ContactosListComponent),
  ],
})
export class ContactosComponent implements OnInit, OnDestroy {
  constructor(protected vm: ContactosViewModelService) {}
  public get VM(): ContactosViewModelService {
    return this.vm;
  }
  ngOnInit(): void {
    this.vm.list();
  }
  ngOnDestroy(): void {
    this.vm.clear();
  }
}

@Component({
  selector: 'app-contactos-list',
  templateUrl: './tmpl-list.component.html',
  styleUrls: ['./componente.component.css'],
  imports: [RouterLink],
})
export class ContactosListComponent implements OnInit, OnDestroy {
  constructor(protected vm: ContactosViewModelService) {}
  public get VM(): ContactosViewModelService {
    return this.vm;
  }
  ngOnInit(): void {
    this.vm.list();
  }
  ngOnDestroy(): void {
    this.vm.clear();
  }
}

@Component({
  selector: 'app-contactos-add',
  templateUrl: './tmpl-form.component.html',
  styleUrls: ['./componente.component.css'],
  imports: [FormsModule, TypeValidator, ErrorMessagePipe],
})
export class ContactosAddComponent implements OnInit {
  private obs$?: Subscription;
  constructor(
    protected vm: ContactosViewModelService,
    protected route: ActivatedRoute,
    protected router: Router
  ) {}
  public get VM(): ContactosViewModelService {
    return this.vm;
  }
  ngOnInit(): void {
    this.obs$ = this.route.paramMap.subscribe((params: ParamMap) => {
      const id = parseInt(params?.get('id') ?? '');
      if (id) {
        this.vm.edit(id);
      } else {
        this.router.navigate(['/404.html']);
      }
    });
  }
  ngOnDestroy(): void {
    this.obs$!.unsubscribe();
  }
}
@Component({
  selector: 'app-contactos-edit',
  templateUrl: './tmpl-form.component.html',
  styleUrls: ['./componente.component.css'],
  imports: [FormsModule, TypeValidator, ErrorMessagePipe],
})
export class ContactosEditComponent implements OnInit, OnDestroy {
  constructor(protected vm: ContactosViewModelService) {}
  public get VM(): ContactosViewModelService {
    return this.vm;
  }
  ngOnInit(): void {}
  ngOnDestroy(): void {}
}
@Component({
  selector: 'app-contactos-view',
  templateUrl: './tmpl-view.component.html',
  styleUrls: ['./componente.component.css'],
  imports: [DatePipe],
})
export class ContactosViewComponent implements OnChanges {
  @Input() id?: string;
  constructor(
    protected vm: ContactosViewModelService,
    protected router: Router
  ) {}
  public get VM(): ContactosViewModelService {
    return this.vm;
  }
  ngOnChanges(changes: SimpleChanges): void {
    if (this.id) {
      this.vm.view(+this.id);
    } else {
      this.router.navigate(['/404.html']);
    }
  }
}

export const CONTACTOS_COMPONENTES = [
  ContactosComponent,
  ContactosListComponent,
  ContactosAddComponent,
  ContactosEditComponent,
  ContactosViewComponent,
];
