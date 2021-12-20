import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Servicio } from 'src/app/models/Servicio';
import { ServicioService } from 'src/app/services/servicio.service';

@Component({
  selector: 'app-registro-servicios',
  templateUrl: './registro-servicios.component.html',
  styleUrls: ['./registro-servicios.component.css']
})
export class RegistroServiciosComponent implements OnInit {
  servicio!: Servicio;
  nombre: string = "Rico y abudante";
  tipo_servicio:string = "Food truck";
  descripcion:string = "El mejor food truck de todos";
  url:string = "https://www.ricoyabundante.com.ar/%27";
  facebook:string = "www.facebook.com";
  instagram!:string;
  twitter!:string;

  constructor(
    private servicioService: ServicioService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  registrarServicio():void{
    console.log("se ejecuto el metodo registrar servicio");
    this.servicio = new Servicio(this.nombre,this.tipo_servicio,this.descripcion,this.url);
    this.servicio.id_usuario = sessionStorage.getItem("id_usuario_activo");
    let data = this.servicioService.save(this.servicio);
    data.subscribe(err => console.log('HTTP Error', err));
    this.router.navigateByUrl("/listado_servicios");
  }
}
