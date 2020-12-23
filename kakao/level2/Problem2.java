package com.wonseok.kakao.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public static void main(String[] args) {
        solution(0, 0, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1},{0, 0, 0, 1}});
    }
        public static int[] solution(int m, int n, int[][] picture) {
            int y = picture.length;
            int x= picture[0].length;
            int[][] visited = new int[y][x];
            int count = 0;
            int max =-1;
            for(int i=0;i<y;i++){
                for(int j= 0;j<x;j++){
                    if(visited[i][j]!=1){
                        int px = picture[i][j];
                        if(px==0)continue;
                        max = Math.max(max,bfs(visited, i,j,picture,px));
                        count++;
                    }
                }
            }
            return new int[]{count,max};
        }
        public static int bfs(int visited[][],int y, int x,int[][]picture,int px){
            int[]dx =new int[]{-1,1,0,0};
            int[]dy =new int[]{0,0,-1,1};

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x,y});
            visited[y][x] = 1;
            int count =1;
            while(!queue.isEmpty()){
                int[] now = queue.poll();
                for(int i=0;i<4;i++){
                    int nextY = now[1]+dy[i];
                    int nextX = now[0]+dx[i];
                    if(nextX<0||nextY<0||nextX>=visited[0].length||nextY>=visited.length)
                        continue;
                    if(visited[nextY][nextX]!=0||picture[nextY][nextX]!=px)continue;
                    queue.offer(new int[]{nextX,nextY});
                    visited[nextY][nextX] = 1;
                    count++;
                }
            }
            return count;
        }
        // 1 1 1 0
        // 1 1 1 0
        // 0 0 0 1
        // 0 0 0 1
        // 0 0 0 1
        // 0 0 0 1

}
