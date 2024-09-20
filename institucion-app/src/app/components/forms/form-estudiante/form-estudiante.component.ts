import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Estudiante } from '../../../models/Estudiante';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'estudiante-form',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './form-estudiante.component.html'
})
export class FormEstudianteComponent {
  
  @Input() estudiante: Estudiante = {
    idEstudiante: 0,
    nombreEstudiante: ''
  };

  @Output() newEstudianteEvent = new EventEmitter();

  onSubmit(estudianteForm: NgForm): void {
    if(estudianteForm.valid){
      this.newEstudianteEvent.emit(this.estudiante);
    }
    estudianteForm.reset()
  }
  
  clean(): void{
     this.estudiante = {
      idEstudiante: 0,
      nombreEstudiante: ''
    };
  }
}
