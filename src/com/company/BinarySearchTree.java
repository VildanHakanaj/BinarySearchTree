package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

  private Node root;

  public BinarySearchTree() {
    root = null;
  }


  /**
   * Region Main functions
   * This contains all the main methods
   * like Insert(data)
   * delete(data)
   * inorderTraverse(Node)
   */

  public void insert(int data) {
    root = insert(data, root);
  }

  /**
   * Method insert
   * recursively runs down the tree and insert the node accordingly
   *
   * @param data = data to be inserted
   * @param root = the root of the current tree
   * @return Node -> the current root of the tree
   */
  private Node insert(int data, Node root) {

    //Check if the root is null and insert the data
    if (root == null) {
      return root = new Node(data);
    }

    //Travers down the tree accordingly if data smaller move left else move right
    if (root.getData() > data) {
      root.setLeft(insert(data, root.getLeft()));
    } else {
      root.setRight(insert(data, root.getRight()));
    }

    //return the current root;
    return root;

  }

  /**
   * Method delete
   * deletes the given data from the tree
   * <p>
   * Deleting has three cases.
   * 1. The node has no children --> just cut the leaf node
   * 2. the node has one child (left)or(right) -> we just replace the node with the child
   * 3. The node has both children -> we find the smallest on the right of the node and make adjustments accordingly
   *
   * @param data -> data wished to be deleted
   * @return void
   */
  public void delete(int data) {
    root = delete(data, root);
  }

  private Node delete(int data, Node root) {

    //Move down the tree until we find the node
    if (root.getData() > data) {
      root.setLeft(delete(data, root.getLeft()));
    } else if (root.getData() < data) {
      root.setRight(delete(data, root.getRight()));
    } else {
      /**Case 1 && 2the node has only one child*/
      if (root.getLeft() == null) {
        root = root.getRight();
      } else if (root.getRight() == null) {
        root = root.getLeft();
      } else {
        Node minimum = findMin(root.getRight());  //Get the minimum of the right subtree
        root.setData(minimum.getData());          //Update the node we want to delete with the minimum
        root.setRight(delete(minimum.getData(), root.getRight()));  //delete the node the min node we used
      }

    }

    return root;
  }

  /**
   * Traversal methods
   */

  public void inorderTraversal() {
    inorderTraversal(root);
    System.out.println("\n");
  }

  private void inorderTraversal(Node root) {

    if (root == null) {
      return;
    }

    inorderTraversal(root.getLeft());
    System.out.print(root.getData() + " ");
    inorderTraversal(root.getRight());
  }

  public void postOrderTraversal() {
    postOrderTraversal(root);
    System.out.println("\n");
  }

  private void postOrderTraversal(Node root) {
    if (root == null) {
      return;
    }

    postOrderTraversal(root.getLeft());
    postOrderTraversal(root.getRight());
    System.out.print(root.getData() + " ");
  }

  public void preOrderTraversal() {
    preOrderTraversal(root);
    System.out.println("\n");
  }

  private void preOrderTraversal(Node root) {
    if (root == null) {
      return;
    }

    System.out.print(root.getData() + " ");
    preOrderTraversal(root.getLeft());
    preOrderTraversal(root.getRight());
  }


  public void levelOrder() {

    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    Node current;

    while (!queue.isEmpty()) {

      current = queue.poll();

      if (current.getLeft() != null) {
        queue.add(current.getLeft());
      }

      if (current.getRight() != null) {
        queue.add(current.getRight());
      }

      System.out.println(current.getData());
    }


  }


  /**
   * region Secondary Methods
   * <p>
   * This are the methods that are needed by the main methods to accomplish
   * the main functionality
   */

  private Node findMin(Node root) {

    while (root.getLeft() != null) {
      root = root.getLeft();
    }

    return root;
  }

  /*
   * Region Helper Methods
   *
   * This contains helper misc functions used in the algo
   *
   * */

}
