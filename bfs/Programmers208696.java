package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Programmers208696 {
    public static void main(String[] args) {
//        BFSsolution(4,3,new int[][]{{2,2}});
        solution(8,6,new int[][]{{6,2},{2,3},{5,3}});
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

    public static int solution(int m, int n, int[][] puddles) {
        graph = new int[n][m];
        for (int[] puddle : puddles) {
            graph[puddle[1]-1][puddle[0]-1] = -1;
        }
        ///맵끝
        boolean change =false;
        for (int i = 0; i < n; i++) {
            if(!change){
                if(graph[i][0]!=-1)
                    graph[i][0] =1;
                else {
                    change = true;graph[i][0] = 0;
                }
            }else graph[i][0] = 0;
        }
        change = false;
        for (int i = 0; i < m; i++) {
            if(!change){
                if(graph[0][i]!=-1)
                    graph[0][i] =1;
                else {
                    change = true;graph[0][i] = 0;
                }
            }else graph[0][i] = 0;
        }
        for(int i =1;i<n;i++){
            for(int j=1;j<m;j++){
                if(graph[i][j]==-1) {
                    graph[i][j] = 0;
                }else {
                    graph[i][j] = (graph[i - 1][j] + graph[i][j - 1])%1000000007;
                }
            }
        }
        // for (int[] ints : graph) {
        //     for (int e : ints) {
        //         System.out.print(e+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        return graph[n-1][m-1];
    }
}
