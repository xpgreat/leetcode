package base;

/**
 * @Author xp
 * @Date：2019-02-24
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    //遍历链表
    public static void TraverseList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print(" , ");
            listNode = listNode.next;
        }
    }

    //创建链表，使用数组
    public static ListNode buildNodeListFromArray(int[] a) {
        ListNode head = null, node = null;
        ListNode next = null;
        for (int i : a) {
            if (head == null) {
                head = node = new ListNode(i);
            } else {
                next = new ListNode(i);
                node.next = next;
                node = next;
            }
        }
        return head;
    }

}
