package dev;

import java.util.Arrays;

public class Num2 {
    public static void main(String[] args) {
        new Num2().solution(6, 6, new int[][]{{2, 2, 5, 4},
                {3, 3, 6, 6}, {5, 1, 6, 3}});
    }
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <columns; j++) {
                map[i][j] = n++;
            }
        }
        int[] ans = new int[queries.length];
        int pos = 0;
        for (int[] query : queries) {
            ans[pos++] = rotate(query);
            for (int[] ints : map) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
        }
        return ans;
    }

    private int rotate(int[] query) {
        int min = 100001;

        int startY = query[0]-1;
        int startX = query[1]-1;
        int endY = query[2]-1;
        int endX = query[3]-1;

        int xLen = endX - startX+1;
        int yLen = endY - startY+1;

        int temp = map[startY][startX];
        min = Math.min(min, temp);
        for (int i = 1; i < yLen; i++) {
            map[startY+i-1][startX] = map[startY + i][startX];
            min = Math.min(min, map[startY + i - 1][startX]);
        }
        for (int i = 1; i < xLen; i++) {
            map[endY][startX+i-1] = map[endY][startX + i];
            min = Math.min(min, map[endY][startX + i - 1]);
        }
        for (int i = 1; i < yLen; i++) {
            map[endY-i+1][endX] = map[endY - i][endX];
            min = Math.min(min, map[endY-i+1][endX] );
        }
        for (int i = 1; i < xLen-1; i++) {
            map[startY][endX - i + 1] = map[startY][endX - i];
            min = Math.min(min, map[startY][endX - i + 1]);
        }
        map[startY][startX+1] = temp;
        return min;
    }
}
