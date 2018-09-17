package leetcode;

import java.util.*;

/**
 * k个一组翻转链表
 * Create by weicong on 2018/9/14
 */
public class Solution25 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
//        ListNode listNode3=new ListNode(3);
//        ListNode listNode4=new ListNode(4);
//        ListNode listNode5=new ListNode(5);
//        ListNode listNode6=new ListNode(6);
//        ListNode listNode7=new ListNode(7);
        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
//        listNode5.next=listNode6;
//        listNode6.next=listNode7;
        Solution25 solution25=new Solution25();
        listNode1=solution25.reverseKGroup(listNode1,3);
        for (;listNode1!=null;){
            System.out.print(listNode1.val);
            listNode1=listNode1.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        if (k==1){
            return head;
        }
        HashMap<Integer,List<ListNode>> hashMap=new HashMap<>();
        int group=1;
        while (head!=null){
            hashMap.computeIfAbsent(group, k1 -> new ArrayList<>());
            hashMap.get(group).add(head);
            if (hashMap.get(group).size()==k){
                group++;
            }
            head = head.next;
        }
        for (int i=1;i<=hashMap.size();i++) {
            List<ListNode> l=hashMap.get(i);
            if (l.size()==k) {
                for (int ii = 0; ii < l.size(); ii++) {
                    if (ii == 0) {
                        if (hashMap.get(i + 1) != null) {
                            if (hashMap.get(i + 1).size() != k) {
                                l.get(ii).next = hashMap.get(i + 1).get(0);
                            } else {
                                l.get(ii).next = hashMap.get(i + 1).get(hashMap.get(i + 1).size() - 1);
                            }
                        } else {
                            l.get(ii).next = null;
                        }
                    } else {
                        l.get(ii).next = l.get(ii - 1);
                    }
                }
            }
        }
        if (hashMap.get(1).size()!=k){
            return hashMap.get(1).get(0);
        }
        return hashMap.get(1).get(hashMap.get(1).size()-1);
    }
}
