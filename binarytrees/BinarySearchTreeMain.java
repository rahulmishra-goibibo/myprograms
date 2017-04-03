package binarytrees;

/**
 * Created by rahulmishra on 20/02/16.
 */
public class BinarySearchTreeMain {

    public static void main(String args[]) {

        BinarySearchTree tree = new BinarySearchTree();
        int array[] = {21, 12, 34, 1, 23, 45, 2};

        for (int i = 0; i < array.length; i++) {
            tree.addNode(array[i]);
        }

        tree.inorder(tree.root);

    }
}
