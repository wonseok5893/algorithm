package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11054 {
    public static void main(String[] args) throws IOException {
        //최댓값을 기준으로 왼쪽 LIS 오른쪽 LDS 합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }
        //배열 초기화 끝


        System.out.println(findBitonicLen(arr)-1);

    }

    private static int findBitonicLen(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        //최댓값 왼쪽 LIS
        int[] reverseDp = new int[arr.length];
        reverseDp[arr.length - 1] = 1;
        int reverseMax = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            reverseDp[i] = 1;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i] && reverseDp[i] < reverseDp[j] + 1) reverseDp[i] = reverseDp[j] + 1;
            }
            reverseMax = Math.max(reverseMax, reverseDp[i]);
        }
        //최댓값 오른쪽 LDS
        int resultMax = 0;
        for (int i = 0; i < arr.length; i++) {
            resultMax = Math.max(dp[i] + reverseDp[i], resultMax);
        }
        return resultMax;
    }
}
