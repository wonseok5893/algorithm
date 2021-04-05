package kakao.commerce;

import java.util.ArrayList;

public class Num2 {
    public static void main(String[] args) {
        new Num2().solution(new int[][]{{1, 0, 0},
                {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}}, 2);
    }
    static int[][]needsStatic;
    static int staticR;
    public int solution(int[][] needs, int r) {
        //needs 1<= <=1000

        needsStatic = needs;
        staticR = r;
        int thingsMax = needs.length;
        int materialMax = needs[0].length;

        boolean[] visit = new boolean[materialMax];
        // 모든 경우를 구하자
        getCombination(visit, -1,0);
        return max;
    }
    static int max = -1;
    private void getCombination(boolean[] visit, int start,int count) {
        if(count==staticR){
            int checkCorrect = checkCorrect(visit);
            max = Math.max(max, checkCorrect);
            return;
        }

        for (int i = start+1; i < visit.length; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            getCombination(visit,i,count+1);
            visit[i] = false;
        }

    }

    private int checkCorrect(boolean[] visit) {
        int ans = 0;
        for (int[] need : needsStatic) {
            boolean res = true;
            for (int i = 0; i < need.length; i++) {
                if(need[i]==1){
                    if(!visit[i]) {
                        res = false;
                        break;
                    }
                }
            }
            if(res) ans++;
        }
        return ans;
    }
}
