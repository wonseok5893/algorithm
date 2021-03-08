package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1987 {
    static int[][] arr;
    static int[] cnt;
    static int max;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        cnt = new int[256];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        arr = new int[y][x];
        for (int i = 0; i < y; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < x; j++) {
                arr[i][j] = (int) (chars[j]);
            }
        }
        cnt[arr[0][0]]++;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static int dfs(int y, int x, int ans) {

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextY>=arr.length||nextX>=arr[0].length||nextY<0||nextX<0)continue;
            if(cnt[arr[nextY][nextX]]>=1)continue;
            cnt[arr[nextY][nextX]]++;
            dfs(nextY, nextX, ans + 1);
            cnt[arr[nextY][nextX]]--;
        }

        return max = Math.max(max, ans);
    }
}
