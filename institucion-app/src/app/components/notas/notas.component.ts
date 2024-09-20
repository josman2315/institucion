import { Component } from '@angular/core';
import { NotaService } from '../../services/nota/nota.service';
import { Nota } from '../../models/Nota';
import { FormNotaComponent } from '../forms/form-nota/form-nota.component';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-notas',
  standalone: true,
  imports: [FormNotaComponent,NgFor],
  templateUrl: './notas.component.html',
})
export class NotasComponent {
  notas: Nota[] = [];

  notaSeleccionada: Nota = new Nota();

  constructor(private service: NotaService) {}

  ngOnInit(): void {
    this.obtenerNotas();
  }

  obtenerNotas() {
    this.service.obtenerNotas().subscribe((notas) => (this.notas = notas));
  }

  agregarNota(nota: Nota): void {
    if (nota.idNota > 0) {
      this.service.actualizarNota(nota).subscribe((notaActualizada) => {
        this.notas = this.notas.map((nta) => {
          if (nta.idNota == nota.idNota) {
            return { ...notaActualizada };
          }
          return nta;
        });
      });
    } else {
      this.service.guardarNota(nota).subscribe((notaNew) => {
        this.notas = [...this.notas, { ...notaNew }];
      });
    }
    this.notaSeleccionada = new Nota();
  }

  eliminarNota(id: number): void {
    this.service.eliminarNota(id).subscribe(() => {
      this.notas = this.notas.filter((nota) => nota.idNota != id);
    });
  }

  seleccionarNota(notaRow: Nota) {
    this.notaSeleccionada = { ...notaRow };
  }

}
