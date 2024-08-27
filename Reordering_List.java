// {Approach 1}
// Time Complexity : O(3n) == O(n) 
//  1. O(n) : calculating the mid point
//  2 . O(n) :  Reversing the 2nd part of the list 
//  3.  O(n) : Merge the two list

// Space Complexity : O(1) ..... not using any extra space, as we are using the same linkedlist and modifying the pointers.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/reorder-list/description/

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Exmaple 1
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2 

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

*/


/**
 * Explaianation : 
 * Center of the list os found by using two pointers slow and fast; where slow is moved by 1x and fast is moved by 2x.
 * The while loop terminating condition for finding mid is fast.next != null ( even numbered) fast.next.next!= null (odd numbered )
 * Once center is found ( where the slow is pointing ), second half of the list is reversed.
 * Then one node from first list and one node from another list as added to the chain.
 * 
 */



public class Reordering_List {
      public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // find mid
        while(fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast= fast.next.next;
        }

        // Reverse the 2nd half
        fast = reverse(slow.next); // we want to reverse from the node next to slow node.
        slow.next = null; // here it breaks two lists

        // merge the two list
        slow = head;    // reset the slow ptr to head first
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode fast = null;

        while(curr!= null){
            fast = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fast;
        }
        return prev;
    }
}
