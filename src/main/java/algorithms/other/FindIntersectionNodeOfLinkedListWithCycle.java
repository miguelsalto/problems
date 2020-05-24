package algorithms.other;

/*
 You are given, two linked list head reference and they meet at some point and we need to find the point of
 intersection between them (let's assume that this always exists).
 However, at the end of both linked lists will be a loop.
 */
public class FindIntersectionNodeOfLinkedListWithCycle {

    ListNode findIntersectionNode(ListNode head1, ListNode head2) {
        ListNode loopNode = findLoopNode(head1);
        int distance1 = getDistanceToLoopNode(head1, loopNode);
        int distance2 = getDistanceToLoopNode(head2, loopNode);
        ListNode nearer = distance1 < distance2 ? head1 : head2;
        ListNode farther = distance1 < distance2 ? head2 : head1;
        int diff = Math.abs(distance1 - distance2);
        for (int i = 0; i < diff; ++i) {
            farther = farther.next;
        }
        while (nearer != farther) {
            nearer = nearer.next;
            farther = farther.next;
        }
        return nearer;
    }

    private static ListNode findLoopNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static int getDistanceToLoopNode(ListNode node, ListNode loopNode) {
        int distance = 0;
        while (node != loopNode) {
            node = node.next;
            ++distance;
        }
        return distance;
    }

    static class ListNode {
        private final int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    '}';
        }
    }
}
