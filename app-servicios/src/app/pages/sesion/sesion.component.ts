import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Servicio } from 'src/app/models/Servicio';
import { ServicioService } from 'src/app/services/servicio.service';

@Component({
  selector: 'app-sesion',
  templateUrl: './sesion.component.html',
  styleUrls: ['./sesion.component.css']
})
export class SesionComponent implements OnInit {
  
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

  @ViewChild(MatTable) tabla1!: MatTable<Servicio>;

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

