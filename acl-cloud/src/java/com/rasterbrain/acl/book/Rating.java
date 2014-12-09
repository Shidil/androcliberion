/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rasterbrain.acl.book;

/**
 *
 * @author ezio
 */
public class Rating {
    int id;
    String isbn;
    String ratedBy;
    String rateText;
    int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(String ratedBy) {
        this.ratedBy = ratedBy;
    }

    public String getRateText() {
        return rateText;
    }

    public void setRateText(String rateText) {
        this.rateText = rateText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
}
