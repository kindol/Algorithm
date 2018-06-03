package NiuKe;

/*
输入一个链表，反转链表后，输出链表的所有元素。
 */

class ListNode
{
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}

public class ReverseList
{
    public ListNode ReverseList(ListNode head)
    {
        ListNode pre = null;
        ListNode next = null;

        while (head != null)
        {
            next = head.next;
            head.next = pre;                //仅处理了当前节点的next，所以循环条件为head != null
            pre  = head;
            head = next;
        }

        return pre;
    }
}
