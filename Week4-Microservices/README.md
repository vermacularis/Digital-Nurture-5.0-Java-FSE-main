# Week 4 — Microservices with Spring Boot 3 & Spring Cloud

Four independent Spring Boot projects that together demonstrate the mandatory and additional
microservices hands-on.

| Project | Port | Role |
|---------|------|------|
| `eureka-discovery-server` | 8761 | Service registry (Eureka) |
| `account` | 8080 | `GET /accounts/{number}` — dummy account (mandatory) |
| `loan` | 8081 | `GET /loans/{number}` — dummy loan (mandatory) |
| `api-gateway` | 9090 | Spring Cloud Gateway + global log filter (additional) |

## Mandatory vs additional
- **Mandatory:** Creating microservices for account and loan → `account/` + `loan/`.
- **Additional:** Eureka discovery server + register services + API gateway → `eureka-discovery-server/` + `api-gateway/`.

## Run order

```bash
# 1. Registry first
cd eureka-discovery-server && mvn spring-boot:run      # http://localhost:8761

# 2. The two services (separate terminals)
cd account && mvn spring-boot:run
cd loan    && mvn spring-boot:run

# 3. The gateway
cd api-gateway && mvn spring-boot:run
```

## Try it

```bash
# Direct calls
curl http://localhost:8080/accounts/00987987973432
curl http://localhost:8081/loans/H00987987972342

# Through the gateway (routes by service id registered in Eureka)
curl http://localhost:9090/account-service/accounts/00987987973432
curl http://localhost:9090/loan-service/loans/H00987987972342
```

Open **http://localhost:8761** to see `ACCOUNT-SERVICE`, `LOAN-SERVICE`, and `API-GATEWAY`
listed under *Instances currently registered with Eureka*. Each gateway request is logged by
`LogFilter` (`====> Request URL: ...`) in the api-gateway console.

## Version note
The handbook uses Spring Boot 2.5 + `WebSecurityConfigurerAdapter`-era Spring Cloud. This
build uses **Spring Boot 3.2.5 + Spring Cloud 2023.0.1** (current, Jakarta-based). Concepts are
identical: `@EnableEurekaServer`, `@EnableDiscoveryClient`, discovery-locator routing, and a
`GlobalFilter`.
