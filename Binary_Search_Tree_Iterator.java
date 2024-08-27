
/*
 * 
 * 
 * 
 * /*
Leetcode : https://leetcode.com/problems/binary-search-tree-iterator/description/

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False



 * Iterator has two functions and we need to implement below
 * next() & hasNext()
 * next() function will be giving out whatever is the next value that we have.
 * hasNext() function will be giving out true or false , depending upon if we have the next value or not
 * 
 * 
/**
 * // {Approach 1}
// Time Complexity : O(1) ... for both next() and hasnext() function 
// Space Complexity : O(n) ..... extra space is used for array
//
 * Approach 1 : Storing all nodes in an array
 * 
 * Array is created during the constructor.
 * Only drawback is that if new node is added in between to the list, it will not
 * be provided by this iterator.
 *Start with a ptr on the array, if next is called then ptr will give out that value, if hasNext is called we see it has elements 
 in the list.
 * 
*/

import java.util.ArrayList;
import java.util.List;

public class Binary_Search_Tree_Iterator {
    List<Integer> li;
    int idx;
    public BSTIterator (TreeNode root){
        this.li = new ArrayList<>();
        helper(root);
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        li.add(root);
        helper(root.right);
    }

    public int next(){
        int re = li.get(idx);
        idx++;
        return re;
    }

    public boolean hasNext()
    {
        return idx!=li.size();
    }
}



/**
 * Approach 2 : USing stack to store pointers
 * 
 * In this approach entire list is not tranverse during the construstor.
 * 
 * Helper function is used to add poniters to the stack. When some node is passed to helper;
 * helper function will add all the left nodes to the stack
 * 
 * whenever some node is poped out in next() function, helper is again called on right side of the node
 * to add more nodes to the stack.
 * 
 * This method will take care of dynamic addition of the nodes to the tree.
 * 
 * TC : hasNext () - O(1), as we are just checking if stack is empty or not
 *      next() - O(h)..worst case where h is the height of the tree
 *              - average case is O(1) 
 * SC : space by the stack : O(n)  
*/

public class Binary_Search_Tree_Iterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        helper(root);
    }

    private void helper(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode re = st.pop();
        helper(root.right);
        return re.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}