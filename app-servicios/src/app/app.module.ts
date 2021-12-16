import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistroComponent } from './pages/registro/registro.component';
import { AppRoutingModule } from './app-routing.module';
import { SesionComponent } from './pages/sesion/sesion.component';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { MenubarModule } from 'primeng/menubar';
import { RegistroServiciosComponent } from './pages/registro-servicios/registro-servicios.component';
import { EditarUsuarioComponent } from './pages/editar-usuario/editar-usuario.component';
import { EditarServicioComponent } from './pages/editar-servicio/editar-servicio.component';
import { ListadoServiciosComponent } from './pages/listado-servicios/listado-servicios.component';
import { EliminarServicioComponent } from './pages/eliminar-servicio/eliminar-servicio.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { MatTableModule } from '@angular/material/table';
import {FormsModule} from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistroComponent,
    SesionComponent,
    NavbarComponent,
    RegistroServiciosComponent,
    EditarUsuarioComponent,
    EditarServicioComponent,
    ListadoServiciosComponent,
    EliminarServicioComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MenubarModule,
    MatTableModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    CommonModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
