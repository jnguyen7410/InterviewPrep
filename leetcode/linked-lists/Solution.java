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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentNode = null;
        boolean carry = false;
        int combined;
        if (l1.val == 0 && l1.next == null && l2.val == 0 && l2.next == null) {
            return new ListNode(0);
        } else if (l1.val == 0 && l1.next == null) {
            return l2;
        } else if (l2.val == 0 && l2.next == null) {
            return l1;
        }
        while (l1 != null || l2 != null) {
            combined = l1 == null  && l2 != null 
                ? l2.val 
                : l2 == null && l1 != null 
                    ? l1.val : l1 == null && l2 == null
                        ? 0 : l1.val + l2.val;
            if (carry) { combined++; }
            carry = false;
            if (combined >= 10) {
                carry = true;
                combined %= 10;
            } 
            
            if (result == null) {
                currentNode = new ListNode(combined);
                result = currentNode;
            } else {
                currentNode.next = new ListNode(combined);
                currentNode = currentNode.next; 
            }
            if (l1 != null) {
                l1 = l1.next;
            } if (l2 != null) {
                l2 = l2.next;    
            }
        }
        
        if (carry) {
            currentNode.next = new ListNode(1);
        }
        
        
        // return the result
        return result;
    }
}