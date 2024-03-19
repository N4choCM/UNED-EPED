package adt.stack.dataStructures;

public interface Stack<E> {
  void push(E entity);
  void pop();
  E get();
  boolean isEmpty();
  int size();
}
