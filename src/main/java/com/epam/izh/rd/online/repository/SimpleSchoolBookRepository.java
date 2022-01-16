package com.epam.izh.rd.online.repository;
import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    public SchoolBook[] schoolBooks = {};

    public boolean save(SchoolBook book){
        boolean isSave = true;
        SchoolBook[] newSchoolBooks = new SchoolBook[schoolBooks.length + 1];
        System.arraycopy(schoolBooks, 0, newSchoolBooks, 0, schoolBooks.length);
        newSchoolBooks[schoolBooks.length ] = book;

        schoolBooks = new SchoolBook[newSchoolBooks.length];
        System.arraycopy(newSchoolBooks, 0, schoolBooks, 0, newSchoolBooks.length);

        return  isSave;
    }


    public SchoolBook[] findByName(String name){
        int booksWithSameName = 0;
        for (SchoolBook book : schoolBooks){
            if(book.getName().equals(name) ) {
                booksWithSameName++;
            }
        }
        SchoolBook[] foundBooks = new SchoolBook[booksWithSameName];
        for (int i = 0; i < schoolBooks.length; i++) {
            int j = 0;
            if (schoolBooks[i].getName().equals(name)) {
                foundBooks[j] = schoolBooks[i];
                j++;
            }
        }
        return foundBooks;
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
            isRemove = true;
        }
        return  isRemove;
    }

    public int count(){
        return  schoolBooks.length;
    }

}
