import { Component, OnInit, ViewChild  } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Router } from '@angular/router';
import { Servicio } from 'src/app/models/Servicio';
import { ServicioService } from 'src/app/services/servicio.service';

@Component({
  selector: 'app-listado-servicios',
  templateUrl: './listado-servicios.component.html',
  styleUrls: ['./listado-servicios.component.css']
})
export class ListadoServiciosComponent implements OnInit {
  servicio!: Servicio;
  nombre: string = "Rico y abudante-edit";
  tipo_servicio:string = "Food truck-edit";
  descripcion:string = "El mejor food truck de todos-edit";
  url:string = "https://www.ricoyabundante.com.ar/%27";

  constructor(
    private servicioService: ServicioService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getServicios();
  }

  columnas: string[] = [ 'codigo', 'nombre', 'tipo', 'descripcion', 'url', 'editar', 'borrar'];

  datos: Servicio[] = [];

  private getServicios():void{
    this.servicioService.lista().subscribe((data: Servicio[])=>{
      this.datos = data;
    });
  }

  //eventoselect: Evento = new Evento(0, "", "", "", "" );

  @ViewChild(MatTable) tabla1!: MatTable<Evento>;

  borrarFila(cod: number) {
    console.log("contenido de cod: ", this.datos[cod]);
    this.servicioService.delete(this.datos[cod].id);
    if (confirm("Realmente quiere borrarlo?")) {
      this.datos.splice(cod, 1);
      this.tabla1.renderRows();
    }
  }

  editarFila(fila: number) {
      this.servicio = new Servicio(this.nombre,this.tipo_servicio,this.descripcion,this.url);
      this.servicioService.update(this.datos[fila].id,this.servicio);
      this.tabla1.renderRows();

  }

  }



  

export class Evento {
  constructor(public codigo: number, public nombre: string, public tipo: string, public descripcion: string, public url: string, ) {
  }
}

