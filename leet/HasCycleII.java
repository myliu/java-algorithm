package leet;

import java.util.HashSet;
import java.util.Set;

public class HasCycleII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // {1,2}, tail connects to node index 0
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        b.next = a;

        ListNode result = detectCycle(a);
        System.out.println(result.val);
    }
    
    public static ListNode detectCycle(ListNode head) {
        ListNode a = head;
        if (a == null)
            return null;
            
        ListNode b = a.next;
        if (b == null)
            return null;

        // cycle contains all the ListNode that comprises the cycle
        Set<ListNode> cycle = new HashSet<ListNode>();
        // c is the first ListNode found in cycle by hare and tortoise algorithm
        ListNode c = null;

        while (b != null) {
            if (a == b) {
                c = a;
                break;
            }
            
            a = a.next;
            
            if (b.next == null)
                return null;
            
            b = b.next.next;
        }
        
        // Build cycle
        while (c != null && !cycle.contains(c)) {
            cycle.add(c);
            c = c.next;
        }
        
        // Traverse the LinkedList again to figure out the first ListNode
        ListNode d = head;
        while (d != null) {
            if (cycle.contains(d))
                return d;
            d = d.next;
        }
        
        return null;
    }

}
