import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Challenge {
  id: number;
  title: string;
  description: string;
}

@Injectable({
  providedIn: 'root'
})
export class ChallengeService {
  private apiUrl = `${environment.apiUrl}/challenges`;
  private challenges: Challenge[] = [
    { id: 1, title: 'Desafío 1', description: 'Descripción del desafío 1' },
    { id: 2, title: 'Desafío 2', description: 'Descripción del desafío 2' },
    { id: 3, title: 'Desafío 3', description: 'Descripción del desafío 3' },
    { id: 4, title: 'Desafío 4', description: 'Descripción del desafío 4' },
    { id: 5, title: 'Desafío 5', description: 'Descripción del desafío 5' },
  ];

  constructor(private http: HttpClient) { }

  getChallenges(token: string): Observable<any> {
    return this.http.get<Challenge[]>(this.apiUrl);
  }

}
