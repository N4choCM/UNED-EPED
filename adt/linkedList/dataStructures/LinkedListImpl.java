package adt.linkedList.dataStructures;


public class LinkedListImpl<E> implements LinkedList<E>{
  // MARK I - Properties
  private Node head;
  private int length = 0;


  /**
   * Node class to represent the elements of the Linked List
   */
  public class Node {
    // MARK II - Properties
    public E entity;
    public Node next = null;

    /**
     * Constructs a new Node object with the specified entity.
     * @param entity the entity to be stored in the node
     */
    public Node(E entity) {
      this.entity = entity;
    }
  }

  /**
   * Inserts a new node with the given entity at the beginning of the linked list.
   * @param entity the entity to be inserted in the node
   */
  @Override
  public void insertFirst(E entity) {
    // Creates a new node with the given entity
    Node newNode = new Node(entity);
    // Sets the next node of the new node to the current head
    newNode.next = head;
    // Updates the head of the linked list to the new node, as it was inserted in the first position
    head = newNode;
    // Increments the length of the linked list
    length++;
  }

  /**
   * Inserts a new node containing the given entity at the end of the linked list.
   * If the linked list is empty, the new node becomes the head of the list.
   * @param entity the entity to be inserted
   */
  @Override
  public void insertLast(E entity) {
    // Creates a new node with the given entity
    Node newNode = new Node(entity);
    // If the linked list is empty, the new node becomes the head of the list
    if (head == null) {
      head = newNode;
    }else{
      // Otherwise, it traverses the list until it reaches the last node
      // For doing that, it creates a pointer node that starts at the head of the list
      Node pointer = head;
      // While the next node of the pointer is not null, it updates the pointer to the next node
      while (pointer.next != null) {
        pointer = pointer.next;
      }
      // When the next node of the pointer is null, it sets the next node of the pointer to the new node
      pointer.next = newNode;
    }
    // Increments the length of the linked list
    length++;
  }

  /**
   * Inserts a new node containing the specified entity after the node at the given index.
   * If the index is out of bounds, the new node is inserted at the end of the linked list.
   * @param index the index after which the new node should be inserted
   * @param entity the entity to be inserted
   */
  @Override
  public void insertAfterIndex(int index, E entity) {
    // Creates a new node with the given entity
    Node newNode = new Node(entity);
    // If the linked list is empty, the new node becomes the head of the list
    if (head == null) {
      head = newNode;
    }else{
      // Otherwise, it traverses the list until it reaches the node at the given index
      // For doing that, it creates a pointer node that starts at the head of the list
      Node pointer = head;
      // It also creates a counter to keep track of the current index
      int counter = 0;
      // While the counter is less than the given index and the next node of the pointer is not null,
      while (counter < index && pointer.next != null) {
        // It updates the pointer to the next node and increments the counter
        pointer = pointer.next;
        counter++;
      }
      // Assigns the next node of the pointer to the next node of the new node
      // This is because the next node of the new node will be the next of the current pointer
      newNode.next = pointer.next;
      // Assigns the newNode to the next node of the pointer
      // This is because the next node of the current one is going to be the newNode
      pointer.next = newNode;
    }
    // Increments the length of the linked list
    length++;
  }

  /**
   * Retrieves a entity from the linked list based on the given index.
   * @param index The index of the entity to retrieve.
   * @return The entity at the specified index, or null if the index is out of range 
   * or the linked list is empty.
   */
  @Override
  public E getByIndex(int index) {
    // If the linked list is empty, it returns null
    if (head == null) {
      return null;
    }else {
      // Otherwise, it traverses the list until it reaches the node at the given index
      // For doing that, it creates a pointer node that starts at the head of the list
      Node pointer = head;
      // It also creates a counter to keep track of the current index
      int counter = 0;
      // While the counter is less than the given index and the next node of the pointer is not null,
      // it updates the pointer to the next node and increments the counter
      while (counter < index && pointer.next != null) {
        pointer = pointer.next;
        counter++;
      }
      // If the counter is not equal to the given index, it returns null
      if (counter != index) {
        return null;
      }
      // Otherwise, it returns the entity stored in the node at the given index
      return pointer.entity;
    }
  }

