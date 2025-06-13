import { Component, effect, inject, OnInit } from '@angular/core';
import { Challenge } from '../../services/challenges';
import { ChallengeService } from '../../services/challenges';
import { CommonModule } from '@angular/common';
import { AuthService, tokenSignal } from '../../services/auth';
import { Observable, of, switchMap } from 'rxjs';

@Component({
    selector: 'app-challenges',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './challenges.html',
    styleUrl: './challenges.css'
})
export class Challenges {
    challenges$!: Observable<Challenge[]>;
    private challengeService = inject(ChallengeService);
    private authService = inject(AuthService);

    constructor() {
        effect(() => {
            const token = tokenSignal();
            if (!token) return;

            this.challenges$ = of(this.authService.getToken()).pipe(
                switchMap(token => this.challengeService.getChallenges(""))
            );
        });
    }
}
