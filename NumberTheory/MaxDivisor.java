package NumberTheory;

//求最大公约数，使用辗转相除法
public class MaxDivisor {

    public static int commontDivisor(int m, int n){
        if (m < 0 || n < 0)
            return -1;
        if (n == 0)         //余数为0
            return m;
        return commontDivisor(n, m%n);
    }

}
