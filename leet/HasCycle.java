package leet;

public class HasCycle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // {1,2}, tail connects to node index 0
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        b.next = a;

        if (hasCycle(a))
            System.out.println("True");
        else
            System.out.println("False");

        // {1,2}, no cycle
        a = new ListNode(1);
        b = new ListNode(2);
        a.next = b;
        b.next = null;

        if (hasCycle(a))
            System.out.println("True");
        else
            System.out.println("False");
    }

    // The only condition to return true is slow node a is the same as fast node
    // b
    public static boolean hasCycle(ListNode head) {
        ListNode a = head;
        if (a == null)
            return false;

        ListNode b = a.next;
        if (b == null)
            return false;

        while (b != null) {
            if (a == b)
                return true;

            a = a.next;

            if (b.next == null)
                return false;

            b = b.next.next;
        }

        return false;
    }

}
