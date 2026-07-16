# Week 2 — Spring Core & Maven (Mandatory)

Maven project **LibraryManagement** using the Spring IoC container with XML configuration.

## Run

```bash
mvn compile exec:java -Dexec.mainClass=com.library.LibraryManagementApplication
```

Expected output:
```
=== Library Catalog ===
 - Clean Code - Robert C. Martin
 - Effective Java - Joshua Bloch
 - Spring in Action - Craig Walls
Total books: 3
```

## Mandatory exercises covered

| Exercise | What it shows | Where |
|----------|---------------|-------|
| Ex1 Configuring a Basic Spring Application | Maven + Spring Core deps, `applicationContext.xml`, `BookService`/`BookRepository` beans, main class loading the context | `pom.xml`, `applicationContext.xml`, `LibraryManagementApplication` |
| Ex2 Implementing Dependency Injection | `BookRepository` wired into `BookService` via the container | `applicationContext.xml` `<property>` + `BookService.setBookRepository` |
| Ex4 Creating and Configuring a Maven Project | Standard Maven layout, `pom.xml` with Spring Context dependency and compiler config | `pom.xml` |

The `applicationContext.xml` also shows the **constructor-injection** alternative (commented),
matching the "additional" exercises Ex5 (IoC container) and Ex7 (constructor + setter injection).
