# Kursinių Sekimo API

Spring Boot pagrindu sukurta REST API sistema studentų kursinių darbų sekimui.

## Funkcionalumas

- **Studentų valdymas**
  - Sukurti, gauti, atnaujinti, ištrinti studentus
- **Modulių valdymas**
  - Priskirti modulius studentams
  - Sukurti, gauti, atnaujinti, ištrinti modulius
- **Užduočių valdymas**
  - Priskirti užduotis moduliams
  - Sukurti, gauti, atnaujinti, ištrinti užduotis

## Naudojamos technologijos

- Java 17+
- Spring Boot 3
- Spring Data JPA
- H2 duomenų bazė (testavimui)
- Postman (testavimui)
- Swagger (API dokumentacija)

## Paleidimas lokaliai

1. Įsitikink, kad turi JDK ir Maven.
2. Paleisk komandą:./mvnw spring-boot:run

3. API bus pasiekiama per: `http://localhost:8080`

## Duomenų bazės testavimui

Automatiškai užkraunama `data.sql` failo pagalba:
- Sukuriami studentai, moduliai ir užduotys

## API testavimas su Postman

Sukurtas Postman kolekcijos failas:
- Testuoti `GET`, `POST`, `PUT`, `DELETE` užklausas studentams, moduliams ir užduotims

## Swagger UI

Dokumentacija automatiškai pasiekiama adresu:http://localhost:8080/swagger-ui/index.html


