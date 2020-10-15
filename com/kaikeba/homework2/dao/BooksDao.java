package com.kaikeba.homework2.dao;

import com.kaikeba.homework2.bean.Book;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class BooksDao {
    HashMap<String, Book> booksMap = new HashMap<>();

    public boolean add(Book book){
        if(booksMap.containsKey(book.getISBN())){
            return false;
        }
        booksMap.put(book.getISBN(), book);
        return true;
    }

    public boolean update(Book oldBook, Book newBook){
        if(booksMap.remove(oldBook.getISBN()) == null){
            return false;
        }
        if(booksMap.containsKey(newBook.getISBN())){
            return false;
        }
        booksMap.put(newBook.getISBN(), newBook);
        return true;
    }

    public boolean delete(Book book){
        if(booksMap.remove(book.getISBN()) == null){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Book> queryByPriceAscending(){
        Set<String> key = booksMap.keySet();
        ArrayList<Book> bookList = new ArrayList<>();
        for(String k : key){
            bookList.add(booksMap.get(k));
        }
        bookList.sort(new BookPriceAscendingComparator());
        return bookList;
    }

    public ArrayList<Book> queryByPriceDescending(){
        Set<String> key = booksMap.keySet();
        ArrayList<Book> bookList = new ArrayList<>();
        for(String k : key){
            bookList.add(booksMap.get(k));
        }
        bookList.sort(new BookPriceDescendingComparator());
        return bookList;
    }

    public ArrayList<Book> queryByDateDescending(){
        Set<String> key = booksMap.keySet();
        ArrayList<Book> bookList = new ArrayList<>();
        for(String k : key){
            bookList.add(booksMap.get(k));
        }
        bookList.sort(new BookDateDescendingComparator());
        return bookList;
    }

    public ArrayList<Book> queryByFuzzyName(String fuzzyName){
        Set<String> key = booksMap.keySet();
        ArrayList<Book> bookList = new ArrayList<>();
        for(String k : key){
            Book book = booksMap.get(k);
            if(book.getName().contains(fuzzyName)){
                bookList.add(book);
            }
        }
        return bookList;
    }
}
