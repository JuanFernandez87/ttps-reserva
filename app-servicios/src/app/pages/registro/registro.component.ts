import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/Usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  nuevoUsuario! :Usuario;
  nombre!: string;
  apellido!: string;
  dni!: number;
  user!: string;
  mail!: string;
  pass!: string;
  fechaNac!: Date;
  
  constructor(private usuarioService: UsuarioService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    console.log("se ejecuto el metodo onCreate");
    this.nuevoUsuario = new Usuario(this.nombre, this.apellido,this.dni,this.user,this.pass,this.mail,this.fechaNac);
    this.usuarioService.nuevo(this.nuevoUsuario).subscribe(
      data => {
        this.router.navigate(['/lista']);
      });
  }

}
