package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int len = 0;
        int minLen = 10000001;
        while (start <= end) {
            if (sum >= s) {
                minLen = Math.min(minLen, len);
                sum -= arr[start++];
                len--;
            } else if (end >= n) break;
            else {
                sum += arr[end++];
                len++;
            }
        }
        System.out.println(minLen==10000001?0:minLen);
    }

}
