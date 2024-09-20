import { Estudiante } from "./Estudiante";
import { Profesor } from "./Profesor";

export class Nota {
  idNota!: number;
  nombreNota!: string;
  valor!: number;
  profesor!: Profesor;
  estudiante!: Estudiante;

  constructor() {
    this.profesor = new Profesor();
    this.estudiante = new Estudiante();
  }
}
