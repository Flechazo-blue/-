package com.kaikeba.homework2.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Book {
    private String name;
    private String ISBN;
    private Date publishDate;
    private double price;

    public Book() {}

    public Book(String name, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ISBN.equals(book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "书名='" + name + '\'' +
                ", ISBN码='" + ISBN + '\'' +
                ", 出版日期=" + new SimpleDateFormat("yyyy-MM-dd").format(publishDate) +
                ", 价格=" + price +
                '}';
    }
}
