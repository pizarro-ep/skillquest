import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Challenges } from './challenges';

@Injectable({ providedIn: 'root' })
export class ChallengeService {
  private apiUrl = `${environment.apiUrl}/challenges`;

  constructor(private http: HttpClient) {}

  getChallenges(token: string):Observable<any> {
    return this.http.get<Challenges[]>(this.apiUrl, {headers: { Authorization: `Bearer ${token}` }});
  }
}
