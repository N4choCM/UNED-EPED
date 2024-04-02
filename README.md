# 🤔 Programming Strategies & Data Structures

## 💻 Data Structures

### 📝 Linked List

A `linked list` is a fundamental data structure used in computer science for storing and managing collections of data. It consists of a sequence of elements, called nodes, where each node contains some data and a reference (or pointer) to the next node in the sequence.

👍🏼 `Advantages`:
- Dynamic size -> Linked lists can grow or shrink in size during program execution, as memory allocation is done dynamically.
- Efficient insertion and deletion -> Insertion and deletion operations can be performed efficiently, especially in comparison to arrays, as they don't require shifting elements.
- Flexible memory allocation -> Linked lists can be easily extended without needing to reallocate memory for the entire data structure.

👎🏼 `Disadvantages`:
- Sequential access -> Accessing elements in a linked list sequentially can be slower compared to arrays because linked lists don't provide direct access to elements by index.
- Extra memory overhead -> Each node in a linked list requires additional memory to store the pointer/reference to the next node, leading to more memory overhead compared to arrays.
- Not cache-friendly -> Due to the scattered memory allocation of nodes, linked lists may not utilize the CPU cache efficiently, resulting in slower performance for some operations.

### 🚦 Queue

A `queue` is a linear data structure that follows the First In First Out (FIFO) principle, where elements are inserted at the rear and removed from the front. It is often likened to a line of people waiting for service, where the person who has been waiting the longest is the first to be served.

👍🏼 `Advantages`:
- FIFO order -> Queues maintain the order in which elements are inserted, making them suitable for scenarios where order matters.
- Simple implementation -> Implementing a queue is straightforward and can be done using various underlying data structures, such as arrays or linked lists.
- Useful for synchronization -> Queues are commonly used for inter-process communication and synchronization in multi-threaded environments.

👎🏼 `Disadvantages`:
- Limited access -> Unlike some other data structures like arrays, queues typically only allow access to the front and rear elements, limiting flexibility in accessing arbitrary elements.
- Fixed size (in some implementations) -> Some implementations of queues have a fixed size, which can lead to overflow errors if the queue becomes full and additional elements are inserted.
- Overhead for dynamic resizing -> Dynamic resizing of queues, if supported, can incur overhead in terms of memory allocation and copying elements to the resized queue.

### 📚 Stack

A `stack` is a linear data structure that follows the Last In First Out (LIFO) principle, where elements are inserted (pushed) and removed (popped) from the same end, traditionally referred to as the top. It is often compared to a stack of plates, where you can only add or remove the top plate.

👍🏼 `Advantages`:
- LIFO order -> Stacks maintain the order in which elements are inserted and provide easy access to the most recently added elements.
- Simple implementation -> Implementing a stack is straightforward and can be done using various underlying data structures, such as arrays or linked lists.
- Recursive function calls -> Stacks are used in programming languages to manage function calls and support recursion.

👎🏼 `Disadvantages`:
- Limited access -> Similar to queues, stacks typically only allow access to the top element, limiting flexibility in accessing arbitrary elements.
- Fixed size (in some implementations) -> Some implementations of stacks have a fixed size, which can lead to overflow errors if the stack becomes full and additional elements are pushed.
- Overhead for dynamic resizing -> Dynamic resizing of stacks, if supported, can incur overhead in terms of memory allocation and copying elements to the resized stack.

### 🌳 Binary Search Trees (BST)

A `BST`  is a hierarchical data structure consisting of nodes, where each node has at most two children, referred to as the left child and the right child. The binary search tree property ensures that for any given node:

* All nodes in the left subtree have values less than the node's value.
* All nodes in the right subtree have values greater than the node's value.

👍🏼 `Advantages`:
- Efficient searching -> Binary search trees provide efficient search operations (average case O(log n)) due to their hierarchical nature and the binary search property, making them suitable for applications requiring fast retrieval of data.
- Ordered structure -> The binary search tree maintains data in sorted order, which can be beneficial for applications requiring sorted data traversal or retrieval.
- Easy insertion and deletion -> Insertion and deletion operations in binary search trees can be performed efficiently (average case O(log n)) while maintaining the binary search tree property.

👎🏼 `Disadvantages`:
- Imbalanced trees -> In worst-case scenarios, binary search trees can become unbalanced, leading to degradation in performance (O(n) for search, insertion, and deletion operations). This can occur if the tree is constructed in a non-optimal order or if certain operations lead to an imbalance.
- Degenerate trees -> In the worst-case scenario, binary search trees can degenerate into linked lists if elements are inserted or deleted in a sorted order, resulting in poor performance for search operations (O(n)).
- Complex balancing strategies -> Balancing binary search trees (e.g., AVL trees, Red-Black trees) to maintain optimal performance requires complex algorithms and additional overhead in terms of memory and computation.