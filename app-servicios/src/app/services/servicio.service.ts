import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Servicio } from '../models/Servicio';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  private url: string = "http://localhost:8080/ttps-spring/servicios";

  constructor(private http: HttpClient) { }

  // obtener servicios   
  public lista(): Observable<Servicio[]> {
    return this.http.get<Servicio[]>(this.url + '/all');
   }

  // obtener un servicio por id
  public servicio(id: number): Observable<Servicio> {
    return this.http.get<Servicio>(this.url+'/'+id);
   }

  // crear servicio 
  public save(servicio: Servicio): Observable<any> {
    return this.http.post<Servicio[]>(this.url + '/nuevo', servicio);
   }

  // actulizar servicio  
  public update(id: number, servicio: Servicio): Observable<any> {
    return this.http.put<any>(this.url + id, servicio);
   }

  // borrar servicio
  public delete(id: number): Observable<any> {
    return this.http.delete<any>(this.url + id);
  }
}  
