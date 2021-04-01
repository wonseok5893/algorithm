package ProgrammersTest.level3;

public class NQueen {
    public static void main(String[] args) {
        new NQueen().solution(5);
    }
    static int ans;
    static boolean[]rightVisited;
    static boolean[]leftVisited;
    static boolean[]xVisited;
    static boolean[]yVisited;
    public int solution(int n) {
        rightVisited = new boolean[2*n+1];
        leftVisited = new boolean[2*n+1];
        xVisited = new boolean[n];
        yVisited = new boolean[n];
        putQueenOnBoard( 0, n);
        return ans;
    }

    private void putQueenOnBoard( int y,int n) {
        if(y==n){
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(leftVisited[y+i])continue;
            if(rightVisited[y-i+n])continue;
            if(xVisited[i])continue;
            if(yVisited[y])continue;
            visitCheckOrUnCheck(y,i,n);
            putQueenOnBoard(y+1,n);
            visitCheckOrUnCheck(y,i,n);
        }
    }

    private void visitCheckOrUnCheck(int y,int i,int n) {
        leftVisited[y+i]=!leftVisited[y+i];
        rightVisited[y - i + n] = !rightVisited[y - i + n];
        xVisited[i]=!xVisited[i];
        yVisited[y]=!yVisited[y];
    }

}
