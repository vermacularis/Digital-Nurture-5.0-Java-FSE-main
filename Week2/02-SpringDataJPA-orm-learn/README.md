# Week 2 — Spring Data JPA with Hibernate (Mandatory)

**orm-learn** — a Spring Boot app demonstrating Spring Data JPA + Hibernate against an
**H2 in-memory database** (zero install; the handbook's MySQL steps are noted below).

## Run

```bash
mvn spring-boot:run
```

On startup a `CommandLineRunner` prints each mandatory operation. You can also browse the
data at `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:ormlearn`, user `sa`).

## Mandatory hands-on covered

| Item | Where |
|------|-------|
| Spring Data JPA – Quick Example (list countries) | `OrmLearnApplication.run` + `CountryService.getAllCountries` |
| Find a country based on country code | `CountryService.findCountryByCode` (`findById`) |
| Add a new country | `CountryService.addCountry` (`save`) |
| Query Methods | `CountryRepository.findByNameContainingIgnoreCase` |
| O/R Mapping | `model/Country.java` (`@Entity/@Table/@Id/@Column`) |
| HQL & Native Query | `CountryRepository.findByNameHql` (JPQL) + `findByCodeNative` (SQL) |

## JPA vs Hibernate vs Spring Data JPA (the "difference" mandatory item)

- **JPA** — a *specification* (JSR 338). It defines annotations/APIs but has no implementation.
- **Hibernate** — the most common *implementation* of JPA; an ORM tool that maps objects to
  tables and generates SQL. (It's the provider auto-configured here.)
- **Spring Data JPA** — an *abstraction on top of* a JPA provider (Hibernate). By extending
  `JpaRepository` you get CRUD + query-method generation, removing boilerplate DAO code.

So: **Spring Data JPA → uses → Hibernate → implements → JPA.**

## Switching to MySQL (to match the handbook exactly)

1. Replace the `h2` dependency with `mysql-connector-j`.
2. Create the schema: `CREATE SCHEMA ormlearn;`
3. Update `application.properties`:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
   spring.datasource.username=root
   spring.datasource.password=<your-password>
   spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
   ```
