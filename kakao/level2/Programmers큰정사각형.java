package com.wonseok.kakao.level2;

public class Programmers큰정사각형 {
    public static void main(String[] args) {
        new Programmers큰정사각형().solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}});
    }

        public int solution(int [][]board)
        {

            int n = board.length;
            int m = board[0].length;
            int max = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if(board[i][j]==1){
                        int min = Integer.MAX_VALUE;
                        min = Math.min(min,board[i-1][j]);
                        min = Math.min(min,board[i][j-1]);
                        min = Math.min(min,board[i-1][j-1]);
                        board[i][j] = min+1;
                        max = Math.max(board[i][j],max);
                    }
                }
            }
            if(max==0) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i != 0 || j != 0) continue;
                        if (board[i][j] == 1) max = 1;
                    }
                }
            }
            return max*max;
        }

}
