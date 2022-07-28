package com.example.demo12.service.impl;

import com.example.demo12.DAO.BookRepository;
import com.example.demo12.model.Book;
import com.example.demo12.service.ICRUDService;

import java.util.ArrayList;

public class BookService implements ICRUDService<Book> {
    BookRepository bookRepository = new BookRepository();
    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public ArrayList<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void create(Book book) {
        bookRepository.create(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.update(book);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
