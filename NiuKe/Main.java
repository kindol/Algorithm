package NiuKe;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main
{

    public boolean IsPopOrder(int [] pushA,int [] popA)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        int j = 1;

        for (int i = 0; i < popA.length;)
        {
            int tmp = stack.pop();

            if (tmp != popA[i])
            {
                stack.push(tmp);

                if (j == pushA.length && !stack.isEmpty())
                    return false;

                for (; j < pushA.length; j++)
                    if (pushA[j] != popA[i])
                        stack.push(pushA[j]);
                    else
                    {
                        i++;
                        j++;
                        break;
                    }
            }
            else
                i++;
        }
        return true;
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null)
            return result;
        result.add(root.val);
        if (root.left != null)
            linkedList.add(root.left);
        if (root.right != null)
            linkedList.add(root.right);

        while (!linkedList.isEmpty())
        {
            TreeNode tmp = linkedList.pop();
            if (tmp.left != null)
                linkedList.add(tmp.left);
            if (tmp.right != null)
                linkedList.add(tmp.right);
            result.add(tmp.val);
        }
        return result;
    }

    public static void main(String[] args)
    {
        //System.out.println(new Main().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));

        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(new Main().PrintFromTopToBottom(null));*/
    }
}
