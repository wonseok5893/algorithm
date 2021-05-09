package kakao2021internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Num2 {
    public static void main(String[] args) {

    }
    static char[][]graph;
    public int[] solution(String[][] places) {
        //거리 3이상으로 앉아야함
        //파티션으로 막혀있을경우 허용
        int[] ans = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            ans[i] = checkRule(places[i]);
        }
        return ans;
    }

    private int checkRule(String[] place) {
        int n = place.length;
        int m = place[0].length();
        graph = new char[n][m];
        ArrayList<int[]> startLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] temp = place[i].toCharArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = temp[j];
                if(graph[i][j]=='P') startLists.add(new int[]{j, i});
            }
        }
        for (int[] start : startLists) {
            if(!bfs(start[0], start[1]))return 0;
        }
        return 1;

    }

    private boolean bfs(int x, int y) {
        int[][] visit = new int[graph.length][graph[0].length];
        for (int i = 0; i < visit.length; i++) {
            Arrays.fill(visit[i], -1);
        }
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visit[y][x] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX<0||nextY<0||nextX>=graph.length||nextY>=graph[0].length) continue;
                if(graph[nextY][nextX]=='X') continue;
                if(visit[nextY][nextX]!=-1) continue;
                visit[nextY][nextX] = visit[now[1]][now[0]] + 1;
                if(graph[nextY][nextX]=='P'&&visit[nextY][nextX]<=2)return false;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        return true;
    }
}
