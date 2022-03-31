package com.beans;

import java.util.Set;

public class Library
{
    private int lib_id;
    private int no_of_books;
    private Set<Books> books;

    public Library(int lib_id, int no_of_books, Set<Books> books) {
        this.lib_id = lib_id;
        this.no_of_books = no_of_books;
        this.books = books;
    }

    public Library() {

    }

    public int getLib_id() {
        return lib_id;
    }

    public void setLib_id(int lib_id) {
        this.lib_id = lib_id;
    }

    public int getNo_of_books() {
        return no_of_books;
    }

    public void setNo_of_books(int no_of_books) {
        this.no_of_books = no_of_books;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" +
                "lib_id=" + lib_id +
                ", no_of_books='" + no_of_books + '\'' +
                ", books=" + books +
                '}';
    }
}
