import { Routes } from '@angular/router';
import { EstudiantesComponent } from './components/estudiantes/estudiantes.component';
import { ProfesoresComponent } from './components/profesores/profesores.component';
import { NotasComponent } from './components/notas/notas.component';

export const routes: Routes = [
  { path: 'estudiantes', component: EstudiantesComponent },
  { path: 'profesores', component: ProfesoresComponent },
  { path: 'notas', component: NotasComponent },
  { path: '', redirectTo: '/estudiantes', pathMatch: 'full' },
];
