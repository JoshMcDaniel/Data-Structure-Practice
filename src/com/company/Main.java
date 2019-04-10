package com.company;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();

        bt.insert(3);
        bt.insert(4);
        bt.insert(7);
        bt.insert(2);
        bt.insert(1);
        bt.printInOrder(bt.root);
        System.out.println("\nItems: " + bt.getItems());
        System.out.println("Tree height: " + bt.getHeight(bt.root));
        System.out.println(bt.lookUp(7)? "Yes" : "No");
    }
}
