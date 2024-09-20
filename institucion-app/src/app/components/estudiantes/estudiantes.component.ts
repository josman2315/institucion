import { Component, OnInit } from '@angular/core';
import { EstudianteService } from '../../services/estudiante/estudiante.service';
import { Estudiante } from '../../models/Estudiante';
import { FormEstudianteComponent } from "../forms/form-estudiante/form-estudiante.component";

@Component({
  selector: 'app-estudiantes',
  standalone: true,
  imports: [FormEstudianteComponent],
  templateUrl: './estudiantes.component.html'
})
export class EstudiantesComponent implements OnInit {
  estudiantes: Estudiante[] = [];

  estudianteSeleccionado: Estudiante = new Estudiante;

  constructor(private service: EstudianteService) { }

  ngOnInit(): void {
    this.obtenerEstudiantes();
  }

  obtenerEstudiantes() {
    this.service.obtenerEstudiantes().subscribe(estudiantes => this.estudiantes = estudiantes);
  }


  agregarEstudiante(estudiante: Estudiante): void {
    if(estudiante.idEstudiante > 0){
        this.service.actualizarEstudiante(estudiante).subscribe( estudianteActualizado =>{
          this.estudiantes = this.estudiantes.map(est =>{
            if(est.idEstudiante == estudiante.idEstudiante){
              return { ...estudianteActualizado };
            }
            return est;
          });
        });
    }else{
      this.service.guardarEstudiante(estudiante).subscribe(estudianteNew => {
        this.estudiantes = [... this.estudiantes, { ...estudianteNew }];
      })
    }
    this.estudianteSeleccionado = new Estudiante();
  }


  eliminarEstudiante(id: number): void{
    this.service.eliminarEstudiante(id).subscribe(() =>{
      this.estudiantes = this.estudiantes.filter(estudiante => estudiante.idEstudiante != id);
    })
  }

  seleccionarEstudiante(estudianteRow: Estudiante){
    this.estudianteSeleccionado = {... estudianteRow};
  }

}