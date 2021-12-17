import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/Usuario';
import { UsuarioNuevo } from 'src/app/models/UsuarioNuevo';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  usuarioNuevo! : UsuarioNuevo;
  user: string = "nuevoUsuario";
  password: string = "123456";
  list : Usuario[] = [];

  constructor(
    private usuarioService: UsuarioService,
    private route: Router
    ) { }

  ngOnInit(): void {
   
  }

  onLogin():void{
    this.usuarioNuevo = new UsuarioNuevo(this.user,this.password);

    this.usuarioService.login().subscribe((data: Usuario[])=>{this.list = data});
    console.log("datos de lista", this.list);
    for(let dato in this.list){
      if(this.password == this.list[dato].pass && this.user == this.list[dato].user){
        let id_user_sesion = this.list[dato].id.toString();
        window.sessionStorage.removeItem("id_usuario_activo");
        window.sessionStorage.setItem("id_usuario_activo",id_user_sesion);
        console.log("el usuario es correcto");
        this.route.navigateByUrl('/sesion');
      }
      
    }
  }

}
