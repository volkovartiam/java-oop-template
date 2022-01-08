package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{

    Author[] authors = {};

    public boolean save(Author author){

        return false;
    }

    public Author findByFullName(String name, String lastname) {

        return null;
    }

    public boolean remove(Author author){

        return false;
    }

    public int count(){

        return -1;
    }

}
