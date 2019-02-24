package problem19;

/**
 * @Author xp
 * @Date：2019-02-24
 */
public class Solution {
    /**
     * 题目描述：Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * <p>
     * 思路：先让一个标志位走n-1步，然后再与heap同时开始往后遍历，即可得到倒数第n个节点了
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        ListNode pHead = head, current = head;
        ListNode before = null;
        for (int i = 0; i < n - 1; i++) {
            pHead = pHead.next;
            if (pHead == null) {
                return null;
            }
        }
        while (pHead.next != null) {
            if (before == null) {
                before = head;
                current = current.next;
                pHead = pHead.next;
            } else {
                before = before.next;
                current = current.next;
                pHead = pHead.next;
            }
        }
        if (before == null) {
            head = current.next;
        } else {
            before.next = current.next;
        }
        return head;
    }
}
