package adt.linkedList.models;

public class Book {
  // MARK I - Properties
  private String title;
  private String author;
  private String isbn;

  // MARK II - Constructors
  public Book() {
    this.title = "";
    this.author = "";
    this.isbn = "";
  }

  public Book(String title, String author, String isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
  }

  // MARK III - Getters
  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getIsbn() {
    return isbn;
  }

  // MARK IV - Setters
  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}