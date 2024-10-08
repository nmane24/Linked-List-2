// Time Complexity : O(1)   
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Geek for geeks link : https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1
https://leetcode.com/problems/delete-node-in-a-linked-list/description/?envType=company&envId=paypal&favoriteSlug=paypal-more-than-six-months


You are given a node del_node of a Singly Linked List where you have to delete a 
value of the given node from the linked list but you are not given the head of the list.

By deleting the node value, we do not mean removing it from memory. We mean:
The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before & after the del_node node should be in the same order.
*/

/*
Just copy next node data to current node to be deleted and move next pointers as well.
Over-writting the data is same as deleting the node
*/

class Solution
{
    //Function to delete a node without any reference to head pointer.
    public void deleteNode(ListNode node)
    {
       // Your code here
        node.val = node.next.next.val;
        node.next = node.next.next;
    }

};