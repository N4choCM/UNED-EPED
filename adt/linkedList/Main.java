package adt.linkedList;

import adt.linkedList.dataStructures.LinkedList;
import adt.linkedList.dataStructures.LinkedListImpl;
import adt.linkedList.models.Book;

public class Main {
  public static void main(String[] args) {
    // MARK I - Linked List Creation
    LinkedList<Book> list = new LinkedListImpl<Book>();

    // MARK II - Books Creation
    Book book1 = new Book(
      "The Great Gatsby",
      "F. Scott Fitzgerald",
      "9780743273565"
      );
    Book book2 = new Book(
      "To Kill a Mockingbird", 
      "Harper Lee", 
      "9780061120084"
      );
    Book book3 = new Book(
      "1984", 
      "George Orwell", 
      "9780451524935"
      );
    Book book4 = new Book(
      "The Catcher in the Rye", 
      "J.D. Salinger", 
      "9780316769488"
      );
    Book book5 = new Book(
      "The Grapes of Wrath", 
      "John Steinbeck", 
      "9780143039433"
      );
    Book book6 = new Book(
      "Brave New World", 
      "Aldous Huxley", 
      "9780060850524"
      );

    // MARK III - Linked List Insert Operations
    System.out.println("LINKED LIST OPERATIONS");
    System.out.println("INSERT OPERATIONS");
    System.out.println("-------------------------------------------------------------------");
    list.insertFirst(book1);
    System.out.println("Inserting book1 at the beginning of the list: \n" + list.printList());
    System.out.println("Number of books in the list:" + list.getLength());
    list.insertFirst(book2);
    System.out.println("Inserting book2 at the beginning of the list: \n" + list.printList());
    System.out.println("Number of books in the list:" + list.getLength());
    list.insertLast(book3);
    System.out.println("Inserting book3 at the end of the list: \n" + list.printList());
    System.out.println("Number of books in the list:" + list.getLength());
    list.insertLast(book4);
    System.out.println("Inserting book4 at the end of the list: \n" + list.printList());
    System.out.println("Number of books in the list:" + list.getLength());
    list.insertAfterIndex(1, book5);
    System.out.println("Inserting book5 after index 1:\n" + list.printList());
    System.out.println("Number of books in the list:" + list.getLength());
    list.insertAfterIndex(3, book6);
    System.out.println("Inserting book6 after index 3:\n" + list.printList());
    System.out.println("Number of books in the list:" + list.getLength() + "\n");

    // MARK IV - Linked List Retrieve Operations
    System.out.println("RETRIEVE OPERATIONS");
    System.out.println("-------------------------------------------------------------------");
    System.out.println("Retrieving book at index 2: \n" + list.getByIndex(2).getTitle());
    System.out.println("Retrieving book at index 5: \n" + list.getByIndex(5).getTitle() + "\n");

    // MARK V - Linked List Remove Operations
    System.out.println("REMOVE OPERATIONS");
    System.out.println("-------------------------------------------------------------------");
    list.removeFirst();
    System.out.println("Removing the first book: \n" + list.printList());
    System.out.println("Number of books in the list:" + list.getLength());
    list.removeLast();
    System.out.println("Removing the last book: \n" + list.printList());
    System.out.println("Number of books in the list:" + list.getLength());
    list.removeByIndex(1);
    System.out.println("Removing the book in index 1: \n" + list.printList());
    System.out.println("Number of books in the list:" + list.getLength());
  }
}
