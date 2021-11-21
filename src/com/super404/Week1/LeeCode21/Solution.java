package com.super404.Week1.LeeCode21;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        //保护节点，方便返回
        ListNode protect = l3;

        while(l1 != null  || l2 != null){
            //l2为空，或者l1不为空且l1.val不大于l2.val，则取了
            if(l2 == null || (l1!=null && l1.val <= l2.val)){
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }
        return protect.next;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}