package leet;

public class PopulatingNextRightPointersII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(-9);
        TreeLinkNode b = new TreeLinkNode(-3);
        TreeLinkNode c = new TreeLinkNode(2);
        TreeLinkNode d = new TreeLinkNode(4);
        TreeLinkNode e = new TreeLinkNode(4);
        TreeLinkNode f = new TreeLinkNode(0);
        TreeLinkNode g = new TreeLinkNode(-6);
        TreeLinkNode h = new TreeLinkNode(-5);

        a.left = b;
        a.right = c;

        b.right = d;

        c.left = e;
        c.right = f;

        d.left = g;

        f.left = h;

        connect(a);
    }

    public static void connect(TreeLinkNode root) {
        TreeLinkNode leftWall = root;
        // Loop invariant:
        // All children of leftWall and its siblings are linked together via next pointer
        while (leftWall != null) {
            TreeLinkNode cross = leftWall;
            // Loop invariant:
            // left child of cross points to the next child of cross or its siblings
            // right child of cross points to the next child of cross or its siblings
            while (cross != null) {
                if (cross.left != null) {
                    if (cross.right != null)
                        cross.left.next = cross.right;
                    else
                        cross.left.next = findNext(cross);
                }

                if (cross.right != null) {
                    cross.right.next = findNext(cross);
                }

                cross = cross.next;
            }

            if (leftWall.left != null)
                leftWall = leftWall.left;
            else if (leftWall.right != null)
                leftWall = leftWall.right;
            else
                leftWall = findNext(leftWall);
        }
    }

    // findNext returns the next child of root's sibling
    private static TreeLinkNode findNext(TreeLinkNode root) {
        TreeLinkNode next = root.next;
        while (next != null) {
            if (next.left != null)
                return next.left;
            if (next.right != null)
                return next.right;
            next = next.next;
        }
        return null;
    }
}