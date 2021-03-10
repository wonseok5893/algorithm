package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 금광 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            solution(map);
        }
    }

    private static int solution(int[][] map) {
        int n = map.length;
        int m = map[0].length;

        int[][] dp = new int[n + 2][m + 2];

        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                dp[i][j] = map[i - 1][j - 1] + Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i + 1][j - 1]));
            }
        }
        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i][m]);
        }

        System.out.println(max);
        return max;
    }
}
