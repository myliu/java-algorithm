package leet;

public class PopulatingNextRightPointers {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    // Definition for binary tree with next pointer.
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode leftWall = root;
        // Loop invariant:
        // All children of leftWall and its siblings are linked together via next pointer
        while (leftWall != null) {
            TreeLinkNode cross = leftWall;
            // Loop invariant:
            // left child of cross points to the right child of cross
            // right child of cross points to the left child of cross's right sibling if it exists
            while (cross != null) {
                if (cross.left == null) {
                    return;
                }

                cross.left.next = cross.right;

                if (cross.next == null) {
                    cross.right.next = null;
                } else {
                    cross.right.next = cross.next.left;
                }

                cross = cross.next;
            }

            leftWall = leftWall.left;
        }
    }
}