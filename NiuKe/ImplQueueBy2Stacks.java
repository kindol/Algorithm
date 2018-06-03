package NiuKe;

import java.util.Stack;

/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

思路：
栈1进行push操作
栈2用于pop操作，当栈2为空且进行push操作时将栈1压入栈2
 */

public class ImplQueueBy2Stacks
{

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty())                //当栈2为空，则将栈1的内容全部压入直到栈1为空
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }

    public static void main(String[] args)
    {

    }

}
