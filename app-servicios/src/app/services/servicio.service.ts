import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Servicio } from '../models/Servicio';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  URL = "http://localhost:8080/ttps-spring/servicios";

  constructor(private http: HttpClient) { }

  // obtener servicios   
  public lista(): Observable<Servicio[]> {
    return this.httpClient.get<Servicio[]>(this.URL + '/servicios/'+  window.sessionStorage.getItem("id_usuario_activo"));
  }

  // obtener un servicio por id
  public servicio(id: number): Observable<Servicio> {
    return this.http.get<Servicio>(this.url+'/'+id);
   }

  // crear servicio 
  public save(servicio: Servicio): Observable<any> {
    console.log("se ejecuto el metodo del service");
    return this.httpClient.post<Servicio[]>(this.URL + '/nuevo', servicio);
  }

  // actulizar servicio  
  public update(id: number, servicio: Servicio): Observable<any> {
    console.log("editado");
    return this.httpClient.put<any>(this.URL + id, servicio);
  }

  // borrar servicio
  public delete(id: number): Observable<any> {
    console.log(`/${id}`);
    return this.httpClient.delete<any>(this.URL + `/${id}`);
  }
}  
