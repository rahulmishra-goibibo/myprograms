package binarytrees;

/**
 * Created by rahulmishra on 20/02/16.
 */
public class BinaryTreemain {

    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();

        binarytreenode root  = tree.addNode(10);
        root.left  = tree.addNode(12);
        root.right = tree.addNode(13);

        root.right.left   = tree.addNode(14);
        root.right.right  = tree.addNode(15);

        root.right.left.left   = tree.addNode(21);
        root.right.left.right  = tree.addNode(22);
        root.right.right.left  = tree.addNode(23);
        root.right.right.right = tree.addNode(24);

        root.right.left.left.left  = tree.addNode(1);
        root.right.left.left.right = tree.addNode(2);
        root.right.left.right.left  = tree.addNode(3);
        root.right.left.right.right = tree.addNode(4);
        root.right.right.left.left  = tree.addNode(5);
        root.right.right.left.right = tree.addNode(6);
        root.right.right.right.left = tree.addNode(7);
        root.right.right.right.right = tree.addNode(8);

        tree.preorderTraversal(tree.root);

        int minLeafParent=0;
        tree.closestLeafPreOrder(tree.root,null,13);
        if(tree.parent == null){
            System.out.println("Min leaf height is "+tree.minLeafHeight);
            return;
        }
        else{
            minLeafParent = tree.findClosestLeaf(tree.parent)+1;
        }

        int finalResult = minLeafParent>tree.minLeafHeight?tree.minLeafHeight:minLeafParent;
        System.out.println("Final result is "+finalResult);




//        int largestDifference = tree.largestDifference(tree.root);
//        System.out.print("diff is "+largestDifference);
    }
}
