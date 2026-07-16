# Week 3 — Spring REST using Spring Boot 3 (Mandatory)

**spring-learn** — a Spring Boot 3 REST project covering the Week 3 mandatory hands-on:
Hello World service, Country services (bean loaded from Spring XML), get-country-by-code,
and JWT authentication.

## Run

```bash
mvn spring-boot:run       # starts on http://localhost:8083
mvn test                  # runs the MockMvc test
```

## Endpoints

| Method | URL | Auth | Description |
|--------|-----|------|-------------|
| GET  | `/hello` | public | returns `Hello World!!` |
| POST | `/authenticate` | public | body `{"username":"user","password":"pwd123"}` → returns a JWT |
| GET  | `/country` | JWT | India, loaded from `country.xml` |
| GET  | `/countries` | JWT | all countries |
| GET  | `/country/{code}` | JWT | one country by code, e.g. `/country/IN` |

## Try it (curl)

```bash
# 1. public hello
curl http://localhost:8083/hello

# 2. get a token
curl -X POST http://localhost:8083/authenticate \
     -H "Content-Type: application/json" \
     -d '{"username":"user","password":"pwd123"}'

# 3. call a protected endpoint with the token
curl http://localhost:8083/countries -H "Authorization: Bearer <PASTE_TOKEN_HERE>"
```

## Mandatory hands-on → where

| Exercise (from the official xlsx) | Where |
|-----------------------------------|-------|
| Create a Spring Web Project using Maven | `pom.xml`, `SpringLearnApplication` |
| Spring Core – Load Country from Spring Configuration XML | `country.xml` + `CountryService.getCountry()` |
| Hello World RESTful Web Service | `HelloController` |
| REST – Country Web Service | `CountryController.getCountryIndia()` |
| REST – Get country based on country code | `CountryController.getCountry(code)` |
| Create authentication service that returns JWT | `AuthController` + `JwtUtil` + `JwtRequestFilter` + `SecurityConfig` |

## Note on Spring Security version
The handbook was written for Spring Security 5 (`WebSecurityConfigurerAdapter`). This project
targets **Spring Boot 3 / Security 6**, where that class was removed — so security is configured
with a `SecurityFilterChain` bean, which is the current recommended approach. Same concept
(`@EnableWebSecurity`, URL authorization, stateless JWT), modern API.
