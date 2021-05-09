package kakao2021internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Num4 {
    public static void main(String[] args) {
        new Num4().solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}
                , new int[]{2, 3});
    }

    static int v;
    static int target;
    static boolean[] trap;
    static Road road;
    static int[][] visit;
    static int[] visited;
    static int min = Integer.MAX_VALUE;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        v = n;
        target = end;
        trap = new boolean[v + 1];
        visit = new int[v + 1][v + 1];
        visited = new int[v + 1];

        for (int e : traps) {
            trap[e] = true;
        }
        int dir = 1; //true 정방향
        road = new Road(roads);
        visited[start] = 1;

        dfs(start,dir, 0);
        System.out.println(min);
        return min;
    }

    private void dfs(int start,int dir, int sum) {
        if(start==target){
            min = Math.min(min, sum);
            return;
        }
        for (int next : road.getAdj(dir)[start]) {
            if(trap[next]){
                if(visit[start][next]!=0)continue;
                visited[next]++;
                dir += visited[next]%2;
                visit[start][next] = 1;
                dfs(next, dir, sum + road.distance[start][next]);
                dir -= visited[next]%2;
                visited[next]--;
                visit[start][next] = 0;
            }else{
                if(visited[next]!=0)continue;
                visited[next] = 1;
                dfs(next, dir, sum + road.distance[start][next]);
                visited[next] = 0;
            }
        }
    }

    public static class Road {
        ArrayList<Integer>[] adj = new ArrayList[v + 1];
        ArrayList<Integer>[] reverseAdj = new ArrayList[v + 1];
        int[][] distance = new int[v + 1][v + 1];

        public Road(int[][] roads) {
            for (int i = 1; i <= v; i++) {
                adj[i] = new ArrayList<>();
                reverseAdj[i] = new ArrayList<>();
            }
            for (int[] road : roads) {
                adj[road[0]].add(road[1]);
                reverseAdj[road[1]].add(road[0]);
                distance[road[0]][road[1]] = road[2];
                distance[road[1]][road[0]] = road[2];
            }
        }

        public ArrayList<Integer>[] getAdj(int dir) {
            if (dir%2 == 1) return adj;
            return reverseAdj;
        }
    }
}
