package com.company;

public class BinarySearchTree {

  private Node root;

  public BinarySearchTree(){
    root = null;
  }


  /**
   * Region Main functions
   * This contains all the main methods
   * like Insert(data)
   *      delete(data)
   *      inorderTraverse(Node)
   * */

  public void insert(int data){
    root = insert(data, root);
  }

  /**
   * Method insert
   * recursively runs down the tree and insert the node accordingly
   * @param data = data to be inserted
   * @param root = the root of the current tree
   * */
  private Node insert(int data, Node root){

    //Check if the root is null and insert the data
    if(root == null){
      return root = new Node(data);
    }

    //Travers down the tree accordingly if data smaller move left else move right
    if(root.getData() > data){
      root.setLeft(insert(data, root.getLeft()));
    }else{
      root.setRight(insert(data, root.getRight()));
    }

    //return the current root;
    return root;

  }


  /*
  * Region Helper Methods
  *
  * This contains helper misc functions used in the algo
  *
  * */

}
