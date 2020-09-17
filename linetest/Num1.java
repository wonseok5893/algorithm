package com.wonseok.linetest;

import com.sun.scenario.effect.Brightpass;

import java.util.Arrays;

public class Num1 {
    static int[][] graph;
    static int count = 0;
    static int direction = 1;
    static int changeCount = 0;
    
    public static void main(String[] args) {
        int[][] maze = new int[][]{{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
        solution(maze);
    }

    public static int solution(int[][] maze) {
        graph = new int[maze.length + 2][maze.length + 2];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == 0 || j == 0 || i == graph.length - 1 || j == graph.length - 1)
                    graph[i][j] = 1;
                if (i <= maze.length - 1 && j <= maze.length - 1)
                    graph[i + 1][j + 1] = maze[i][j];
            }
        }
        if (dfs(1, 1) == 0) return count;
        else return -1;

    }

    private static int dfs(int y, int x) {
        System.out.println("x:" + x + "y:" + y);
        //그래프 설정끝
        if (x == graph.length - 3 && y == graph.length - 3)
            return 0;
        count++;
        //아래로 내려갈떄
        if (direction == 1) {
            if (graph[y + 1][x] == 0) {
                if (graph[y][x + 1] == 1) {
                    dfs(y + 1, x);
                } else {
                    dfs(y, x + 1);
                }
            } else {
                direction = -1;
                dfs(y, x);
            }
        } else {
            //위로 올라갈떄
        }
        //오른쪽으로 갈때
        if (direction == -1) {
            if (graph[y][x + 1] == 0) {
                if (graph[y - 1][x] == 1)
                    dfs(y, x + 1);
                else {
                    direction = 2;
                    dfs(y - 1, x);
                }
            } else {
                direction = 2;
                dfs(y,x);
            }
        }
        //위로
        if (direction == 2) {
            if(graph[y][x-1]==0){
                if(graph[y][x-1]==1){
                    dfs(y-1,x);
                }else{
                    direction = 0;

                    dfs(y,x-1);
                }
            }else{
                direction = -1;
                dfs(y,x);
            }
        }
        //왼쪽으로 갈때

        return -1;
    }
//위가 막혀있는 상태
//[0][0] 상태에서 [0][1] 이 벽이면 [1][0]

// 오른쪽에 벽이있으면 아래로
//[0][0] 상태에서 [0][1] 이벽이고 [1,0]도 벽이면 [0][-1]
//[0][0] 상태에서 [0][1] 이벽이아니면 [0][1]로 이동
}
