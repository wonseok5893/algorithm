package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
    static ArrayList<int[]> possibleList;
    static int[][] map;
    static int[][] temp;
    static ArrayList<int[]> virus;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        virus = new ArrayList<>();
        possibleList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new int[]{i, j});
                if (map[i][j] == 0) possibleList.add(new int[]{i, j});
            }
        }
        temp = cloneArr(map);
        // 벽 3개를 어떻게 세울까?
        // 완전 탐색 하자
        backtracking(new ArrayList<int[]>(), -1, 0);
        System.out.println(result);

    }

    private static void backtracking(ArrayList<int[]> ans, int start, int count) {
        if (count == 3) {
            for (int[] an : ans) {
                for (int i = 0; i < 2; i++) {
                    temp[an[0]][an[1]] = 1;
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            for (int[] arr : virus) {
                queue.offer(arr);
            }
            //셋팅 완료
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextY = now[0] + dy[i];
                    int nextX = now[1] + dx[i];
                    if (nextX < 0 || nextY < 0 || nextX >= temp[0].length || nextY >= temp.length) continue;
                    if (temp[nextY][nextX] != 0) continue;
                    temp[nextY][nextX] = 2;
                    queue.offer(new int[]{nextY, nextX});
                }
            }
            int res = 0;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    if (temp[i][j] == 0) res++;
                }
            }
            result = Math.max(result, res);
            temp = cloneArr(map);
            return;
        }

        for (int i = start + 1; i < possibleList.size(); i++) {
            ans.add(possibleList.get(i));
            backtracking(ans, i, count + 1);
            ans.remove(possibleList.get(i));
        }
    }

    private static int[][] cloneArr(int[][] map) {
        int[][] temp = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
}
