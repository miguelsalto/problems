package algorithms.other;

import algorithms.other.FindIntersectionNodeOfLinkedListWithCycle.ListNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FindIntersectionNodeOfLinkedListWithCycleTest {

    @Test
    void testFindIntersectionNodeBeforeLoopNode() {
        HeadLoopNodes headLoopNodes = createListWithLoopNode(
                4, // id of the loop node
                9 // id of the last node
        );
        ListNode intersection = headLoopNodes.head.next.next;
        runScenario(headLoopNodes, intersection);
    }

    @Test
    void testFindIntersectionNodeInLoopNode() {
        HeadLoopNodes headLoopNodes = createListWithLoopNode(
                3, // id of the loop node
                5 // id of the last node
        );
        ListNode intersection = headLoopNodes.loop;
        runScenario(headLoopNodes, intersection);
    }

    private void runScenario(HeadLoopNodes headLoopNodes, ListNode intersection) {
        ListNode head1 = headLoopNodes.head;
        ListNode head2 = new ListNode(11);
        head2.next = intersection;
        FindIntersectionNodeOfLinkedListWithCycle sol =
                new FindIntersectionNodeOfLinkedListWithCycle();
        assertThat(sol.findIntersectionNode(head1, head2), is(intersection));
    }

    private static HeadLoopNodes createListWithLoopNode(int loopNodeId, int lastNodeId) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
        ListNode loopNode = null;
        for (int id = 2; id <= lastNodeId; ++id) {
            ListNode current = new ListNode(id);
            tail.next = current;
            tail = current;
            if (id == loopNodeId) {
                loopNode = current;
            }
        }
        tail.next = loopNode;
        return new HeadLoopNodes(head, loopNode);
    }

    private static class HeadLoopNodes {
        final ListNode head;
        final ListNode loop;

        HeadLoopNodes(ListNode head, ListNode loop) {
            this.head = head;
            this.loop = loop;
        }
    }
}