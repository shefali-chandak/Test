package com.beans;

public class Books
{
    private int book_id;
    private String book_name;
    private int salary;
    private String publisher;

    public Books(int book_id, String book_name, int salary, String publisher) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.salary = salary;
        this.publisher = publisher;
    }

    public Books() {

    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", salary=" + salary +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
