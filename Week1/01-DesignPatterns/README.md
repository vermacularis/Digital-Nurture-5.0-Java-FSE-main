# Week 1 — Design Patterns & Principles (Mandatory)

| # | Exercise | Folder | Run |
|---|----------|--------|-----|
| 1 | Singleton Pattern | `SingletonPatternExample/` | `javac *.java && java SingletonTest` |
| 2 | Factory Method Pattern | `FactoryMethodPatternExample/` | `javac *.java && java FactoryMethodDemo` |

### Exercise 1 — Singleton
`Logger` guarantees a single shared instance via a private constructor + static
`getInstance()` (thread-safe double-checked locking). `SingletonTest` proves both
references are the same object (`logger1 == logger2`).

### Exercise 2 — Factory Method
A `DocumentFactory` declares the `createDocument()` factory method; concrete factories
(`Word`/`Pdf`/`Excel`) each produce their own `Document`. The client depends only on the
`Document` and `DocumentFactory` abstractions — new document types can be added without
changing client code (Open/Closed Principle).
