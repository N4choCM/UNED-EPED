package adt.queue.models;

public class Photocopy {
  // MARK I - Properties
  private String title;
  private String author;
  private boolean impressed;

  // MARK II - Constructors
  public Photocopy() {
    this.title = "";
    this.author = "";
    this.impressed = false;
  }

  public Photocopy(String title, String author, boolean impressed) {
    this.title = title;
    this.author = author;
    this.impressed = impressed;
  }

  // MARK III - Getters
  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public boolean getImpressed() {
    return impressed;
  }

  // MARK IV - Setters
  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setImpressed(boolean impressed) {
    this.impressed = impressed;
  }

  public String toString() {
    return "- Title: " + title + 
    "\n- Author: " + author + 
    "\n- Impressed: " + impressed;
  }
}