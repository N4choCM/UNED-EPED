package adt.bst.dataStructures;

import adt.bst.models.Employee;

public class BSTImpl<E extends Comparable<E>> implements BST<Employee> {
  // MARK I - Attributes
  private Employee entity;
  private BSTImpl<Employee> left, right, parent;

  // MARK II - Methods
  /**
   * Insert an entity into the BST.
   * @param entity
   * @param parent
   */
  @SuppressWarnings("unchecked")
  private void insertImpl(Employee entity, BSTImpl<Employee> parent) {
    if(isEmpty()) {
      // If the BST is empty, the parameters info is taking into account.
      this.entity = entity;
      this.parent = parent;
    } else {
      // Otherwise, the given entity is compared with the current entity to determine the side to insert.
      if (entity.compareTo(this.entity) < 0){
        if (left == null) left = new BSTImpl<>();
        left.insertImpl(entity, (BSTImpl<Employee>) this);
      } else if (entity.compareTo(this.entity) > 0){
        if (right == null) right = new BSTImpl<>();
        right.insertImpl(entity, (BSTImpl<Employee>) this);
      } else {
        throw new IllegalArgumentException("Requested id is not unique.");
      }
    }
  }

  /**
   * Inserts the specified employee into the binary search tree.
   * @param entity the employee to be inserted
   */
  @Override
  public void insert(Employee entity) {
    insertImpl(entity, null);
  }

  /**
   * Checks if the given ID is unique within the binary search tree.
   * @param id the ID to check for uniqueness
   * @return true if the ID is unique, false otherwise
   */
  @Override
  public boolean isIdUnique(Long id) {
    if(entity != null) {
      if(id == entity.getId()){
        return true;
      } else if (id < entity.getId() && left != null){
        return left.isIdUnique(id);
      } else if(id > entity.getId() && right != null){
        return right.isIdUnique(id);
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * Retrieves the employee with the specified ID.
   * @param id the ID of the employee to retrieve
   * @return the employee with the specified ID
   */
  @Override
  public Employee getById(Long id) {
    if(entity != null) {
      if(id == entity.getId()){
        return entity;
      } else if (id < entity.getId() && left != null){
        return left.getById(id);
      } else if (id > entity.getId() && right != null){
        return right.getById(id);
      } else {
        throw new IllegalArgumentException("Given ID is not valid.");
      }
    } else {
      throw new IllegalArgumentException("BST is empty.");
    }
  }

  /**
   * Checks if the current node is a leaf node.
   * A leaf node is a node that has no children.
   * @return true if the current node is a leaf, false otherwise.
   */
  @Override
  public boolean isLeaf() {
    return entity != null && left == null && right == null;
  }

  /**
   * Checks if the binary search tree is empty.
   * @return true if the binary search tree is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return entity == null;
  }

  /**
   * Prints the elements of the binary search tree in preorder traversal.
   * The preorder traversal visits the root node first, then the left subtree,
   * and finally the right subtree.
   */
  @Override
  public void printInPreorder() {
    if(entity != null) {
      // root
      System.out.println(entity.toString());
      // left
      if(left != null) left.printInPreorder();
      // right
      if(right != null) right.printInPreorder();
    }
  }

  /**
   * Prints the elements of the binary search tree in inorder traversal.
   * In inorder traversal, the left subtree is visited first, then the root,
   * and finally the right subtree.
   */
  @Override
  public void printInInorder() {
    if(entity != null) {
      // left
      if(left != null) left.printInInorder();
      // root
      System.out.println(entity.toString());
      // right
      if(right != null) right.printInInorder();
    }
  }

  /**
   * Prints the elements of the binary search tree in postorder traversal.
   * Postorder traversal visits the left subtree, then the right subtree, and finally the root.
   */
  @Override
  public void printInPostorder() {
    if(entity != null) {
      // left
      if(left != null) left.printInPostorder();
      // right
      if(right != null) right.printInPostorder();
      // root
      System.out.println(entity.toString());
    }
  }

  /**
   * Deletes a node with the specified ID from the binary search tree.
   * If the ID is found, the node is removed from the tree.
   * If the ID is not found, an IllegalArgumentException is thrown.
   * @param id the ID of the node to be deleted
   * @throws IllegalArgumentException if the requested ID does not exist or is invalid
   */
  @Override
  public void deleteById(Long id) {
    if(entity != null){
      if(id == entity.getId()){
        deleteByIdImpl(id);
      } else if (id < entity.getId() && left != null){
        left.deleteById(id);
      } else if (id > entity.getId() && right != null){
        right.deleteById(id);
      } else {
        throw new IllegalArgumentException("Requested id does not exist or is invalid.");
      }
    }
  }

  /**
   * Returns the minimum subtree rooted at the current node.
   * If the left subtree is not empty, it recursively calls the method on the left subtree.
   * Otherwise, it returns the current node.
   * @return the minimum subtree rooted at the current node
   */
  @SuppressWarnings("unchecked")
  private BSTImpl<Employee> getMinTree() {
    if(left != null && !left.isEmpty()){
      return left.getMinTree();
    } else {
      return (BSTImpl<Employee>) this;
    }
  }

  /**
   * Deletes the node with the specified ID from the binary search tree.
   * If the node has two children, it replaces the node with the minimum node from the right subtree.
   * If the node has one child, it replaces the node with its child.
   * If the node has no children, it removes the node from the tree.
   * @param id the ID of the node to be deleted
   */
  private void deleteByIdImpl(Long id) {
    if(left != null && right != null){
      // Case 1: Node has two children
      BSTImpl<Employee> minTree = right.getMinTree();
      entity = minTree.entity;
      right.deleteById(minTree.entity.getId());
    }else if(left != null || right != null){
      // Case 2: Node has one child
      BSTImpl<Employee> child = left != null ? left : right;
      this.entity = child.entity;
      this.left = child.left;
      this.right = child.right;
    }else {
      // Case 3: Node has no children
      if(parent != null){
        if(this == parent.left) parent.left = null;
        if(this == parent.right) parent.right = null;
        parent = null;
      }
      entity = null;
    }
  }  
}
