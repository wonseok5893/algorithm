package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Programmers208696 {
    public static void main(String[] args) {
        BFSsolution(4,3,new int[][]{{2,2}});
    }
    static int[][]graph;
    public static int BFSsolution(int m, int n, int[][] puddles) {
        graph = new int[n][m];
        for (int[] puddle : puddles) {
            graph[puddle[1]-1][puddle[0]-1] = -1;
        }
        ///맵끝
        int[]dx = {1,0};
        int[]dy = {0,1};
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        int count = 0;
        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            if(pop[0]==m-1&&pop[1]==n-1) count++;
            for (int i = 0; i < 2; i++) {
                int nextX = pop[0]+dx[i];
                int nextY = pop[1]+dy[i];
                if(nextX>=m||nextY>=n) continue;
                if(graph[nextY][nextX]!=0) continue;
                stack.push(new int[]{nextX,nextY});
            }
        }
        return count;
    } // 시간초과

    public int solution(int m, int n, int[][] puddles) {
        graph = new int[n][m];
        for (int[] puddle : puddles) {
            graph[puddle[1]-1][puddle[0]-1] = -1;
        }

    }
}
