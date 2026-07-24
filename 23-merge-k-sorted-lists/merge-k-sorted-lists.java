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
    public ListNode mergeKLists(ListNode[] lists) {
        //if(list.size()==0) return null;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(ListNode it:lists){
            while(it!=null){
                q.add(it.val);
                it=it.next;
            }
        }
        ListNode temp=new ListNode(9);
        ListNode head=temp;
        while(!q.isEmpty()){
            ListNode it=new ListNode(q.remove());
            temp.next=it;
            temp=it;
        }
        return head.next;
    }
}