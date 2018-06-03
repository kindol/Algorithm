package NumberTheory;

//最小公倍数
public class GCD {

    public static int gcd(int m, int n){
        while (true){
            if ((m = m%n) == 0)
                return n;
            if ((n = n%m) == 0)
                return m;
        }
    }

}
