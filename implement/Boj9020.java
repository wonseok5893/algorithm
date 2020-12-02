package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] problems = new int[k];
        for (int i = 0; i < k; i++) {
            problems[i] = Integer.parseInt(br.readLine());
        }
        int[] n = new int[10001];
        Arrays.fill(n, 1);
        n[0] = n[1] = 0;
        for (int i = 2; i < 10001; i++) {
            if (n[i] == 1) {
                int pos = 2;
                int x = i * pos;
                while (x <= 10000) {
                    n[x] = 0;
                    pos++;
                    x = i * pos;
                }
            }
        }

        for (int y : problems) {
            int mid = y / 2;
            if (n[mid] == 1) {
                System.out.println(mid + " " + mid);
                continue;
            }
            int[][] answer = new int[2][2];
            int left = mid - 1;
            while (left > 1) {
                if (n[y - left] == 1 && n[left] == 1) {
                    answer[0][0] = left;
                    answer[0][1] = y - left;
                    break;
                }
                left--;
            }
            int right = mid + 1;
            while (right < y) {
                if (n[right] == 1 && n[y - right] == 1) {
                    answer[1][1] = right;
                    answer[1][0] = y - right;
                    break;
                }
                right++;
            }
            if (answer[0][1] - answer[0][0] > answer[1][1] - answer[1][0]) {
                System.out.println(answer[0][0] + " " + answer[0][1]);
            } else System.out.println(answer[1][0] + " " + answer[1][1]);
        }
    }

}
