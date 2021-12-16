import { Component, OnInit } from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  items!: MenuItem[];

  ngOnInit() {
      this.items = [
          {
              label:'Editar usuario',
              icon:'pi pi-fw pi-pencil',
              routerLink: ["/editar_usuario"],
          },
          {
              label:'Servicios ',
              icon:'pi pi-fw pi-calendar-times',
              items:[
                  {
                      label:'Lista',
                      icon:'pi pi-fw pi-caret-right',
                      routerLink: ["/listado_servicios"],

                  },                  
                  {
                      label:'Nuevo',
                      icon:'pi pi-fw pi-caret-right',
                      routerLink: ["/registro_servicio"],

                  },
                  {
                    label:'Editar',
                    icon:'pi pi-fw pi-caret-right',
                    routerLink: ["/editar_servicio"],

                },
                
              ]
          },
          {
              label:'Cerrar sesión',
              icon:'pi pi-fw pi-power-off',
              routerLink: ["/login"],
          }
      ];
  }

}
