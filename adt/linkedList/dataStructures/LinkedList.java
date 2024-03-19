package adt.linkedList.dataStructures;

/**
 * Represents a linked list data structure model.
 */
public interface LinkedList<E> {
  void insertFirst(E entity);
  void insertLast(E entity);
  void insertAfterIndex(int index, E entity);
  E getByIndex(int index);
  int getLength();
  boolean isEmpty();
  void removeFirst();
  void removeLast();
  void removeByIndex(int index);
  String printList();
  }
