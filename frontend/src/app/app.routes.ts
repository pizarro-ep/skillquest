import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login';
import { Main } from './dashboard/main/main';
import { Challenges } from './pages/challenges/challenges';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'dashboard', component:  Main },
    { path: 'challenges', component:  Challenges },
    { path: '**', redirectTo: 'login' } // Redirección por defecto
];
