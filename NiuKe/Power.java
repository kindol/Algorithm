package NiuKe;

/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

思路：
考虑运算的一些情况：
如果n>0，正常
如果n=0，返回1
如果n<0，且底数为0，抛出异常；其他正常
最后返回过程不要忘记判断是否为0

运算过程：
将指数变换为二进制，每次都进行移位判断是否为1，为1则乘上当前对应的底数，底数需要每移一次位都进行翻倍
举个例子：3^1110 = 3^0010 * 3^0100 * 3^1000
 */

public class Power
{
    public double Power(double base, int exponent) throws Exception
    {
        double res = 1;
        int curExp = exponent;

        if (exponent < 0)
        {
            if (base == 0)
                throw new RuntimeException("分母不能为0");
            curExp = -exponent;
        }
        else if (exponent == 0)
            return 1;

        while (curExp != 0)
        {
            if ((curExp & 1) == 1)
                res *= base;
            base *= base;
            curExp >>= 1;
        }

        return exponent > 0 ? res : 1/res;
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println(new Power().Power(2, -3));
    }

}
