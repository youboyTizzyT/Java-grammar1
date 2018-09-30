package leetcode;

/**
 * 1->2->3->4->6
 * 2->5->6->7->
 * Create by weicong on 2018/9/27
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode small=l1.val>l2.val?l2:l1;
        ListNode max=l1.val>l2.val?l1:l2;
        ListNode ret=small;
        while (small!=null&&max!=null){
            if (small.next!=null&&max!=null){
                if (small.next.val>max.val){
                    max=swap(small,max);
                }else {
                    small=small.next;
                }
            }
        }
        return ret;
    }
    public ListNode swap(ListNode small,ListNode max){
        ListNode tmp=max;
        ListNode tmp2=max.next;
        ListNode tmp1=small.next;
        small.next=tmp;
        tmp.next=tmp1;
        return tmp2;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(4);
//        ListNode l4=new ListNode(6);
//        ListNode l5=new ListNode(7);
        ListNode l6=new ListNode(1);
        ListNode l7=new ListNode(3);
        ListNode l8=new ListNode(4);
//        ListNode l9=new ListNode(5);
//        ListNode l0=new ListNode(6);
        l1.next=l2;
        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
        l6.next=l7;
        l7.next=l8;
//        l8.next=l9;
//        l9.next=l0;
        Solution21 solution21=new Solution21();
        ListNode ret=solution21.mergeTwoLists(l1,l6);
        while (ret!=null){
            System.out.println(ret.val);
            ret=ret.next;
        }
    }
}
