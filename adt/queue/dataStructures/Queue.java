package adt.queue.dataStructures;

public interface Queue<E> {
  void enqueue(E entity);
  void dequeue();
  E get();
}
