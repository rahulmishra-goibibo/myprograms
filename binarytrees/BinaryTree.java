package binarytrees;

/**
 * Created by rahulmishra on 20/02/16.
 */
public class BinaryTree {

    binarytreenode root;
    binarytreenode parent;
    int minLeafHeight;

    public BinaryTree() {
        root = null;
    }

    public binarytreenode addNode(int data) {
        if (root == null) {
            root = new binarytreenode();
            root.data = data;
            return root;
        } else {
            binarytreenode temp = new binarytreenode();
            temp.data = data;
            return temp;
        }
    }

    public void preorderTraversal(binarytreenode root) {
        if (root != null) {
            System.out.println(root.data);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public int largestDifference(binarytreenode root) {
        if (root != null) {

            int leftDifferenceRoot = Integer.MIN_VALUE, rightDifferenceRoot = Integer.MIN_VALUE;
            int leftDifference = largestDifference(root.left);
            int rightDifference = largestDifference(root.right);

            if (leftDifference == Integer.MAX_VALUE && rightDifference == Integer.MAX_VALUE) {
                return root.data;
            }

            if (leftDifference != Integer.MAX_VALUE) {
                if (leftDifference < 0) {
                    leftDifferenceRoot = (root.data - root.left.data) > leftDifference ? root.data - root.left.data : leftDifference;
                } else {
                    leftDifferenceRoot = root.data + (-root.left.data + leftDifference);
                }
            }

            if (rightDifference != Integer.MAX_VALUE) {

                if (rightDifference < 0) {
                    rightDifferenceRoot = (root.data - root.right.data) > rightDifference ? root.data - root.right.data : rightDifference;
                } else {
                    rightDifferenceRoot = root.data + (-rightDifference + root.right.data);
                }
            }
            return leftDifferenceRoot > rightDifferenceRoot ? leftDifferenceRoot : rightDifferenceRoot;


        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void closestLeafPreOrder(binarytreenode root, binarytreenode parent, int data) {
        if (root != null) {

            if (root.data == data) {
                minLeafHeight = findClosestLeaf(root);
                this.parent = parent;
                return;
            }
            closestLeafPreOrder(root.left, root, data);
            closestLeafPreOrder(root.right, root, data);

        }
    }

    public int findClosestLeaf(binarytreenode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = findClosestLeaf(root.left);
        int right = findClosestLeaf(root.right);

        return left > right ? right + 1 : left + 1;
    }
}
