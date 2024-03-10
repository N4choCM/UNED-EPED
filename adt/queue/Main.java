package adt.queue;

import adt.queue.dataStructures.Queue;
import adt.queue.dataStructures.QueueImpl;
import adt.queue.models.Photocopy;

public class Main {
  public static void main(String[] args) {
    Photocopy firstPhotocopy = new Photocopy(
      "The Catcher in the Rye", 
      "John Doe", 
      false
      );

    Photocopy secondPhotocopy = new Photocopy(
      "The Great Gatsby", 
      "F. Scott Fitzgerald", 
      true
      );

    Photocopy thirdPhotocopy = new Photocopy(
      "To Kill a Mockingbird", 
      "Harper Lee", 
      true
      );
    
    Photocopy current = new Photocopy();
    Queue<Photocopy> queue = new QueueImpl<Photocopy>();
    System.out.println("ENQUEUE OPERATIONS");
    System.out.println("-------------------------------------------------------------------");
    queue.enqueue(firstPhotocopy);
    current = queue.get();
    System.out.println("\n Head after enqueuing element:\n" + current.toString());
    queue.enqueue(secondPhotocopy);
    current = queue.get();
    System.out.println("\n Head after enqueuing element:\n" + current.toString());
    queue.enqueue(thirdPhotocopy);
    current = queue.get();
    System.out.println("\n Head after enqueuing element:\n" + current.toString() + "\n");
    System.out.println("DEQUEUE OPERATIONS");
    System.out.println("-------------------------------------------------------------------");
    System.out.println("\nPhotocopy to dequeue:\n" + current.toString());
    queue.dequeue();
    current = queue.get();
    System.out.println("\nPhotocopy to dequeue:\n" + current.toString());
    queue.dequeue();
    current = queue.get();
    System.out.println("\nPhotocopy to dequeue:\n" + current.toString());
    queue.dequeue();
    current = queue.get();
  }
}
