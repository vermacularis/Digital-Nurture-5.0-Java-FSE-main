# Week 1 — TDD (JUnit 5 + Mockito) & SLF4J Logging (Mandatory)

A single Maven module covering all six mandatory testing/logging exercises.

## Run

```bash
mvn test                 # runs all JUnit + Mockito tests
mvn compile exec:java -Dexec.mainClass=com.cognizant.logging.LoggingExample   # SLF4J demo
```

## Mandatory exercises → where they live

| Skill | Exercise | File |
|-------|----------|------|
| JUnit | Ex1 Setting Up JUnit | `CalculatorTest#testSetup` |
| JUnit | Ex3 Assertions | `CalculatorTest#testAssertions` |
| JUnit | Ex4 AAA + Fixtures | `CalculatorTest` (`@BeforeEach`/`@AfterEach`, `testAddUsingAAA`) |
| Mockito | Ex1 Mocking & Stubbing | `UserServiceTest#testGetGreeting_stubbing` |
| Mockito | Ex2 Verifying Interactions | `UserServiceTest#testRegister_verifyInteraction` |
| SLF4J | Ex1 Error msgs & warning levels | `LoggingExample` + `logback.xml` |

## Notes
- **JUnit 5 (Jupiter)** — lifecycle (`@BeforeAll/@BeforeEach/@AfterEach/@AfterAll`),
  assertions (`assertEquals`, `assertTrue`, `assertThrows`, delta for doubles), and the
  Arrange-Act-Assert structure.
- **Mockito** — `@Mock`/`@InjectMocks` with `MockitoExtension`, stubbing via
  `when(...).thenReturn(...)`, and verification via `verify(...)`.
- **SLF4J + Logback** — `error`, `warn`, `info`, `debug` levels and parameterized
  logging (`{}` placeholders); an exception is logged at ERROR with its stack trace.
