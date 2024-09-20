import { Component } from '@angular/core';
import { Profesor } from '../../models/Profesor';
import { ProfesorService } from '../../services/profesor/profesor.service';
import { FormProfesorComponent } from '../forms/form-profesor/form-profesor.component';

@Component({
  selector: 'app-profesores',
  standalone: true,
  imports: [FormProfesorComponent],
  templateUrl: './profesores.component.html',
})
export class ProfesoresComponent {
  profesores: Profesor[] = [];

  profesorSeleccionado: Profesor = new Profesor();

  constructor(private service: ProfesorService) {}

  ngOnInit(): void {
    this.obtenerProfesores();
  }

  obtenerProfesores() {
    this.service
      .obtenerProfesores()
      .subscribe((profesores) => (this.profesores = profesores));
  }

  agregarProfesor(profesor: Profesor): void {
    if (profesor.idProfesor) {
      this.service
        .actualizarProfesor(profesor)
        .subscribe((profesorActualizado) => {
          this.profesores = this.profesores.map((prof) => {
            if (prof.idProfesor === profesorActualizado.idProfesor) {
              return { ...profesorActualizado };
            }
            return prof;
          });
        });
    } else {
      this.service.guardarProfesor(profesor).subscribe((nuevoProfesor) => {
        this.profesores = [...this.profesores, nuevoProfesor];
      });
    }
    this.profesorSeleccionado = new Profesor();
  }

  eliminarProfesor(id: number): void {
    this.service.eliminarProfesor(id).subscribe(() => {
      this.profesores = this.profesores.filter(
        (profesor) => profesor.idProfesor !== id
      );
    });
  }

  seleccionarProfesor(profesorRow: Profesor): void {
    this.profesorSeleccionado = { ...profesorRow };
  }
}
