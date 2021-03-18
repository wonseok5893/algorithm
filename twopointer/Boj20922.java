package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 1 2 3 4 5 6 6 7 8 9
        int start = 0;
        int end = 0;
        int cnt = 0;
        int ans = 0;
        int[] checked = new int[100001];
        while (start <= end&&end<arr.length) {
            while (end<arr.length&&checked[arr[end]] <= k) {
                if(checked[arr[end]]==k)break;
                checked[arr[end++]]++;
                cnt++;
                ans = Math.max(ans, cnt);
            }
            while (end<arr.length&&arr[start]!=arr[end]) {
                checked[arr[start++]]--;
                cnt--;
            }
            checked[arr[start++]]--;
            cnt--;
        }
        System.out.println(ans);

    }
}
