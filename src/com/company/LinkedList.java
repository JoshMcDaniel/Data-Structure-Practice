package com.company;

import java.util.Objects;

public class LinkedList {

    // Creating a pointer to the head & tail of the LinkedList
    private int length = 0;
    private Node head;
    private Node tail;

    // When initialized, the head is the only Node and,
    // therefore, it is also the tail
    LinkedList(Object item) {
        this.head = new Node(item);
        this.tail = this.head;
        this.length++;
    }

    // Adds item to the end of the LinkedList
    public void append(Object item) {
        Node newNode = new Node(item);
        this.tail.next = newNode; // First, point to the new node
        this.tail = newNode; // Then, new node will become the tail
        this.length++;
    }

    public void prepend(Object item) {
        Node newNode = new Node(item);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    public void remove(Object item) {
        Node currentNode = this.head;
        Node previous = currentNode;
        int counter = 0;
        while (counter != this.length) {
            if (this.head.data == item) {
                head = head.next;
            }
            else if (currentNode.data == item) {
                previous.next = currentNode.next;
                this.length--;
            } else {
                previous = currentNode;
                currentNode = currentNode.next;
                counter++;
            }
        }
    }

    public void reverse() {
        if (this.length >= 2) {
            Node firstNode = this.head;
            this.tail = this.head;
            Node secondNode = firstNode.next;
            while (secondNode != null) {
                Node tempNode = secondNode.next;
                secondNode.next = firstNode;
                firstNode = secondNode;
                secondNode = tempNode;
            }
            this.head.next = null;
            this.head = firstNode;
        }
    }

    public void printLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public int getLength() {
        return this.length;
    }

    // Nodes used to fill the LinkedList
    public class Node {
        Object data;
        Node next = null;
        Node(Object data) {
            this.data = data;
        }
    }

}
