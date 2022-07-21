/*package com.shuzijun.leetcode.editor.en;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = ListNode.convertArrayToLinkedList(new int[]{2000,4000,999999});
        ListNode l2 = ListNode.convertArrayToLinkedList(new int[]{2, 4, 6});

        Solution solution = new Solution();
        ListNode l3 = solution.mergeTwoLists(l1, l2);
    }*/

//leetcode submit region begin(Prohibit modification and deletion)

//Definition for singly-linked list.

class Solution {
    ListNode l1;
    ListNode l2;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode dummy = new ListNode(-1);
        //p的引用指向dummy，即p.head------>dummy[0|null]
        ListNode p = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {

            if (p1.val > p2.val) {
                /*
                 * object.next means the second node of the object.
                 * Here, the second node of p is linked to the first node of object p2
                 */
                p.next = p2;
                p2 = p2.next;

            } else {

                p.next = p1;
                p1 = p1.next;

            }
            /*
             *   It assigns next node of p to object p. For example, from p={1,3,5} to p={3,5}.
             *   But do not change object dummy. Why?
             *   p.head------> -1 1 3 5
             *   dummy.head-----> -1 1 3 5
             *   After p = p.next,即p.head的下一跳,越过-1，直接指向1 3 5
             *   p.head------>1 3 5. Skip -1
             *   But dummy.head的下一跳 仍旧指向的是 -1 1 3 5
             */

            p = p.next;


        }

        if (p1 != null) {

            p.next = p1;

        }

        if (p2 != null) {

            p.next = p2;

        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//}