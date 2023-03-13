package agh.ii.prinjava.lab03.exc03_01;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public interface QueueOfInts {
    void enqueue(int x);

    int dequeue();

    default boolean isEmpty() {

        return numOfElems() == 0;
    }

    int numOfElems();

    int peek();
}

class LinkedListBasedImpl implements QueueOfInts {

    private Node head, tail;
    private int size;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    @Override
    public void enqueue(int z) {
        Node newNode = new Node(z);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int value = head.value;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return value;
    }

    @Override
    public int numOfElems() {
        return size;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private QueueOfInts queue;
    
    // enqueueing and dequeuing elements

    @BeforeEach
    void setUp() {
        queue = new LinkedListBasedImpl();
    }

    @Test
    void testEnqueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assertions.assertEquals(3, queue.numOfElems());
        Assertions.assertEquals(1, queue.peek());
    }

    @Test
    void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assertions.assertEquals(1, queue.dequeue());
        Assertions.assertEquals(2, queue.dequeue());
        Assertions.assertEquals(1, queue.numOfElems());
        Assertions.assertEquals(3, queue.peek());
    }

    // Checking the number of elements in the queue

    @Test
    void testNumOfElems() {
        Assertions.assertEquals(0, queue.numOfElems());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assertions.assertEquals(3, queue.numOfElems());
        queue.dequeue();
        queue.dequeue();
        Assertions.assertEquals(1, queue.numOfElems());
    }

    // Peeking at the front element
    @Test
    void testPeek() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assertions.assertEquals(1, queue.peek());
        queue.dequeue();
        Assertions.assertEquals(2, queue.peek());
        queue.dequeue();
        Assertions.assertEquals(3, queue.peek());
    }

    // Checking if the queue is empty
    @Test
    void testIsEmpty() {
        Assertions.assertTrue(queue.isEmpty());
        queue.enqueue(1);
        Assertions.assertFalse(queue.isEmpty());
        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty());
    }

    // testDequeueEmptyQueue and testPeekEmptyQueue are handling exceptions thrown when trying to dequeue or peek an empty queue
    @Test
    void testDequeueEmptyQueue() {
        Assertions.assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    void testPeekEmptyQueue() {
        Assertions.assertThrows(NoSuchElementException.class, queue::peek);
    }
}




