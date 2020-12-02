package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj2580 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }
        backTracking(0,0);
    }

    private static int backTracking(int row,int col) {
        if (row == 9) {
            for (int[] ints : map) {
                for (int e : ints) {
                    System.out.print(e+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if(col==9){
            backTracking(row+1,0);
            return 0;
        }
        if(map[row][col]==0){
            for (int i = 1; i <= 9; i++) {
                if(check(row,col,i)){
                    map[row][col] = i;
                    backTracking(row,col+1);
                }
            }
            map[row][col] = 0;
            return 0;
        }

        return backTracking(row,col+1);
    }

    private static boolean check(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
        }

        // 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value) {
                return false;
            }
        }

        // 3*3 칸에 중복되는 원소가 있는지 검사
        int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
        int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true; // 중복되는 것이 없을 경우 true 반환
    }

}
