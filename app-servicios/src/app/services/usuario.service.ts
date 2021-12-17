import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/Usuario';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  
  URL = 'http://localhost:8080/ttps-spring/usuario';
  data = new Observable<Usuario[]>();

  constructor(private httpClient: HttpClient) { }

  public nuevo(nuevoUsuario: Usuario): Observable<any>{
    return this.httpClient.post<Usuario[]>(this.URL, nuevoUsuario);
  }

  login(): Observable<Usuario[]>{
    return this.data = this.httpClient.get<Usuario[]>(this.URL + '/all');
    
  }
 
}
