package com.yl;

/**
 * @author yanglong
 * @date 2022/6/7
 */
public class AddTwoNumbers {
     public class ListNode {
     int val;
     ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
     
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return new ListNode();
            }
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode l3 = new ListNode();
            ListNode index = l3;
            // 进位
            int pob = 0;
            while (l1 != null || l2 != null) {
                int l1Val = 0, l2Val = 0;
                if (l1 != null) {
                    l1Val = l1.val;
                }

                if (l2 != null) {
                    l2Val = l2.val;
                }
                int sum = l1Val + l2Val + pob;
                if (sum >= 10) {
                    pob = 1;
                    ListNode node = new ListNode(sum % 10);
                    index.next = node;
                    index = index.next;
                } else {
                    pob = 0;
                    ListNode node = new ListNode(sum);
                    index.next = node;
                    index = index.next;
                }

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;

                if (pob == 1) {
                    ListNode node = new ListNode(pob);
                    index.next = node;
                }

            }
            return l3.next;
        }
    }
}
