package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj20181 {
    static int k;
    static int[] arr;
    static long ans;
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

        // N<=100,000
        // K<= 1e8
        // 먹고 안먹고 2 ^ N 실패
        // 6
        // 1 5 4 4 2 3 10 3 5
        // left right
        //O(N)에 끝내야함 -> two pointer
        int start=0,end = 0;
        long sum = 0,lmax=0;
        long dp[] = new long[10];
        while(start<=end){
            if(sum>=k){
                lmax = (start == 0 ? 0 : Math.max(lmax, dp[start - 1]));
                dp[end - 1] = Math.max(dp[end - 1], lmax + sum - k);
                sum -= arr[start++];
            }else if(end==n)break;
            else sum += arr[end++];
            System.out.println(Arrays.toString(dp));
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
