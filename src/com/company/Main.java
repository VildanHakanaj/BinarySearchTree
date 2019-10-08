package com.company;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(100);
        tree.insert(600);
        tree.insert(700);
        tree.insert(900);
        tree.insert(650);
        tree.insert(500);
        tree.insert(400);
        tree.insert(501);
        tree.insert(50);
        tree.insert(55);
        tree.insert(56);
        tree.insert(54);
        tree.insert(40);
        tree.inorderTraversal();
        tree.postOrderTraversal();
        tree.preOrderTraversal();
    }
}
