package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20167 {
    static int k;
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // n<=20
        go(0, 0, 0);
//
//        int[][][] dp = new int[n+1][2][2];
//
//        //dp[i][j] =  i번째를 먹느냐 안먹느냐
//        for (int i = 1; i < n; i++) {
//
//        }


        System.out.println(ans);

    }

    private static void go(int start, int sum, int value) {
        if (start >= arr.length) {
            ans = Math.max(ans, value);
            return;
        }
        // 먹고
        if (sum + arr[start] >= k)
            go(start + 1, 0, value + sum + arr[start] - k);
        else
            go(start + 1, sum + arr[start], value);
        // 안 먹고
        go(start + 1, 0 ,value);
    }


}
