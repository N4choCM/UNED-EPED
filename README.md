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