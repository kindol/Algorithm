package DivideAndConquer;

/*
汉诺塔问题
 */

public class Hanoi
{

    public enum myPillar
    {
        A,B,C
    }

    //从tmpA移动到tmpB
    public static void move(myPillar tmpA, myPillar tmpB)
    {
        System.out.println(tmpA + "->" + tmpB);
    }

    //将n个物体从a移动到b
    public static void down(int n, myPillar a, myPillar b, myPillar c)
    {
        if (n > 0)
        {
            down(n-1, a, c, b);
            move(a, b);
            down(n-1, c, b, a);
        }
    }

    public static void main(String[] args)
    {
        down(4, myPillar.A, myPillar.B,myPillar.C);
    }

}
