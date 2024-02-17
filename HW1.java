import java.util.Iterator;
import java.util.NoSuchElementException;

// Interface defining the methods for a generic list
interface ListInterface<E> {
    // Method to add a new element to the end of the list
    void add(E newEntry);

    // Method to add a new element at a specific position in the list
    boolean add(int newPosition, E newEntry);

    // Method to remove an element at a specific position in the list
    E remove(int givenPosition);

    // Method to clear all elements from the list
    void clear();

    // Method to replace the element at a specific position in the list
    E replace(int givenPosition, E newEntry);

    // Method to get the element at a specific position in the list
    E getEntry(int givenPosition);

    // Method to convert the list to an array
    Comparable[] toArray();

    // Method to check if the list contains a specific element
    boolean contains(E anEntry);

    // Method to get the number of elements in the list
    int getLength();

    // Method to check if the list is empty
    boolean isEmpty();

    // Method to get an iterator for iterating through the list
    Iterator<E> getIterator();
}

// Implementation of a linked list
class MyLList<E> implements ListInterface<E> {
    private Node<E> head;  // Head of the linked list
    private int size;      // Size of the linked list

    // Constructor for MyLList
    public MyLList() {
        head = null;
        size = 0;
    }

    // Node class representing an element in the linked list
    class Node<T> {
        private T data;         // Data of the node
        private Node<T> next;   // Reference to the next node in the list

        // Constructor for Node
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void add(E newEntry) {
        // Add a new element to the end of the list
        Node<E> newNode = new Node<>(newEntry);
        if (isEmpty()) {
            // If the list is empty, set the new node as the head
            head = newNode;
        } else {
            // Otherwise, traverse to the end and add the new node
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public boolean add(int newPosition, E newEntry) {
        // Add a new element at a specific position in the list
        if (newPosition < 1 || newPosition > size + 1) {
            // Check for valid position, throw exception if invalid
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<E> newNode = new Node<>(newEntry);
        if (newPosition == 1) {
            // If adding at the beginning, adjust the head
            newNode.next = head;
            head = newNode;
        } else {
            // Otherwise, find the previous node and update references
            Node<E> previous = getNodeAt(newPosition - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }

        size++;
        return true;
    }

    @Override
    public E remove(int givenPosition) {
        // Remove an element at a specific position in the list
        if (givenPosition < 1 || givenPosition > size) {
            // Check for valid position, throw exception if invalid
            throw new IndexOutOfBoundsException("Invalid position");
        }

        E removedData;
        if (givenPosition == 1) {
            // If removing the first element, update the head
            removedData = head.data;
            head = head.next;
        } else {
            // Otherwise, find the previous node and update references
            Node<E> previous = getNodeAt(givenPosition - 1);
            Node<E> current = previous.next;
            removedData = current.data;
            previous.next = current.next;
        }

        size--;
        return removedData;
    }

    @Override
    public void clear() {
        // Clear all elements from the list
        head = null;
        size = 0;
    }

    @Override
    public E replace(int givenPosition, E newEntry) {
        // Replace the element at a specific position in the list
        if (givenPosition < 1 || givenPosition > size) {
            // Check for valid position, throw exception if invalid
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<E> nodeToReplace = getNodeAt(givenPosition);
        E originalData = nodeToReplace.data;
        nodeToReplace.data = newEntry;

        return originalData;
    }

    @Override
    public E getEntry(int givenPosition) {
        // Get the element at a specific position in the list
        if (givenPosition < 1 || givenPosition > size) {
            // Check for valid position, throw exception if invalid
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<E> targetNode = getNodeAt(givenPosition);
        return targetNode.data;
    }

    @Override
    public Comparable[] toArray() {
        // Convert the list to an array
        @SuppressWarnings("unchecked")
        E[] result = (E[]) new Object[size];
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public boolean contains(E anEntry) {
        // Check if the list contains a specific element
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(anEntry)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int getLength() {
        // Get the number of elements in the list
        return size;
    }

    @Override
    public boolean isEmpty() {
        // Check if the list is empty
        return size == 0;
    }

    @Override
    public Iterator<E> getIterator() {
        // Get an iterator for iterating through the list
        return new LinkedListIterator();
    }

    // Helper method to get the Node at a specific position
    private Node<E> getNodeAt(int position) {
        if (position < 1 || position > size) {
            // Check for valid position, throw exception if invalid
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<E> current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    // Iterator implementation for the linked list
    class LinkedListIterator implements Iterator<E> {
        private Node<E> current;  // Current node in the iteration

        // Constructor for the iterator
        public LinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            // Check if there is another element in the iteration
            return current != null;
        }

        @Override
        public E next() {
            // Get the next element in the iteration
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public String toString() {
        // Convert the list to a string for convenient printing
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}

// Main class to demonstrate the usage of the linked list
class Main {
    public static void main(String[] args) {
        // Create an instance of the linked list
        MyLList<String> myList = new MyLList<>();

        // Add elements to the list
        myList.add("My name is Hsin Ying Tsai");
        myList.add("One");
        myList.add("2");
        myList.add("Three");
        myList.add("4");
        myList.add("five");
        myList.add("6");
        myList.add("seven");
        myList.add("8");
        myList.add("nine");
        myList.add("10");

        // Print the entire list
        System.out.println(myList);

        // Get an iterator for the list
        Iterator<String> iterator = myList.getIterator();

        // Iterate through the list and print elements
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

