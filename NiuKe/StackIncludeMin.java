package NiuKe;

/*
思路：使用数据栈存储当前数据，辅助栈存储当前最小元素（在进行add或者pop后当前的最小元素），使用tmp作为当前最小
 */

import java.util.Stack;

public class StackIncludeMin
{

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> support = new Stack<>();
    private Integer tmp = null;

    public void push(int node)
    {
        if (tmp == null)
        {
            tmp = node;
            data.push(node);
            support.push(node);
        }
        else
        {
            if (node < tmp)
            {
                data.push(node);
                support.push(node);
                tmp = node;
            }
            else
            {
                data.push(node);
                support.push(tmp);
            }
        }
    }

    public void pop()
    {
        if (!data.isEmpty() && !support.isEmpty())
        {
            int m =  data.pop();
            support.pop();
            tmp = m;
        }
    }

    public int top()
    {
        int m = data.pop();
        data.push(m);
        return m;
    }

    public int min()
    {
        tmp = support.pop();
        support.push(tmp);
        return tmp;
    }
}
