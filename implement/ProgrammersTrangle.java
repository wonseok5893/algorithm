package implement;

import java.util.ArrayList;

public class ProgrammersTrangle {
    public static void main(String[] args) {
        new ProgrammersTrangle().solution(5);
    }
    static int start;
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        start = n;
        printArr(0, 0, arr, 1, n);
        int[] result = new int[start * (start + 1) / 2];
        int pos = 0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j < i; j++) {
                result[pos++] = arr[i - 1][j];
            }
        }
        return result;
    }

    private void printArr(int step, int idx, int[][] arr, int numStart, int drawCount) {
        if(numStart>start*(start+1)/2)return;
        //왼쪽 아래로 그리기
        int startIdx = idx;
        int drawLeft = drawCount;
        int drawUnder = drawCount-1;
        int drawRight = drawCount-2;
        int endStep = step + drawCount - 1;
        int startStep = step;
        while (drawLeft-- > 0) {
            arr[startStep++][idx] = numStart++;
        }
        //아래 그리기
        while (drawUnder-- > 0) {
            arr[endStep][++startIdx] = numStart++;
        }
        //오른쪽 위 그리기
        while(drawRight-->0){
            arr[--endStep][endStep-idx] =numStart++;
        }
        printArr(step+2,idx+1,arr,numStart,drawCount-3);
    }
}
