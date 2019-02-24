package problem21;

/**
 * @Author xp
 * @Date：2019-02-24
 */
public class Solution {
    /**
     * 题目描述：
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <p>
     * 思路：
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newNode = null, head = null;
        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                if (head == null) {
                    head = newNode = l2;
                } else {
                    newNode.next = l2;
                    newNode = newNode.next;
                }
                l2 = l2.next;
            } else {
                if (head == null) {
                    head = newNode = l1;
                } else {
                    newNode.next = l1;
                    newNode = newNode.next;
                }
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            newNode.next = l1;
        } else {
            newNode.next = l2;
        }

        return head;
    }
}
