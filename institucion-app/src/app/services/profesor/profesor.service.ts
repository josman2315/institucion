import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profesor } from '../../models/Profesor';

@Injectable({
  providedIn: 'root',
})
export class ProfesorService {
  private url = 'http://localhost:8080/api/profesores';

  constructor(private http: HttpClient) {}

  obtenerProfesores(): Observable<Profesor[]> {
    return this.http.get<Profesor[]>(this.url);
  }

  guardarProfesor(profesor: Profesor): Observable<Profesor> {
    return this.http.post<Profesor>(this.url, profesor);
  }

  actualizarProfesor(profesor: Profesor): Observable<Profesor> {
    return this.http.put<Profesor>(
      `${this.url}/${profesor.idProfesor}`,
      profesor
    );
  }

  eliminarProfesor(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
