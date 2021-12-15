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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistroComponent,
    SesionComponent,
    NavbarComponent,
    RegistroServiciosComponent,
    EditarUsuarioComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MenubarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
