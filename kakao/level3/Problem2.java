package com.wonseok.kakao.level3;

public class Problem2 {
    public static void main(String[] args) {

    }
    static int ans = (int)1e7;
    public int solution(int[][] board) {
        int[][]visited = new int[board.length][board[0].length];
        dfs(0,0,1,0,0,board,visited);
        return ans;
    }

    private void dfs(int leftX, int leftY, int rightX, int rightY, int count, int[][] board, int[][] visited) {
        int N = board.length;
        int dir =-1;
        //세로
        if(leftX==rightX)dir =0;
        //가로
        if(leftY==rightY)dir =1;

        if(leftX>=N||leftY>=N||rightX>=N||rightY>=N)return;
        int[][]temp = new int[visited.length][visited[0].length];
        if(visited[leftY][leftX]!=0&&visited[rightY][rightX]!=0)return;

        if(leftX==N-1&&leftY==N-1){
            ans = Math.min(ans,count);
            return;
        }
        if(rightX==N-1&&rightY==N-1){
            ans = Math.min(ans,count);
            return;
        }
        visited[leftY][leftX]=1;
        visited[rightY][rightX]=1;
        if(dir==1) {
            //왼쪽방향
            dfs(leftX-1,leftY,rightX-1,rightY,count+1,board,visited);
            // 오른쪽 방향
            dfs(leftX+1,leftY,rightX+1,rightY,count+1,board,visited);
            //왼쪽 축
            if(board[leftY-1][leftX+1]!=1)
            dfs(leftX,leftY,leftX,leftY+1,count+1,board,visited);
            if(board[leftY+1][leftX+1]!=1)
            dfs(leftX,leftY,leftX,leftY-1,count+1,board,visited);
            //오른쪽 축
            if(board[rightY-1][rightX-1]!=1)
            dfs(rightX,rightY+1,rightX,rightY,count+1,board,visited);
            if(board[rightY-1][rightX-1]!=1)
            dfs(rightX,rightY-1,rightX,rightY,count+1,board,visited);

        }

    }
}
