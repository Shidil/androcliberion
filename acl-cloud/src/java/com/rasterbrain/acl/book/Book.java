/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasterbrain.acl.book;

import org.json.simple.JSONObject;

/**
 *
 * @author ezio
 */
public class Book {

    String bookName;
    String isbn;
    String categoryID;
    String author;
    String publisher;
    String publishingDate;
    String edition;
    int quantity;

    Book(String bookname, String author, String categoryID, String publisher, String publishingDate, String edition, int quantity, String isbn) {
        this.bookName = bookname;
        this.author = author;
        this.categoryID = categoryID;
        this.publisher = publisher;
        this.publishingDate = publishingDate;
        this.edition = edition;
        this.quantity = quantity;
        this.isbn = isbn;
    }

    public JSONObject toJSON() {

        JSONObject obj = new JSONObject();

        obj.put("bookname", bookName);
        obj.put("author", author);
        obj.put("isbn", isbn);
        obj.put("publisher", publisher);

        return obj;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
    Rating rating;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
