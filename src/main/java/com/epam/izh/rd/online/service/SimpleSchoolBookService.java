package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

import java.util.Objects;

public class SimpleSchoolBookService implements BookService<SchoolBook>{

    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    public boolean save(SchoolBook book){
        Objects.requireNonNull(book, "Book must not be null");

        String authorName = book.getAuthorName();
        String authorLastName = book.getAuthorLastName();

        Objects.requireNonNull(authorName, "Author's name must not be null");
        Objects.requireNonNull(authorLastName, "Author's last name must not be null");

        if (authorService.findByFullName(authorName,authorLastName) != null) {
            return schoolBookBookRepository.save(book);
        } else {
            return false;
        }
    }

    public SchoolBook[] findByName(String name){

        return null;
    }

    public int getNumberOfBooksByName(String name){
        return schoolBookBookRepository.findByName(name).length;
    }

    public boolean removeByName(String name){
        return schoolBookBookRepository.removeByName(name);
    }

    public int count(){
        return schoolBookBookRepository.count();
    }


    public Author findAuthorByBookName(String name){
        if(schoolBookBookRepository.count() > 0 & authorService.count() > 0 ) {
            SchoolBook[] foundBooks = schoolBookBookRepository.findByName(name);
            String authorLastName;
            String authorName;
            for(SchoolBook book : foundBooks) {
                authorLastName = book.getAuthorLastName();
                authorName = book.getAuthorName();
                return authorService.findByFullName(authorName, authorLastName);
            }
        }
        return null;
    }
}
