package com.example.laboratorsp;

import com.example.laboratorsp.laborator3.ClientComponent;
import com.example.laboratorsp.laborator3.SingletonComponent;
import com.example.laboratorsp.laborator3.TransientComponent;
import com.example.laboratorsp.laborator4.model.Book;
import com.example.laboratorsp.laborator4.repository.BooksRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.example.laboratorsp.laborator4.repository.BooksRepository;

@SpringBootApplication
public class LaboratorSpApplication {

    public static void main(String[] args) {

        SpringApplication.run(LaboratorSpApplication.class, args);
        //http://localhost:8080/books pentru a vedea datele transmise






        // laborator 3
        //
        // Run the main function and inspect the output in console
        // to learn about the lifecycle of objects within the
        // Spring Dependency Injection Context
        //
        // Gets a handle of dependency injection context
        //              ApplicationContext context = SpringApplication.run(LaboratorSpApplication.class, args);
        // Gets an instance of TransientComponent from the DI context
        //              TransientComponent transientBean =
        //                      context.getBean(TransientComponent.class);
        //              transientBean.operation();
        // Note that every time an instance is required,
        // the DI context creates a new one
        //              transientBean = context.getBean(TransientComponent.class);
        //              transientBean.operation();
        // Gets an instance of SingletonComponent from the DI context
        // Note that the unique instance was created while
        // application was loaded, before creating
        // the transient instances
        //              SingletonComponent singletonBean =
        //                      context.getBean(SingletonComponent.class);
        //              singletonBean.operation();
        // Note that every time an instance is required,
        // the DI returns the same unique one
        //              singletonBean = context.getBean(SingletonComponent.class);
        //              singletonBean.operation();
        // Gets an instance of another class that
        // requires singleton/transient components
        // Note where this instance was created and what beans
        // were used to initialize it
        //              ClientComponent c = context.getBean(ClientComponent.class);
        //              c.operation();

        // One can also request an instance from DI context by name
        //              c = (ClientComponent)context.getBean("clientComponent");
        //              c.operation();

        // laborator 3 end

    }

    @Bean
    CommandLineRunner initDatabase(BooksRepository booksRepository) {
        return args -> {
            if (booksRepository.count() == 0) {
                booksRepository.save(new Book(null, "Ion", "Liviu Rebreanu"));
                booksRepository.save(new Book(null, "Moromeții", "Marin Preda"));
                booksRepository.save(new Book(null, "Baltagul", "Mihail Sadoveanu"));
                booksRepository.save(new Book(null, "Amintiri din copilărie", "Ion Creangă"));
            }

            booksRepository.findAll().forEach(System.out::println);
        };
    }



}
