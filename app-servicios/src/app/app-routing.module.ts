import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegistroComponent } from './pages/registro/registro.component';
import { SesionComponent } from './pages/sesion/sesion.component';

const routes: Routes = [
 {path: 'login', component: LoginComponent},
 {path: 'registro', component: RegistroComponent},
 {path: 'sesion', component: SesionComponent},
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



