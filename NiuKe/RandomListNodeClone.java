package NiuKe;

/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。

思路：
复制每个节点，如：复制节点A得到A1，将A1插入节点A后面，此时不处理random
遍历原链表（跳过新赋值的链表节点），使得A1.random = A.random.next;
链表拆分并返回：相比于链表的反转容易一些，只需要多定义两个变量代表两个链表当前位置即可
 */

class RandomListNode
{
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label)
    {
        this.label = label;
    }
}

public class RandomListNodeClone
{
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        RandomListNode headTmp = pHead;

        //先复制当前节点并且放到当前节点的后面
        while (headTmp != null)
        {
            RandomListNode newNode = new RandomListNode(headTmp.label);
            newNode.next = headTmp.next;
            headTmp.next = newNode;
            headTmp = newNode.next;
        }

        //处理random节点
        headTmp = pHead;
        while (headTmp != null)
        {
            if (headTmp.random != null)
            {
                headTmp.next.random = headTmp.random.next;
            }
            headTmp = headTmp.next.next;            //这里需要两个next
        }

        RandomListNode head = pHead.next;
        headTmp = pHead;
        RandomListNode curForHead = head;
        while (headTmp != null)                     //不能是headTmp.next.next != null，因为到达了最后两个节点，依旧需要拆分
        {
            headTmp.next =curForHead.next;
            if (curForHead.next != null)
                curForHead.next = curForHead.next.next;
            headTmp = headTmp.next;
            curForHead = curForHead.next;
        }

        return head;
    }

    public static void main(String[] args)
    {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);

        head.random = head.next.next;
        head.next.random = head.next.next.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println(new RandomListNodeClone().Clone(head));
    }

}
