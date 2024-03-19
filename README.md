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