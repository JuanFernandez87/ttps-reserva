import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Servicio } from '../models/Servicio';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  URL = "http://localhost:8080/ttps-spring/servicios/nuevo";

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Servicio[]> {
    return this.httpClient.get<Servicio[]>(this.URL + '/all');
  }

  public save(servicio: Servicio): Observable<any> {
    console.log("se ejecuto el metodo del service");
    return this.httpClient.post<Servicio[]>(this.URL, servicio);
  }

  public update(id: number, servicio: Servicio): Observable<any> {
    return this.httpClient.put<any>(this.URL + id, servicio);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.URL + id);
  }
}
