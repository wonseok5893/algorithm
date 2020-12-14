<<<<<<< HEAD

package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1003 {
    static int count0, count1;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int testCases = Integer.parseInt(br.readLine());
        int testCase[] = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
        }
        for (int n : testCase) {
            dp = new int[n + 1];
            solution(n);
            for (int e : dp) {
                System.out.print(e+" ");
            }
            System.out.println();
            System.out.println(count0 + " " + count1);
            count0 = 0;
            count1 = 0;
        }
        br.close();
    }

    private static int solution(int n) {
        if (n == 1) {
            count1++;
            return 1;
        } else if (n == 0) {
            count0++;
            return 1;
        } else if (dp[n] != 0) return dp[n];
        else {
            dp[n] = solution(n - 1) +
                    solution(n - 2);
        }
        return 0;
    }
}
=======
>>>>>>> eba539b0709946a0eb9ca0c96d6713c1a65665f5
