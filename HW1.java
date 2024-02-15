import java.util.Iterator;
import java.util.NoSuchElementException;

// Interface defining the methods for a generic list
// C. ListInterface
interface ListInterface<E> {
    void add(E newEntry);

    boolean add(int newPosition, E newEntry);

    Comparable<E> remove(int givenPosition);

    void clear();

    E replace(int givenPosition, E newEntry);

    Comparable getEntry(int givenPosition);

    Comparable[] toArray();

    boolean contains(E anEntry);

    int getLength();

    boolean isEmpty();

    Iterator<E> getIterator();  // D. getIterator() method
}

// Implementation of a linked list
// A. MyLList class representing ADT List
class MyLList<E> implements ListInterface<E> {
    private Node<E> head;
    private int size;

    // Constructor for MyLList
    public MyLList() {
        head = null;
        size = 0;
    }
    
    // Node class representing an element in the linked list
    private class Node<T> {
        private T data;
        private Node<T> next;

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
            head = newNode;
        } else {
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
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<E> newNode = new Node<>(newEntry);
        if (newPosition == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> previous = getNodeAt(newPosition - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }

        size++;
        return true;
    }

    @Override
    public Comparable remove(int givenPosition) {
        // Remove an element at a specific position in the list
        if (givenPosition < 1 || givenPosition > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        E removedData;
        if (givenPosition == 1) {
            removedData = head.data;
            head = head.next;
        } else {
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
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<E> nodeToReplace = getNodeAt(givenPosition);
        E originalData = nodeToReplace.data;
        nodeToReplace.data = newEntry;

        return originalData;
    }

    @Override
    public Comparable getEntry(int givenPosition) {
        // Get the element at a specific position in the list
        if (givenPosition < 1 || givenPosition > size) {
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
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<E> current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    // Iterator implementation for the linked list
    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current;

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
}


// Main class to demonstrate the usage of the linked list
// E. Main class for testing
public class Main {
    public static void main(String[] args) {
        // Create an instance of the linked list
        MyLList<String> myList = new MyLList<>();
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

        // Get an iterator for the list
        Iterator<String> iterator = myList.getIterator();

        // Iterate through the list and print elements
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
