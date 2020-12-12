package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String O = br.readLine();
        String N = br.readLine();

        //hello fine
        //hi hello, how are you? I'm fine thank you and you?
        int lenO = O.length();
        int lenN = N.length();

        int[][] dp = new int[lenO + 1][lenN + 1];
        for (int i = 0; i <= lenO; i++) {
            dp[i][0] = -1;
        }
        for (int i = 0; i <= lenN; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= lenO; i++) {
            String str = O.substring(0, i);
            String[] strArr = str.split("");
            int dpPos = -1;
            for (int j = 1; j <= lenN; j++) {
                String tempStr = N.substring(0, j);
                dpPos = tempStr.indexOf(str.charAt(i - 1));
                if(dpPos==-1) {
                    dp[i][j] = -1;
                    continue;
                }
                else{
                    if(dpPos==0)dp[i][1] = 0;
                    else{
                        dpPos= 1;
                    }
                    if (str.charAt(i - 1) == tempStr.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else {

                    }
                }


            }
        }


    }
}
