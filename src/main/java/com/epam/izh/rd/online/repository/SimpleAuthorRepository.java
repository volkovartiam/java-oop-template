package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{

    Author[] authors = {};

    public boolean save(Author author){
        boolean isSave ;
        if( (findByFullName(author.getName(), author.getLastName() ) != null ) ) {
            isSave = false;
        } else {
            Author[] authorsTempArray = new Author[authors.length + 1];
            System.arraycopy(authors, 0, authorsTempArray, 0, authors.length);
            authorsTempArray[authorsTempArray.length - 1] = author;

            authors = new Author[authorsTempArray.length];
            System.arraycopy(authorsTempArray, 0, authors, 0, authorsTempArray.length);
            isSave = true;
        }
        return  isSave;
    }

    public Author findByFullName(String name, String lastname) {
        for ( Author author : authors){
            if(author.getLastName().equals(lastname) & author.getName().equals(name)){
                return author;
            }
        }
        return null;
    }

    public boolean remove(Author author){
        boolean isRemove ;

        if( (findByFullName(author.getName(), author.getLastName() ) != null ) ) {
            Author[] authorsTempArray = new Author[authors.length - 1 ];
            for (int i = 0; i < authors.length; i++) {
                if(!authors[i].equals(author))  {
                    authorsTempArray[i] = authors[i];
                }
            }
            authors = new Author[authorsTempArray.length];
            System.arraycopy(authorsTempArray, 0, authors, 0, authorsTempArray.length);
            isRemove = true;
        } else {
            isRemove = false;
        }
        return  isRemove;
    }

    public int count(){
        return authors.length;
    }

}
