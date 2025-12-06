# RideShare Backend - Mini Project

## Project Overview
This is a mini Ride Sharing backend using:
- Spring Boot
- MongoDB
- JWT Authentication
- Input Validation
- Global Exception Handling

## Folder Structure
```
src/
 ├── main/
 │    ├── java/
 │    │     └── org/example/rideshare/
 │    │           ├── model/
 │    │           ├── repository/
 │    │           ├── service/
 │    │           ├── controller/
 │    │           ├── config/
 │    │           ├── dto/
 │    │           ├── exception/
 │    │           └── util/
 │    └── resources/
 │            └── application.properties
```

## Running the Application
1. Start MongoDB locally.
2. Edit `application.properties` if needed.
3. Run the application:
```bash
mvn spring-boot:run
```
- Server will run at `http://localhost:8081`

## Endpoints
| Role       | Endpoint                                  | Action                    |
|------------|------------------------------------------|---------------------------|
| PUBLIC     | /api/auth/register                        | Create User               |
| PUBLIC     | /api/auth/login                           | Return JWT                |
| USER       | /api/v1/rides                             | Create Ride               |
| USER       | /api/v1/user/rides                        | View My Rides             |
| DRIVER     | /api/v1/driver/rides/requests             | View All Pending Rides    |
| DRIVER     | /api/v1/driver/rides/{id}/accept          | Accept Ride               |
| USER/DRIVER | /api/v1/rides/{id}/complete               | Complete Ride             |

### JWT Authentication
- Include in every request header:
```
Authorization: Bearer <JWT_TOKEN>
```
- Login flow:
  1. POST `/api/auth/login` → get JWT
  2. Store token in client
  3. Send with all protected requests

## Sample CURL Commands
**Register USER:**
```bash
curl -X POST http://localhost:8081/api/auth/register \
-H "Content-Type: application/json" \
-d '{"username":"john","password":"1234","role":"ROLE_USER"}'
```

**Register DRIVER:**
```bash
curl -X POST http://localhost:8081/api/auth/register \
-H "Content-Type: application/json" \
-d '{"username":"driver1","password":"abcd","role":"ROLE_DRIVER"}'
```

**Login:**
```bash
curl -X POST http://localhost:8081/api/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"john","password":"1234"}'
```

**Create Ride:**
```bash
curl -X POST http://localhost:8081/api/v1/rides \
-H "Authorization: Bearer <JWT_TOKEN>" \
-H "Content-Type: application/json" \
-d '{"pickupLocation":"Koramangala","dropLocation":"Indiranagar"}'
```

## Notes
- JWT secret must be at least 32 bytes in production.
- Lombok `@Data` is used for models. Enable Lombok in IDE.
- Passwords are **BCrypt encoded**.
- Global Exception Handler returns structured error JSON.
- Follow roles carefully: USERS create rides, DRIVERS accept rides.

## Authors
- Sneha Raj - Mini RideShare Backend for in-class project
