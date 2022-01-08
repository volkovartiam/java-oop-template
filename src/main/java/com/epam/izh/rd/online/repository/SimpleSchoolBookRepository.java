package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<Book> {

    public SchoolBook[] schoolBooks = {};

    public boolean save(Book book){

        return  false;
    }


    public Book[] findByName(String name){

        return null;
    }

    public boolean removeByName(String name){

        return false;
    }

    public int count(){
        return  -1;
    }

}
