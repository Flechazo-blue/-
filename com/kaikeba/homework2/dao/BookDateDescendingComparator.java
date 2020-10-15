package com.kaikeba.homework2.dao;

import com.kaikeba.homework2.bean.Book;

import java.util.Comparator;

public class BookDateDescendingComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getPublishDate().getTime() > o2.getPublishDate().getTime()){
            return 1;
        }else if(o1.getPublishDate().getTime() < o2.getPublishDate().getTime()){
            return -1;
        }else {
            return 0;
        }
    }
}
