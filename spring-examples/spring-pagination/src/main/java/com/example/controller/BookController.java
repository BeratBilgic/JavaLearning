package com.example.controller;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public Page<Book> pagination(@RequestParam Integer page,
                                 @RequestParam Integer pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/page")
    public Page<Book> pagination(Pageable pageable){
        //Page extends Slice and knows the total number of elements and pages available by triggering a count query.
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/slice")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/sortByTitle")
    public Page<Book> sortByTitle(){
        return bookRepository.findAll(PageRequest.of(0, 4, Sort.by("title")));
    }

    @GetMapping("/sortByPrice")
    public Page<Book> sortByPrice(){
        return bookRepository.findAll(PageRequest.of(0, 5, Sort.by("price").descending()));
    }

    @GetMapping("/sortByTitleAndPrice")
    public Page<Book> sortByTitleAndPrice(){
        return bookRepository.findAll(PageRequest.of(0, 5, Sort.by("price").descending().and(Sort.by("title"))));
    }
}
