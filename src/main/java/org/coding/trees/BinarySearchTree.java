package org.coding.trees;

public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // Recursive function to insert a value in BST
    public boolean addRecursive(int value){
        root = recursiveInsert(this.root, value);
        return true;
    }

    public Node recursiveInsert(Node currentNode, int value){
        if(currentNode == null){
            currentNode = new Node(value);
        }

        if(value < currentNode.getData()){
            currentNode.setLeft(recursiveInsert(currentNode.getLeft(), value));
        }else if(value > currentNode.getData()){
            currentNode.setRight(recursiveInsert(currentNode.getRight(), value));
        }else{
            return currentNode;
        }

        return currentNode;
    }

    // Iterative function to insert a value in BST
    public boolean add(int value){
        // check if its empty
        if(isEmpty()){
            root = new Node(value);
            return true;
        }

        // Starting from the root
        Node currentNode = root;

        while(currentNode != null){
            Node leftChild = currentNode.getLeft();
            Node rightChild = currentNode.getRight();

            if(currentNode.getData() > value){
                if(leftChild == null){
                    leftChild = new Node(value);
                    currentNode.setLeft(leftChild);
                    return true;
                }

                currentNode = leftChild;
            }else{
                if(rightChild == null){
                    rightChild = new Node(value);
                     currentNode.setRight(rightChild);
                     return true;
                }
                currentNode = rightChild;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return root == null ;
    }
}
