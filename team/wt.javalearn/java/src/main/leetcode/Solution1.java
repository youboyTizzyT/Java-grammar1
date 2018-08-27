package leetcode;

/**
 * 两数相加
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution1 {
    public static void main(String[] args) {
        ListNode q=new ListNode(2);
        ListNode w=new ListNode(2);
        ListNode e=new ListNode(2);
        ListNode a=new ListNode(2);
        ListNode s=new ListNode(2);
        ListNode d=new ListNode(2);
        w.next=e;
        q.next=w;

        s.next=d;
        a.next=s;

        ListNode ret=addTwoNumbers(q,a);
        System.out.println(ret.val);
        System.out.println(ret.next.val);
        System.out.println(ret.next.val);

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret;
        if (l1.val+l2.val>10){
            ret=new ListNode(l1.val+l2.val-10);
            ret.next=new ListNode(1);
        }else {
            ret=new ListNode(l1.val+l2.val);
        }
        ListNode l=ret.next;
        ListNode l3=l1.next;
        ListNode l4=l2.next;
        while (l3!=null||l4!=null) {
            if (l3 == null) {
                l.val += l4.val;
            } else if (l4== null) {
                l.val += l3.val;
            }else {
                if (l==null){
                    l=new ListNode(0);
                }
                if (l4.val + l3.val + l.val > 10) {
                    l.val += l4.val + l3.val - 10;
                    l.next = new ListNode(1);
                } else {
                    l.val += l4.val + l3.val;
                }
            }
            if (l.next==null){
                l.next=new ListNode(0);
                l=l.next;
            }else {
                l=l.next;
            }
            l3=l1.next;
            l4=l2.next;
        }
        return ret;
    }
}
