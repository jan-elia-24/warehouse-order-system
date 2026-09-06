# Warehouse Order System

Ett lager- och ordersystem byggt med Spring Boot, JPA och PostgreSQL.

## Om projektet

Systemet hanterar artiklar, lagersaldo och kundordrar. Byggt som ett portfolio-
projekt för att visa backendutveckling i Java med fokus på REST-API,
datamodellering och testautomatisering.

## Teknikstack

- Java 21
- Spring Boot 4.1
- Spring Data JPA / Hibernate
- PostgreSQL
- Docker Compose
- JUnit 5 och MockMvc
- Maven

## Funktionalitet

- REST-API för artiklar, lager, ordrar och orderrader (CRUD)
- Datamodell med relationer: Artikel, Lager, Order, OrderRad
- Schemalagt batch-jobb som rapporterar lagerstatus och varnar vid lågt saldo
- Enhetstester för REST-endpoints

## Kom igång

1. Klona repot
2. Starta databasen: `docker compose up -d`
3. Starta applikationen: `./mvnw spring-boot:run`
4. API:et är tillgängligt på `http://localhost:8080`

## Endpoints

- `GET/POST/PUT/DELETE /artiklar`
- `GET/POST/PUT/DELETE /lager`
- `GET/POST/PUT/DELETE /orders`
- `GET/POST/DELETE /orderrader`

## Tester

Kör testerna med:

```
./mvnw test
```