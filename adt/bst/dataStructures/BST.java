package adt.bst.dataStructures;

/**
 * Binary Search Tree Interface
 * Extends Comparable to determine which side of the BST to work on.
 */
public interface BST<E extends Comparable<E>> {
  void insert(E entity);
  boolean isIdUnique(Long id);
  E getById(Long id);
  boolean isLeaf();
  boolean isEmpty();
  void printInPreorder();
  void printInInorder();
  void printInPostorder();
  void deleteById(Long id);
}
