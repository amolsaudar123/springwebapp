package com.springframework.springwebapp.controllers;

import com.springframework.springwebapp.repositories.AuthorRepository;
import com.springframework.springwebapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    public BookController(){}
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        authorRepository.findAll();
        model.addAttribute("book", bookRepository.findAll());
        return "books";
    }
}
