# PLATAFORMA DE APRENDIZAJE POR RETOS

Aplicación web diseñada con **Spring Boot** como backend. Esta idea, pretende destacar por su utilidad, gamificación y experiencia personalizada.

---

## 🌟 VISIÓN GENERAL DEL PROYECTO

### 🧠 **Nombre Tentativo:**
**"SkillQuest"** – Aprende superando retos, sube de nivel, gana medallas.

### 🎯 **Objetivo:**
Permitir a los usuarios aprender y practicar habilidades resolviendo **retos escalables**, agrupados por categorías (lógica, algoritmos, matemáticas, teoría, etc.), con un sistema de progresión tipo videojuego.

---

## 🧱 ARQUITECTURA DE ALTO NIVEL

### 📚 **Módulos funcionales:**

1. **Autenticación y Gestión de Usuarios**
   - Registro/login con JWT.
   - Roles: `STUDENT`, `ADMIN`.
   - Perfil: progreso, nivel, puntos, insignias.

2. **Retos (Challenges)**
   - CRUD de retos por nivel, categoría y tipo.
   - Tipos de reto: opción múltiple, input libre, código embebido.
   - Sistema de test automático (para ciertos tipos).

3. **Progresión del Usuario**
   - XP por reto completado.
   - Sistema de niveles (ej. 0–1000 XP = Nivel 1).
   - Medallas desbloqueadas por hitos.

4. **Ranking y Comunidad**
   - Tabla de clasificación por puntos o velocidad.
   - Ranking semanal y global.
   - Opción para seguir a otros usuarios (social learning).

5. **Sistema de Feedback**
   - Pistas automáticas o manuales por reto.
   - Calificación del reto por dificultad o calidad.

---

## 🧩 BASE DE DATOS - ENTIDADES PRINCIPALES

```plaintext
User
 ├─ id, username, email, password, role, xp, level
 └─ OneToMany: UserChallenge, Badge

Challenge
 ├─ id, title, description, level, category, solution, type (e.g., quiz, code)
 └─ OneToMany: Hint

UserChallenge
 ├─ id, user_id, challenge_id, status (PENDING, PASSED), submission, attempts, score

Badge
 ├─ id, name, description, icon_url, condition (xp, #challenges, etc.)

Hint
 ├─ id, challenge_id, text, condition (e.g. after 2 failed attempts)
```

---

## 🔌 API ENDPOINTS PRINCIPALES

```http
POST   /auth/register
POST   /auth/login
GET    /challenges                  → Todos los retos (paginados, filtrables)
GET    /challenges/{id}            → Detalles del reto
POST   /challenges/{id}/submit     → Enviar respuesta
GET    /users/me/progress          → Ver XP, nivel, retos completados
GET    /rankings                   → Ver tabla de clasificación
```

---

## 🔁 FLUJO DE USUARIO

1. Se registra → Comienza con XP = 0.
2. Accede a retos filtrados por nivel o categoría.
3. Intenta resolver un reto:
   - Si acierta: gana XP y puntos → puede subir de nivel.
   - Si falla: recibe pista → puede volver a intentar.
4. Progreso se guarda, recibe medallas automáticas al completar hitos.
5. Ranking lo compara con otros usuarios.

---

## 🎨 EXPERIENCIA GAMIFICADA

| Elemento             | Función                                                  |
|----------------------|-----------------------------------------------------------|
| **XP y Niveles**      | Aumentan al resolver retos, desbloquean nuevos niveles.   |
| **Medallas/Badges**   | Logros por completar 10 retos, ganar 1000 XP, etc.        |
| **Retos Diarios**     | Incentivo diario con bonificación de puntos.              |
| **Temporizador**      | Para medir eficiencia (opcional).                         |
| **Modo Historia**     | Serie de retos conectados con narrativa.                  |

---

## 🚀 POSIBLES EXTENSIONES

- **Evaluador de código** (Spring + Python service).
- **Editor de código en frontend** (Monaco Editor).
- **API de IA para pistas inteligentes.**
- **Modo cooperativo:** usuarios pueden resolver retos en equipo.
- **Generador automático de retos (admin).**

---

## 🧪 PRUEBAS Y CI/CD

- Unit tests (JUnit5).
- Tests de endpoints (MockMvc).
- Swagger/OpenAPI documentado.
- Dockerizado.
- CI/CD con GitHub Actions + despliegue en Render o Fly.io.

---

## 🧭 MVP en 3 fases

| Fase | Funcionalidades | Duración estimada |
|------|------------------|-------------------|
| 1    | Auth, CRUD de retos, envío de respuestas, XP y niveles | 1–2 semanas |
| 2    | Medallas, ranking, pistas, frontend simple | 1 semana |
| 3    | Editor de código, retos tipo algoritmo, daily quests | 2 semanas más |