import { Component, OnInit, ViewChild  } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Servicio } from 'src/app/models/Servicio';
import { ServicioService } from 'src/app/services/servicio.service';

@Component({
  selector: 'app-listado-servicios',
  templateUrl: './listado-servicios.component.html',
  styleUrls: ['./listado-servicios.component.css']
})
export class ListadoServiciosComponent implements OnInit {

  constructor(
    private servicioService: ServicioService
  ) { }

  ngOnInit(): void {
    this.getServicios();
  }

  columnas: string[] = [ 'codigo', 'nombre', 'tipo', 'descripcion', 'url', 'ver', 'editar', 'borrar'];

  datos: Servicio[] = [];

  private getServicios():void{
    this.servicioService.lista().subscribe((data: Servicio[])=>{
      this.datos = data;
    });
  }

  //eventoselect: Evento = new Evento(0, "", "", "", "" );

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

