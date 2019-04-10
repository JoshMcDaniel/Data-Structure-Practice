package com.company;

public class BinarySearchTree {

    Node root;
    private int items = 0;

    public BinarySearchTree() {
        this.root = null;
    }

    // Inner class to create new Nodes for the tree
    class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        Node currentNode = this.root;
        if (this.root == null) {
            this.root = newNode;
            items++;
        } else {
            while (true) {
                if (newNode.value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        items++;
                        return;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        items++;
                        return;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    public void printInOrder(Node node) {
        // Base case
        if (node == null) return;

        // Go all the way left before printing data
        printInOrder(node.left);
        System.out.printf("%s ", node.value);

        // Go all the way right then print data
        printInOrder(node.right);
    }

    public boolean lookUp(int value) {
        Node currentNode = this.root;
        if (this.root == null) return false;
        while (currentNode != null) {

            // Left
            if (value < currentNode.value) {
                currentNode = currentNode.left;

            // Right
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;

            // Found the value in the tree
            } else if (value == currentNode.value) {
                return true;
            }
        }
        // Didn't find anything before the currentNode became null
        return false;
    }

    public int getHeight(Node node) {
        int left = 0; int right = 0;

        // Base case
        if (node == null) return 0;

        // Left and right are increased by 1 for every recursive call
        left = getHeight(node.left);
        right = getHeight(node.right);

        // Return the larger number and add 1 to account for the root node
        return Math.max(left, right) + 1;
    }

    public int getItems() {
        return items;
    }
}
