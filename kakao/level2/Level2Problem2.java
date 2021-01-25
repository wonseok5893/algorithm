package com.wonseok.kakao.level2;

import com.wonseok.ProgrammersTest.Level3Test1Num1;

public class Level2Problem2 {
    public static void main(String[] args) {
        new Level2Problem2().solution(10);
    }
    static int num =1;
    public int[] solution(int n) {
        int[][] arr= new int[n][n];
        if(n==1)return new int[]{1};
        if(n==2) return new int[]{1,2,3};
        if(n>=3){
            printTriangle(n,0,0,arr);
        }
        int[]ans = new int[n*(n+1)/2];
        int pos = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <= i; j++) {
                ans[pos++] = arr[i][j];
            }
        }
        return ans;
    }

    private void printTriangle(int n,int y, int x,int[][]arr) {
        int[] now = new int[]{x,y};
        if(n==0)return;
        if(n==1){
            arr[y][x] = num;
            return;
        }
        if(n==2) {
            arr[y][x] = num++;
            arr[y+1][x] = num++;
            arr[y+1][x+1] = num++;
        }
        if(n>=3) {
            // n = n-3
            int leftDrawCount = n;
            int rightDrawCount = n - 1;
            int upDrawCount = n - 2;

            int[] dx = {0, 1, -1};
            int[] dy = {1, 0, -1};
            while (leftDrawCount-- > 0) {
                arr[now[1]][now[0]] = num++;
                now[0] = now[0] + dx[0];
                now[1] = now[1] + dy[0];
            }
            now[0] = now[0] - dx[0] + dx[1];
            now[1] = now[1] - dy[0] + dy[1];

            while (rightDrawCount-- > 0) {
                arr[now[1]][now[0]] = num++;
                now[0] = now[0] + dx[1];
                now[1] = now[1] + dy[1];
            }
            now[0] = now[0] - dx[1] + dx[2];
            now[1] = now[1] - dy[1] + dy[2];

            while (upDrawCount-- > 0) {
                arr[now[1]][now[0]] = num++;
                now[0] = now[0] + dx[2];
                now[1] = now[1] + dy[2];
            }
            now[0] = now[0] - dx[2];
            now[1] = now[1] - dy[2] + 1;


            printTriangle(n-3,now[1], now[0], arr);
        }
    }
}
