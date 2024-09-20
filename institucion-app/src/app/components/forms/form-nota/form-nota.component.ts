import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Nota } from '../../../models/Nota';
import { Profesor } from '../../../models/Profesor';
import { Estudiante } from '../../../models/Estudiante';

@Component({
  selector: 'notas-form',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './form-nota.component.html'
})
export class FormNotaComponent {
  @Input() nota: Nota = {
    idNota: 0,
    nombreNota: '',
    valor: 0,
    profesor: new Profesor(),
    estudiante: new Estudiante()
  };

  @Output() newNotaEvent = new EventEmitter<Nota>();

  onSubmit(notaForm: NgForm): void {
    if (notaForm.valid) {
      this.newNotaEvent.emit(this.nota);
    }
    notaForm.resetForm();
    this.clean();
  }

  clean(): void {
    this.nota = {
      idNota: 0,
      nombreNota: '',
      valor: 0,
      profesor: new Profesor(),
      estudiante: new Estudiante()
    };
  }
}
