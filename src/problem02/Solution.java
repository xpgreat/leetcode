package problem02;

import base.ListNode;

import static base.ListNode.TraverseList;
import static base.ListNode.buildNodeListFromArray;

/**
 * @Author xp
 * @Date: 2019-01-02
 */
public class Solution {

    /**
     * 题目描述： Add Two Numbers
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * <p>
     * 思路：
     * 1.遍历之后赋值给两个数字，然后相加，转换成链表，存在溢出问题
     * 2.相当于将链表合并，考虑进位的问题
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int flag = 0, k = 0, x = 0, y = 0;
        ListNode sum = null, head = null;
        while (l1 != null || l2 != null) {
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;
            k = x + y + flag;
            if (k >= 10) {
                flag = k / 10;
                k %= 10;
            } else {
                flag = 0;
            }
            if (head == null) {
                head = sum = new ListNode(k);
            } else {
                sum.next = new ListNode(k);
                sum = sum.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //要考虑进位的问题
        if (flag > 0) {
            sum.next = new ListNode(flag);
        }
        return head;

    }

    public static ListNode addTwoNumbersWrong(ListNode l1, ListNode l2) {
        int a = 0, b = 0;
        int i = 1;
        while (l1 != null) {
            a += l1.val * i;
            i *= 10;
            l1 = l1.next;
        }
        i = 1;
        while (l2 != null) {
            b += l2.val * i;
            i *= 10;
            l2 = l2.next;
        }
        int sum = a + b;
        if (sum == 0) {
            return new ListNode(0);
        }
        ListNode head = null, node = null;
        ListNode next = null;
        while (sum > 0) {
            if (head == null) {
                head = node = new ListNode(sum % 10);
            } else {
                next = new ListNode(sum % 10);
                node.next = next;
                node = next;
            }
            sum /= 10;
        }
        return head;
    }

    public static void main(String[] args) {

        int[] a = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] b = {9,9};
        ListNode l1 = buildNodeListFromArray(a);
        ListNode l2 = buildNodeListFromArray(b);

        TraverseList(addTwoNumbers(l1, l2));
    }
}
