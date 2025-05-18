 Lab3 – JPQL i testowanie (JPA + Spring Boot)

Projekt realizowany w ramach przedmiotu **"Wprowadzenie do technologii backendowych – JPA"**.

 Zawartość

Lab3 to kontynuacja Lab1 i Lab2. Projekt zawiera:

- Konfigurację Spring Boot + JPA
- Struktura trójwarstwowa (DAO, Service, Mapper, TO)
- Testy jednostkowe DAO i Service
- Zapytania JPQL:
  1. Wyszukiwanie pacjentów po nazwisku
  2. Pobranie wizyt pacjenta po ID
  3. Wyszukiwanie pacjentów z liczbą wizyt > X
  4. Filtrowanie pacjentów po polu `isInsured`
- Porównanie FetchMode.SELECT vs JOIN FETCH
- Test wersjonowania (Optimistic Lock)

 Uruchomienie

1. Otwórz projekt w IntelliJ IDEA
2. Upewnij się, że wybrana jest Java 17+
3. Uruchom projekt jako aplikację Spring Boot
4. Testy uruchom z katalogu `src/test/java`

 Autor

**Kamil Kusiak i Bartek Miniach 
GitHub: [kamkus29](https://github.com/kamkus29)

pierwsze repo na git lab1 i lab2
https://github.com/Miniach/wsb_jpa
