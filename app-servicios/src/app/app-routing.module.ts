import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegistroComponent } from './pages/registro/registro.component';
import { SesionComponent } from './pages/sesion/sesion.component';
import { RegistroServiciosComponent } from './pages/registro-servicios/registro-servicios.component'; 
import { EditarUsuarioComponent } from './pages/editar-usuario/editar-usuario.component';
import { EditarServicioComponent } from './pages/editar-servicio/editar-servicio.component';
import { ListadoServiciosComponent } from './pages/listado-servicios/listado-servicios.component';

const routes: Routes = [
 {path: 'login', component: LoginComponent},
 {path: 'registro', component: RegistroComponent},
 {path: 'sesion', component: SesionComponent},
 {path: 'registro_servicio', component: RegistroServiciosComponent},
 {path: 'editar_usuario', component: EditarUsuarioComponent},
 {path: 'editar_servicio', component: EditarServicioComponent},
 {path: 'listado_servicios', component: ListadoServiciosComponent},
 { path: '**', redirectTo: 'login', pathMatch: 'full'},
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }



