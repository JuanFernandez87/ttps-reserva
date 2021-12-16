import { Component, OnInit, ViewChild  } from '@angular/core';
import { MatTable } from '@angular/material/table';

@Component({
  selector: 'app-listado-servicios',
  templateUrl: './listado-servicios.component.html',
  styleUrls: ['./listado-servicios.component.css']
})
export class ListadoServiciosComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  columnas: string[] = [ 'codigo', 'nombre', 'tipo', 'descripcion', 'url', 'ver', 'editar', 'borrar'];

  datos: Evento[] = [new Evento(1,'Nos casamos', 'Casamiento', 'El mejor casamiento de todos', 'https://www.casamientos.com.ar/'),
  new Evento(2, 'Mi fiesta de 15', 'Cumpleaños', 'El mejor cumpleaños de 15 de todos', 'https://www.cumpleaños.com.ar/'),
  new Evento(3, 'Fiesta dj Dero', 'Dj', 'El mejor dj de todos', 'https://www.dj.com.ar/')
  ];

  eventoselect: Evento = new Evento(0, "", "", "", "" );

  @ViewChild(MatTable) tabla1!: MatTable<Evento>;

  borrarFila(cod: number) {
    if (confirm("Realmente quiere borrarlo?")) {
      this.datos.splice(cod, 1);
      this.tabla1.renderRows();
    }
  }

  editarFila() {
     {

      this.tabla1.renderRows();
      // routerLink: ["/editar_servicio"],
    }
  }

  verFila() {

    this.tabla1.renderRows();
    // routerLink: ["/editar_servicio"],
     
    
    }
  }



  

export class Evento {
  constructor(public codigo: number, public nombre: string, public tipo: string, public descripcion: string, public url: string, ) {
  }
}

