package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

public class SimpleSchoolBookService implements BookService{

    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    public boolean save(Book book){

        return false;
    }

    public Book[] findByName(String name){

        return null;
    }

    public int getNumberOfBooksByName(String name){

        return -1;
    }

    public boolean removeByName(String name){

        return false;
    }

    public int count(){

        return -1;
    }

    public Author findAuthorByBookName(String name){

        return null;
    }
}
