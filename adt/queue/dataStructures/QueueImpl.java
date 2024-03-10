package adt.queue.dataStructures;

public class QueueImpl<E> implements Queue<E>{

  private class Node {
    public E entity;
    public Node next;

    public Node(E entity) {
      this.entity = entity;
      this.next = null;
    }
  }

  private Node head, tail;

  @Override
  public void enqueue(E entity) {
    Node node = new Node(entity);
    if (head == null) {
      head = node;
    } else {
      tail.next = node;
    }
    tail = node;
  }

  @Override
  public void dequeue() {
    if(head != null) {
      Node toDequeue = head;
      head = head.next;
      toDequeue.next = null;
      if(head == null) {
        tail = null;
      }
    }
  }

  @Override
  public E get() {
    if(head == null) {
      return null;
    } else {
      return head.entity;
    }
  }
  
}
