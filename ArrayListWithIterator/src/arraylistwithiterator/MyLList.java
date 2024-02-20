package arraylistwithiterator;

import java.util.List;
import java.util.NoSuchElementException;

public class MyLList<E extends Comparable<? super E>> implements ListInterface<E>, Iterable<E> {

    private boolean integrityOK;
    private ListNode firstNode;
    private ListNode lastNode;
    private int numberOfEntries;

    public MyLList() {
        clear();
    }

    public final void clear() {
        integrityOK = false;
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
        integrityOK = true;
    }

    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("Corrupt Linked List.. cannot continue..");
    }

    public boolean isEmpty() {
        return (firstNode == null);
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean contains(E anEntry) {
        checkIntegrity();
        ListNode currentNode = firstNode;
        while (currentNode != null) {
            if (anEntry.equals(currentNode.getData()))
                return true;
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    public E getEntry(int i) {
        Comparable[] arr = this.toArray();
        if ((i > 0) && (i <= arr.length)) {
            return (E) arr[i - 1];
        }
        return null;
    }

    public E replace(int position, E anEntry) {
        checkIntegrity();
        if (!((position >= 1) && (position <= numberOfEntries))) {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        } else {
            ListNode theNode = getNodeAt(position - 1);
            E originalEntry = theNode.getData();
            theNode.setData(anEntry);
            return originalEntry;
        }
    }

    public E remove(int position) {
        checkIntegrity();
        if ((position >= 1) && (position <= numberOfEntries)) {
            E result;
            if (position == 1) {
                result = firstNode.getData();
                firstNode = firstNode.getNextNode();
                if (numberOfEntries == 1) {
                    lastNode = null;
                }
            } else {
                ListNode nodeBefore = getNodeAt(position - 1);
                ListNode nodeToRemove = nodeBefore.getNextNode();
                ListNode nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
                result = nodeToRemove.getData();
                if (position == numberOfEntries) {
                    lastNode = nodeBefore;
                }
            }
            numberOfEntries--;
            return result;
        } else {
            System.out.println(position + ": is out of range of the list with size: " + numberOfEntries);
            return null;
        }
    }

    public ListInterface<E> getAllLessThan(Comparable<E> elementToCompare) {
        ListInterface<E> resultList = new MyLList<>();
        ListNode currentNode = firstNode;
        while (currentNode != null) {
            E currentElement = currentNode.getData();
            if (elementToCompare.compareTo(currentElement) > 0)
                resultList.add(currentElement);
            currentNode = currentNode.getNextNode();
        }
        return resultList;
    }

    public void add(E anEntry) {
        checkIntegrity();
        ListNode newNode = new ListNode(anEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        numberOfEntries++;
    }

    public void add(int insertPosition, E anEntry) {
    checkIntegrity();
    if ((insertPosition >= 1) && (insertPosition <= numberOfEntries + 1)) {
        ListNode newNode = new ListNode(anEntry);
        if (isEmpty() || (insertPosition == 1)) {
            newNode.setNextNode(firstNode);
            firstNode = newNode;
            if (numberOfEntries == 0) {
                lastNode = newNode;
            }
        } else {
            ListNode nodeBefore = getNodeAt(insertPosition - 1);
            ListNode nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
            if (insertPosition == numberOfEntries + 1) {
                lastNode = newNode;
            }
        }
        numberOfEntries++;
        return; // Change the return type to boolean
    } else {
        return;
    }
}


    public void printLinkedList() {
        int nodeCount = 1;
        ListNode currentNode = firstNode;
        while (currentNode != null) {
            E data = currentNode.getData();
            System.out.println("Node[" + (nodeCount++) + "]: " + data);
            currentNode = currentNode.getNextNode();
        }
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new IteratorForMyLList();
    }

    private class IteratorForMyLList implements java.util.Iterator<E> {
        private ListNode nextNode;

        private IteratorForMyLList() {
            nextNode = firstNode;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public E next() {
            if (hasNext()) {
                E result = nextNode.getData();
                nextNode = nextNode.getNextNode();
                return result;
            } else {
                throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
            }
        }
    }

    private ListNode getNodeAt(int givenPosition) {
        checkIntegrity();
        ListNode currentNode = firstNode;
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    private class ListNode {
        private E data;
        private ListNode next;

        public ListNode(E anEntry) {
            this(anEntry, null);
        }

        public ListNode(E anEntry, ListNode n) {
            this.data = anEntry;
            this.next = n;
        }

        public E getData() {
            return data;
        }

        public ListNode getNextNode() {
            return this.next;
        }

        public void setNextNode(ListNode nextNode) {
            this.next = nextNode;
        }

        public void setData(E data) {
            this.data = data;
        }
    }

    @Override
    public E[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }
}
