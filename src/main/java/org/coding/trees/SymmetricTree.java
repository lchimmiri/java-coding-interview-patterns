package org.coding.trees;

import java.util.Stack;

public class SymmetricTree {
    public static void main(String[] args) {

        Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(2);
       root.left.left = new Node(3);
       root.left.right = new Node(4);

       root.right.left = new Node(4);
       root.right.right = new Node(3);

        System.out.println(isSymmetricRec(root));

    }


    // Recursive TC : O(n) SC : O(n)
    public static boolean isSymmetricRec(Node root){
        if(root == null){
            return true;
        }

        return isSymmetricHelper(root.getLeft(), root.getRight());
    }

    private static boolean isSymmetricHelper(Node left, Node right) {
        if(left == null && right == null) return true;

        if(left == null || right == null || left.getData() != right.getData()) return false;

        return isSymmetricHelper(left.getLeft(), right.getRight()) && isSymmetricHelper(left.getRight(), right.getLeft());
    }

    // Iterative TC : O(n) SC : O(n)
    public static boolean isSymmetric(Node root){
        if(root == null){
            return true;
        }
        Stack<Node> stack = new Stack<>();

        stack.push(root.getLeft());
        stack.push(root.getRight());

        while(!stack.isEmpty()){
            Node n1 = stack.pop();
            Node n2 = stack.pop();

            if(n1 == null && n2 == null){
                continue;
            }

            if(n1 == null || n2 == null || n1.getData() != n2.getData()) return false;

            stack.push(n1.getLeft());
            stack.push(n2.getRight());

            stack.push(n1.getRight());
            stack.push(n2.getLeft());
        }

        return true;
     }
}
