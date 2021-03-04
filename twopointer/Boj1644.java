package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i] == 1) continue;
            int pos = 2;
            while (i * pos <= n) {
                arr[i * pos++] = 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0)
                list.add(i);
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = 0;
        while (start <= end) {
            if (sum >= n) {
                if (sum == n) ans++;
                sum -= list.get(start++);
            } else if (end >= list.size()) break;
            else {
                sum += list.get(end++);
            }
        }
        System.out.println(ans);
    }
}