  /**
   * Returns the length of the linked list.
   * @return the length of the linked list
   */
  @Override
  public int getLength() {
    return length;
  }

  /**
   * Checks if the linked list is empty.
   * @return true if the linked list is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * Removes the first node of the specified entity from the linked list.
   * If the entity is found, the head of the linked list is updated and the length is decremented.
   * @param entity the entity to be removed
   */
  @Override
  public void removeFirst() {
    // If the linked list is not empty, it removes the first node
    if (head != null) {
      // It creates a pointer node that starts at the head of the list
      Node first = head;
      // It updates the head of the list to the next node
      head = head.next;
      // It sets the next node of the first node to null
      first.next = null;
      // It decrements the length of the linked list
      length--;
    }
  }

  /**
   * Removes the last node of the specified entity from the linked list.
   * If the entity is found, it is removed from the list and the length of the list is decremented.
   * If the entity is not found or the list is empty, no changes are made.
   * @param entity the entity to be removed
   */
  @Override
  public void removeLast() {
    // If the linked list is not empty, it removes the last node
    if (head != null) {
      // If the linked list has only one node, it sets the head to null and decrements the length
      if(head.next == null) {
        head = null;
        length--;
      }else{
        // Otherwise, it traverses the list until it reaches the second to last node
        // For doing that, it creates a pointer node that starts at the head of the list
        Node pointer = head;
        // While the next node of the next node of the pointer is not null, it updates the pointer to the next node
        while (pointer.next.next != null) {
          pointer = pointer.next;
        }
        // When the next node of the next node of the pointer is null, it sets the next node of the pointer to null
        pointer.next = null;
        // It decrements the length of the linked list
        length--;
      }
    }
  }

  /**
   * Removes the node at the specified index from the linked list.
   * If the index is out of bounds, no action is taken.
   * @param index the index of the node to be removed
   */
  @Override
  public void removeByIndex(int index) {
    // Checks if the LinkedList is not empty
    if (head != null) {
      // If the index is 0, it removes the first node
      if (index == 0) {
        // It creates a pointer node that starts at the head of the list
        Node first = head;
        // It updates the head of the list to the next node
        head = head.next;
        // It sets the next node of the first node to null
        first.next = null;
        // It decrements the length of the linked list
        length--;
        // If the index is less than the length of the list, 
        // it traverses the list until it reaches the node at the given index
      } else if (index < length){
        // For doing that, it creates a pointer node that starts at the head of the list
        Node pointer = head;
        // It also creates a counter to keep track of the current index
        int counter = 0;
        // While the counter is less than the given index - 1, 
        // it updates the pointer to the next node and increments the counter
        // index - 1 is used because the pointer should stop at the node before the one to be removed
        while(counter < (index - 1)){
          pointer = pointer.next;
          counter++;
        }
        // It creates a temporary node that stores the next node of the pointer
        Node temp = pointer.next;
        // It sets the next node of the temporary node to the next node of the pointer
        pointer.next = temp.next;
        // It sets the next node of the temporary node to null
        temp.next = null;
        // It decrements the length of the linked list
        length--;
      }
    }
  }

  /**
   * Returns a string representation of the linked list.
   * The string contains the titles of the entitys in the linked list,
   * separated by "->" symbols.
   *
   * @return a string representation of the linked list
   */
  @Override
  public String printList(){
    // The String to be returned, starting empty as the list has not been traversed yet.
    String result = "";
    // A pointer node that starts at the head of the list
    Node pointer = head;
    // While the pointer is not null, it appends the title of the entity in the node to the result and
    // updates the pointer to the next node.
    while (pointer != null) {
      result += pointer.entity.toString() + " -> ";
      pointer = pointer.next;
    }
    return result;
  }

}
