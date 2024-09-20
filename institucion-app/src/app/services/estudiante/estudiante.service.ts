import { Injectable } from '@angular/core';
import { Estudiante } from '../../models/Estudiante';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class EstudianteService {
  private url: string = 'http://localhost:8080/api/estudiantes';

  constructor(private http: HttpClient) {}

  obtenerEstudiantes(): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(this.url);
  }

  guardarEstudiante(estudiante: Estudiante): Observable<Estudiante> {
    return this.http.post<Estudiante>(this.url, estudiante);
  }

  actualizarEstudiante(estudiante: Estudiante): Observable<Estudiante> {
    return this.http.put<Estudiante>(
      `${this.url}/${estudiante.idEstudiante}`,
      estudiante
    );
  }

  eliminarEstudiante(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
