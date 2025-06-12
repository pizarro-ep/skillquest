import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class ChallengeService {
  private apiUrl = `${environment.apiUrl}/challenges`;

  constructor(private http: HttpClient) {}

  getChallenges(token: string) {
    return this.http.get<[]>(this.apiUrl, {
      headers: { Authorization: `Bearer ${token}` }
    });
  }
}
