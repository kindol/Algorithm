package NiuKe;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 思路：
 * 找到第一个公共节点后，两个链表会合并为同个尾巴
 * 假设链表长度不同，那么长的前面的节点肯定不可能重复，所以减掉差值后再同时开始比较
 */

public class FindFirstCommonNode {

    public int getListLength(ListNode head){
        if (head == null)
            return 0;
        int res = 1;
        for (; (head = head.next) != null; res++);
        return res;
    }

    public ListNode walkStep(ListNode head, int step){
        ListNode tmp = head;
        for (; step != 0; tmp = tmp.next, step--);
        return tmp;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getListLength(pHead1);
        int len2 = getListLength(pHead2);

        if (len1 > len2)
            pHead1 = walkStep(pHead1, len1-len2);
        else
            pHead2 = walkStep(pHead2, len2-len1);

        while (pHead1 != null){
            if (pHead1 == pHead2)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        p1.next = new ListNode(2);
        p1.next.next = new ListNode(3);
        p1.next.next.next = new ListNode(6);
        p1.next.next.next.next = new ListNode(7);

        ListNode p2 = new ListNode(4);
        p2.next = new ListNode(5);
        p2.next.next = p1.next.next.next;

        ListNode tmp = new FindFirstCommonNode().FindFirstCommonNode(p1, p2);
        if (tmp != null)
            System.out.println(tmp.val);
    }

}
