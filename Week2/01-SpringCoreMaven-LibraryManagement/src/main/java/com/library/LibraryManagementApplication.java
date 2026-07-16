package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class that bootstraps the Spring IoC container from applicationContext.xml,
 * retrieves the BookService bean, and uses it — proving the beans were configured
 * and the dependency was injected.
 *
 * Run:  mvn compile exec:java -Dexec.mainClass=com.library.LibraryManagementApplication
 */
public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Exercise 1 & 5: load the Spring context (IoC container) from XML.
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Exercise 2 & 7: get the fully-wired bean (repository already injected).
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.listBooks();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
