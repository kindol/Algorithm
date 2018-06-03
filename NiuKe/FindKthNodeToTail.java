package NiuKe;

/*
输入一个链表，输出该链表中倒数第k个结点。

思路：
两个链表头指针，一个先走k步，两个再同时开始走，当第一个先到达尾端则后走的所在位置为倒数第k

异常情况：
k <= 0；
head为null
 */

public class FindKthNodeToTail
{
    public ListNode FindKthToTail(ListNode head,int k)
    {
        if (head == null || k <= 0)
            return null;
        ListNode first = head, second = head;
        int i = 1;
        for (; i < k && first.next != null; i++)        //此处需要.next判断，是因为避免到达当i已经到达末尾节点仍在继续运行的情况
            first = first.next;
        if (i < k)
            return null;

        for (; first.next != null; first = first.next, second = second.next);

        return second;
    }
}
