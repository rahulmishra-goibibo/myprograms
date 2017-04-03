package binarytrees;

import java.util.Stack;

/**
 * Created by rahulmishra on 20/02/16.
 */
public class BinarySearchTree {

    binarytreenode root;

    public BinarySearchTree(int data) {
        root = new binarytreenode();
        root.data = data;
    }

    public BinarySearchTree() {
        root = null;
    }

    public binarytreenode addNode(int data) {
        binarytreenode temp = new binarytreenode();
        if (root == null) {
            temp.data = data;
            root = temp;
            return root;
        } else {
            temp=root;
            binarytreenode temp1 = temp;
            boolean addToLeft = true;
            while (temp != null) {
                if (temp.data >= data) {
                    temp1 = temp;
                    temp = temp.left;
                    addToLeft = true;
                }
                else{
                    temp1 = temp;
                    addToLeft = false;
                    temp = temp.right;
                }
            }
            if(addToLeft){
                temp1.left = new binarytreenode();
                temp1.left.data = data;
            }
            else{
                temp1.right = new binarytreenode();
                temp1.right.data = data;
            }
            return temp1;
        }

    }

    public void merge(binarytreenode root1, binarytreenode root2) {
        if(root1 == null) {
            inorder(root1);
            return;
        }
        if(root2 == null) {
            inorder(root2);
            return;
        }

        binarytreenode current1 = root1;
        binarytreenode current2 = root2;

        Stack<binarytreenode> s1 = new Stack<>();
        s1.push(root1);
        Stack<binarytreenode> s2 = new Stack<>();
        s2.push(root2);

        while(!s1.isEmpty() && !s2.isEmpty()) {

            current1 = s1.peek();
            current2 = s2.peek();
            while(current1.left!=null) {
                s1.push(current1.left);
                current1 = current1.left;
            }


        }
    }

    public void inorder(binarytreenode root) {
        Stack<binarytreenode> stack = new Stack<>();

        while(root!=null || !stack.isEmpty()) {
            if(root!=null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }

    public void preorderTraversal(binarytreenode root){
        if(root!=null){
            System.out.println(root.data);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

}
