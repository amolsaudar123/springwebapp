package com.springframework.springwebapp.bootstrap;

import com.springframework.springwebapp.model.Author;
import com.springframework.springwebapp.model.Book;
import com.springframework.springwebapp.model.Publisher;
import com.springframework.springwebapp.repositories.AuthorRepository;
import com.springframework.springwebapp.repositories.BookRepository;
import com.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        Author chetainB = new Author("Chetain", "Bhagat");
        Publisher publisher = new Publisher("McHills", "Pune");
        publisherRepository.save(publisher);
        Book book1=new Book("Five Point  Someone", "1234", publisher);
        chetainB.getBooks().add(book1);
        book1.getAuthors().add(chetainB);

        authorRepository.save(chetainB);
        bookRepository.save(book1);

        Author road = new Author("Road", "jonson");
        Publisher publisher2 = new Publisher("Java Wale", "Aurangabad");
        publisherRepository.save(publisher2);
        Book book2=new Book("Spring in action", "25489", publisher2);
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