package dp;

import java.math.BigInteger;

public class GeeksDpCatalan {
    public static void main(String[] args) {

        BigInteger[]dp = new BigInteger[101];
        dp[0] = new BigInteger("1");
        for(int i=1;i<=100;i++){
            int temp = (2*i)*(2*i-1)/((i+1)*i);
            BigInteger multi = new BigInteger(String.valueOf(temp));
            dp[i] = dp[i-1].multiply(multi);
        }
        System.out.println(dp[100]);
    }
}
