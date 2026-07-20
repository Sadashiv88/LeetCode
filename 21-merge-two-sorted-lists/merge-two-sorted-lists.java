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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head1=list1;
        ListNode head2=list2;
        ListNode t=new ListNode(9);
        ListNode temp=t;
        while(head1!=null && head2!=null){
            if(head1.val>head2.val){
                ListNode curr=new ListNode(head2.val);
                temp.next=curr;
                temp=curr;
                head2=head2.next;
            }else{
                ListNode curr=new ListNode(head1.val);
                temp.next=curr;
                temp=curr;
                head1=head1.next;
            }
        }
        while(head1!=null){
            ListNode curr=new ListNode(head1.val);
            temp.next=curr;
            temp=curr;
            head1=head1.next;
        }
        while(head2!=null){
            ListNode curr=new ListNode(head2.val);
            temp.next=curr;
            temp=curr;
            head2=head2.next;
        }
        return t.next;
    }
}