import { HttpClient } from '@angular/common/http';
import { Injectable, signal } from '@angular/core';
import { environment } from '../../environments/environment';

export const tokenSignal = signal<string | null>(null);

@Injectable({
  providedIn: 'root'  // ✅ Esto es lo que faltaba
})
export class AuthService {
  private apiUrl = `${environment.apiUrl}/auth/login`;

  constructor(private http: HttpClient) {
    const token = typeof localStorage !== 'undefined' ? localStorage.getItem('token') : null;
    tokenSignal.set(token);
  }


  login(username: string, password: string) {
    return this.http.post<{ token: string }>(this.apiUrl, { username, password });
  }

  getToken() {
    return tokenSignal();
  }
}
