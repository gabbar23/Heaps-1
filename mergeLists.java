//Time Complexity (TC): O(kN)
// Space - O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * Merges two sorted linked lists into one sorted linked list.
     * 
     * @param node1 The head of the first sorted linked list.
     * @param node2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    private ListNode mergeLists(ListNode node1, ListNode node2) {
        // Create a dummy node to simplify the merging process
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;

        // Iterate through both lists until one is exhausted
        while (node1 != null && node2 != null) {
            if (node1.val >= node2.val) {
                // Attach the node from the second list if its value is smaller
                currentNode.next = node2;
                node2 = node2.next;
            } else {
                // Attach the node from the first list if its value is smaller
                currentNode.next = node1;
                node1 = node1.next;
            }
            // Move to the next node in the merged list
            currentNode = currentNode.next;
        }

        // Attach the remaining nodes from the non-exhausted list
        if (node1 != null) {
            currentNode.next = node1;
        } 
        if (node2 != null) {
            currentNode.next = node2;
        }

        // Return the next node of the dummy (skipping the dummy node itself)
        return dummyNode.next;
    }

    /**
     * Merges k sorted linked lists into one sorted linked list.
     * 
     * @param lists An array of k sorted linked lists.
     * @return The head of the merged sorted linked list.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // Return null if the input list is null or empty
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Initialize a dummy node to build the result list
        ListNode result = new ListNode(Integer.MIN_VALUE);

        // Merge all lists one by one
        for (ListNode head : lists) {
            result = mergeLists(result, head);
        }

        // Return the next node of the dummy (skipping the dummy node itself)
        return result.next;
    }
}
