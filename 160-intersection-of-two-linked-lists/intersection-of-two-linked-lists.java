/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;//pointer a
        ListNode b= headB;//pointer b

        while(a!=b){
            if(a==null){ // if a traverse the whole path and reached the end that is null then but on the B's head to find intersection
                a=headB;
            }else{
                a=a.next;// if it has not reached the end then move it to the next node till it reaches the null 
            }
            if(b==null){
                b=headA;
            }else{
                b=b.next;
            }
            
        }
        return a;// since a==b at this point 
    }
}