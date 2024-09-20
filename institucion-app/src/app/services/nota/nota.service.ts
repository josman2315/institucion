import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Nota } from '../../models/Nota';

@Injectable({
  providedIn: 'root',
})
export class NotaService {
  private url: string = 'http://localhost:8080/api/notas';

  constructor(private http: HttpClient) {}

  obtenerNotas(): Observable<Nota[]> {
    return this.http.get<Nota[]>(this.url);
  }

  guardarNota(nota: Nota): Observable<Nota> {
    return this.http.post<Nota>(this.url, nota);
  }

  actualizarNota(nota: Nota): Observable<Nota> {
    return this.http.put<Nota>(`${this.url}/${nota.idNota}`, nota);
  }

  eliminarNota(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
