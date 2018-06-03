package SaiMa.DP;

import java.util.Scanner;

/**
 * 小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：
 * 第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 *
 * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 *
 * 方法1：
 * 直接模拟
 *
 * 方法2：数学方法
 * 不完全算是DP，但其是从下往上计算的，需要依赖下面的结果
 * 从题目可以看出，第N天的价格肯定<N，因为每天涨也只是1块，而会有降的时候
 * 因此，思路如下：
 * 进行分组，第一组例外，其余每组以降为开头
 * i = 0，也就是第一天与第二天——不涨不降，涨，价格变为1、2
 * i = 1，即第三、四、五天——降、涨、涨，价格变为1、2、3
 * i = 2，降、涨、涨、涨，价格变为2、3、4、5
 * 可得公式，n-money = 2*i
 * 那么，只需要计算降的组数，N-2*组数 即可
 */

public class GodOfStock {

    public static int computeMoney(int n){
        int money = 1;
        int i = 0;
        while (true){
            if (((i+3)*(i) < 2*n) && (2*n <= (i+4)*(i+1)))
                break;
            i++;
        }
        return n-2*i;
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()){
            System.out.println(computeMoney(input.nextInt()));
        }
    }

}
