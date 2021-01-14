package com.wonseok.queue;

interface QueueInterface {
    boolean isEmpty();

    boolean isFull();

    void enqueue(String data);

    void dequeue();

    void peek();

    void clear();

}

public class QueueImplement implements QueueInterface {
    Node front;
    Node rear;
    Node back;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void enqueue(String data) {

    }

    @Override
    public void dequeue() {

    }

    @Override
    public void peek() {

    }

    @Override
    public void clear() {

    }
}

class Node {
    int data;
    Node next;
}
