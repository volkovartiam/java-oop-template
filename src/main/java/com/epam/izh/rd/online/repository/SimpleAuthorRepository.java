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
            for (int i = 0; i < authors.length; i++) {
                authorsTempArray[i] = authors[i];
            }
            authorsTempArray[authorsTempArray.length - 1] = author;

            authors = new Author[authorsTempArray.length];
            for (int i = 0; i < authors.length; i++) {
                authors[i] = authorsTempArray[i];
            }
            isSave = true;
        }
        return  isSave;
    }

    public Author findByFullName(String name, String lastname) {

        for (int i = 0; i < authors.length; i++){
            if(authors[i].getLastName().equals(lastname) & authors[i].getName().equals(name)){
                return authors[i];
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
            for (int i = 0; i < authors.length; i++) {
                authors[i] = authorsTempArray[i];
            }
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
