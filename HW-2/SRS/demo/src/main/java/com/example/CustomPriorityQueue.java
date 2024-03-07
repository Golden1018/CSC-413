package com.example;

import java.util.PriorityQueue;

// Queue class implementing the PriorityQueue based on PriorityComparable
class CustomPriorityQueue<T extends PriorityComparable> {
    private final PriorityQueue<T> priorityQueue;

    public CustomPriorityQueue() {
        this.priorityQueue = new PriorityQueue<>();
    }

    public void enqueue(T item) {
        priorityQueue.offer(item);
    }

    public T dequeue() {
        return priorityQueue.poll();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }
}
