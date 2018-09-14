package leetcode;


import java.util.HashMap;

/**
 * 删除链表倒数第几个
 * Create by weicong on 2018/9/14
 */
public class Solution19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null){
            return null;
        }
        if (head.next.next==null){
            if (n==1){
                head.next=null;
                return head;
            }else {
                return head.next;
            }
        }
        ListNode ret=head;
        HashMap<Integer,ListNode> hashMap=new HashMap<>();
        int i=1;
        while (head!=null){
            hashMap.put(i,head);
            i++;
            head=head.next;
        }
        int leagh=hashMap.size();
        int r=leagh-n;
        if (r==0){
            return hashMap.get(2);
        }
        int l=leagh-n+2;
        hashMap.get(r).next=hashMap.get(l);
        return  ret;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(3);
//        ListNode listNode3=new ListNode(4);
//        ListNode listNode4=new ListNode(5);
        listNode.next=listNode1;
        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
        removeNthFromEnd(listNode,3);
    }
}
