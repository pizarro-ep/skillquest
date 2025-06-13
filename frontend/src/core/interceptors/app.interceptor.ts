import { HttpInterceptorFn } from '@angular/common/http';

export const AppInterceptor: HttpInterceptorFn = (req, next) => {
  if (typeof localStorage === 'undefined') return next(req); // evitar error SSR

  const token = localStorage.getItem('token');
  if (!token) return next(req);

  const authReq = req.clone({
    setHeaders: { Authorization: `Bearer ${token}` }
  });

  return next(authReq);
};

