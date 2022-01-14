package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    public SchoolBook[] schoolBooks = {};

    public boolean save(SchoolBook book){
        boolean isSave = true;
        SchoolBook[] newSchoolBooks = new SchoolBook[schoolBooks.length + 1];
            for (int i = 0; i < schoolBooks.length; i++) {
                newSchoolBooks[i] = schoolBooks[i];
            }
        newSchoolBooks[schoolBooks.length ] = book;

        schoolBooks = new SchoolBook[newSchoolBooks.length];
            for (int i = 0; i < newSchoolBooks.length; i++) {
                schoolBooks[i] = newSchoolBooks[i];
            }
        return  isSave;
    }


    public SchoolBook[] findByName(String name){
        int booksWithSameName = 0;
        for (int i = 0; i < schoolBooks.length; i++){
            if(schoolBooks[i].getName().equals(name) ) {
                booksWithSameName++;
            }
        }
        SchoolBook[] findedBooks = new SchoolBook[booksWithSameName];
        for (int i = 0; i < schoolBooks.length; i++) {
            int j = 0;
            if (schoolBooks[i].getName().equals(name)) {
                findedBooks[j] = schoolBooks[i];
            }
        }
        return findedBooks;
    }

    public boolean removeByName(String name){
        boolean isRemove = false;
        SchoolBook[] booksForDeleting = findByName(name);
        if (booksForDeleting.length > 0) {
            SchoolBook[] newSchoolBooks = new SchoolBook[schoolBooks.length - booksForDeleting.length];
            int j = 0;
            for (int i = 0; i < schoolBooks.length; i++) {
                if(!schoolBooks[i].equals(booksForDeleting[j])) {
                    newSchoolBooks[i] = schoolBooks[j];
                    j++;
                }
            }
            schoolBooks = new SchoolBook[newSchoolBooks.length];
            for (int i = 0; i < schoolBooks.length; i++) {
                schoolBooks[i] = newSchoolBooks[i];
            }
            isRemove = true;
        }
        return  isRemove;
    }

    public int count(){
        return  schoolBooks.length;
    }

}
