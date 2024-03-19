package adt.stack.dataStructures;

public class StackImpl<E> implements Stack<E>{

  private class Node {
    public E entity;
    public Node next = null;

    public Node(E entity) {
      this.entity = entity;
    }
  }

  private Node peak = null;
  private int size = 0;

  @Override
  public void push(E entity) {
    Node node = new Node(entity);
    node.next = peak;
    peak = node;
    size++;
  }

  @Override
  public void pop() {
    if (peak != null) {
      Node toPop = peak;
      peak = peak.next;
      toPop.next = null;
      size--;
    }
  }

  @Override
  public E get() {
    if (peak == null) {
      return null;
    } else {
      return peak.entity;
    }
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }
  
}
