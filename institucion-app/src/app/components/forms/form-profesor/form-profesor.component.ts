import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Profesor } from '../../../models/Profesor';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'profesor-form',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './form-profesor.component.html'
})
export class FormProfesorComponent {

  @Input() profesor: Profesor = {
    idProfesor: 0,
    nombreProfesor: ''
  };

  @Output() newProfesorEvent = new EventEmitter<Profesor>();

  onSubmit(profesorForm: NgForm): void {
    if (profesorForm.valid) {
      this.newProfesorEvent.emit(this.profesor);
    }
    profesorForm.resetForm(); 
    this.clean(); 
  }
  
  clean(): void {
    this.profesor = {
      idProfesor: 0,
      nombreProfesor: ''
    };
  }
}
