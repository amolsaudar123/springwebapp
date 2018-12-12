package com.springframework.springwebapp.bootstrap;

import com.springframework.springwebapp.model.Author;
import com.springframework.springwebapp.model.Book;
import com.springframework.springwebapp.repositories.AuthorRepository;
import com.springframework.springwebapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){
        Author chetainB = new Author("Chetain", "Bhagat");
        Book book1=new Book("Five Point  Someone", "1234", "McHills");
        chetainB.getBooks().add(book1);
        book1.getAuthors().add(chetainB);

        authorRepository.save(chetainB);
        bookRepository.save(book1);

        Author road = new Author("Road", "jonson");
        Book book2=new Book("Spring in action", "25489", "Java Wale");
        chetainB.getBooks().add(book2);
        book1.getAuthors().add(road);

        authorRepository.save(road);
        bookRepository.save(book2);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}