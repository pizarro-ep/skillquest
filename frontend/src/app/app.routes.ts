import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login';
import { Main } from './dashboard/main/main';
import { ChallengesListComponent } from './challenges/list/list';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'dashboard', component:  Main },
    { path: 'challenges', component:  ChallengesListComponent },
    { path: '**', redirectTo: 'login' } // Redirección por defecto
];
