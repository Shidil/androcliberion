/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasterbrain.acl.book;

import com.rasterbrain.acl.Constants;
import com.rasterbrain.acl.DataBase;
import com.rasterbrain.acl.user.LoginData;
import com.rasterbrain.acl.user.UserManager;
import static com.rasterbrain.acl.user.UserManager.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ezio
 */
public class LibraryManager {

    public Book[] search(String key, String method) throws SQLException {

        switch (method) {
            case "name":
                return searchByName(key);
            case "author":
                return searchByAuthor(key);
            case "id":
                return searchByID(key);
            case "isbn":
                return searchByISBN(key);
            default:
                return null;
        }

    }

    private Book[] searchByName(String key) throws SQLException {
        Book[] books = null;
        int size = 0;
        DataBase db = new DataBase();
        db.createConnection();
        Connection con = db.getConnection();
        PreparedStatement ps1 = con.prepareStatement("SELECT COUNT(*) AS COUNT FROM book_isbn WHERE book_name LIKE ?");
        ps1.setString(1, "%" + key + "%");
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
            size = rs.getInt("COUNT");
        }
        PreparedStatement ps = con.prepareStatement("SELECT * FROM book_isbn WHERE book_name LIKE ?");
        ps.setString(1, "%" + key + "%");
        ResultSet res = ps.executeQuery();
        books = new Book[size];
        int i = 0;
        while (res.next()) {
            String bookname = res.getString("book_name");
            String author = res.getString("author");
            String categoryID = res.getString("category_id");
            String publisher = res.getString("publisher");
            String publishingDate = res.getString("publishing_date");
            String edition = res.getString("edition");
            int quantity = res.getInt("quantity");
            String isbn = res.getString("isbn");
            Book book = new Book(bookname, author, categoryID, publisher, publishingDate, edition, quantity, isbn);
            books[i] = book;
            i++;
        }

        return books;
    }

    private Book[] searchByAuthor(String key) throws SQLException {
        Book[] books = null;
        int size = 0;
        DataBase db = new DataBase();
        db.createConnection();
        Connection con = db.getConnection();
        PreparedStatement ps1 = con.prepareStatement("SELECT COUNT(*) AS COUNT FROM book_isbn WHERE author LIKE ?");
        ps1.setString(1, "%" + key + "%");
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
            size = rs.getInt("COUNT");
        }
        PreparedStatement ps = con.prepareStatement("SELECT * FROM book_isbn WHERE author LIKE ?");
        ps.setString(1, "%" + key + "%");
        ResultSet res = ps.executeQuery();
        books = new Book[size];
        int i = 0;
        while (res.next()) {
            String bookname = res.getString("book_name");
            String author = res.getString("author");
            String categoryID = res.getString("category_id");
            String publisher = res.getString("publisher");
            String publishingDate = res.getString("publishing_date");
            String edition = res.getString("edition");
            int quantity = res.getInt("quantity");
            String isbn = res.getString("isbn");
            Book book = new Book(bookname, author, categoryID, publisher, publishingDate, edition, quantity, isbn);
            books[i] = book;
            i++;
        }

        return books;
    }

    private Book[] searchByID(String key) throws SQLException {
        Book[] books = null;
        int size = 0;
        DataBase db = new DataBase();
        db.createConnection();
        Connection con = db.getConnection();
        PreparedStatement ps1 = con.prepareStatement("SELECT COUNT(*) AS COUNT FROM book_isbn WHERE category_id LIKE ?");
        ps1.setString(1, "%" + key + "%");
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
            size = rs.getInt("COUNT");
        }
        PreparedStatement ps = con.prepareStatement("SELECT * FROM book_isbn WHERE category_id LIKE ?");
        ps.setString(1, "%" + key + "%");
        ResultSet res = ps.executeQuery();
        books = new Book[size];
        int i = 0;
        while (res.next()) {
            String bookname = res.getString("book_name");
            String author = res.getString("author");
            String categoryID = res.getString("category_id");
            String publisher = res.getString("publisher");
            String publishingDate = res.getString("publishing_date");
            String edition = res.getString("edition");
            int quantity = res.getInt("quantity");
            String isbn = res.getString("isbn");
            Book book = new Book(bookname, author, categoryID, publisher, publishingDate, edition, quantity, isbn);
            books[i] = book;
            i++;
        }

        return books;
    }

    private Book[] searchByISBN(String key) throws SQLException {
        Book[] books = null;
        int size = 0;
        DataBase db = new DataBase();
        db.createConnection();
        Connection con = db.getConnection();
        PreparedStatement ps1 = con.prepareStatement("SELECT COUNT(*) AS COUNT FROM book_isbn WHERE isbn LIKE ?");
        ps1.setString(1, "%" + key + "%");
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
            size = rs.getInt("COUNT");
        }
        PreparedStatement ps = con.prepareStatement("SELECT * FROM book_isbn WHERE isbn LIKE ?");
        ps.setString(1, "%" + key + "%");
        ResultSet res = ps.executeQuery();
        books = new Book[size];
        int i = 0;
        while (res.next()) {
            String bookname = res.getString("book_name");
            String author = res.getString("author");
            String categoryID = res.getString("category_id");
            String publisher = res.getString("publisher");
            String publishingDate = res.getString("publishing_date");
            String edition = res.getString("edition");
            int quantity = res.getInt("quantity");
            String isbn = res.getString("isbn");
            Book book = new Book(bookname, author, categoryID, publisher, publishingDate, edition, quantity, isbn);
            books[i] = book;
            i++;
        }

        return books;
    }

    public boolean addBook(LoginData login,String isbn, String categoryID, String bookName, String author, String publisher, String publishingDate, String edition, String quantity) {
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT into book_isbn (isbn,category_id,book_name,author,publisher,publishing_date,edition,quantity) VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, isbn);
            ps.setString(2, categoryID);
            ps.setString(3, bookName);
            ps.setString(4, author);
            ps.setString(5, publisher);
            ps.setString(6, publishingDate);
            ps.setString(7, edition);
            ps.setString(8, quantity);
            ps.executeUpdate();         
            UserManager man = new UserManager();
            int libID = man.getUser(login.getUsername()).reg_lib;
            ps = con.prepareStatement("INSERT into book_serial_ids (isbn,lib_id,book_status) VALUES(?,?,?)");
            ps.setString(1, isbn);
            ps.setInt(2, libID);
            ps.setString(3, "ok");
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

}
