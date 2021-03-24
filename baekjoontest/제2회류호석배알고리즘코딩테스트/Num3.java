package baekjoontest.제2회류호석배알고리즘코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num3 {
    static int n1;
    static int m1;
    static int ans = (int) 1e9;
    static int maxLenPuzzle2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n1 = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        int[][] puzzle1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m1; j++) {
                puzzle1[i][j] = Integer.parseInt(str[j]);
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int n2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int[][] puzzle2 = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m2; j++) {
                puzzle2[i][j] = Integer.parseInt(str[j]);
            }
        }

        //TODO -----------------------------------------
        //TODO 왼쪽 위를 축으로  max(n2,m2)<= i <n1+ max(n2,m2)
        //TODO 회전 시키면서
        maxLenPuzzle2 = Math.max(n2, m2);
        int[][] pan = new int[n1 + 2 * maxLenPuzzle2][m1 + 2 * maxLenPuzzle2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                pan[maxLenPuzzle2 + i][maxLenPuzzle2 + j] = puzzle1[i][j];
            }
        }
        for (int i = 0; i < maxLenPuzzle2 + n1; i++) {
            for (int j = 0; j < maxLenPuzzle2 + m1; j++) {
                getMinMixedPuzzle(pan, i, j, puzzle2);
            }
        }
        System.out.println(ans);
    }

    private static void getMinMixedPuzzle(int[][] pan, int y, int x, int[][] puzzle2) {
        int rotate = 0;
        int[][] rotatePuzzle2 = puzzle2.clone();
        while (rotate < 4) {
            rotatePuzzle2 = rotate(rotatePuzzle2);
            boolean check = true;
            for (int i = 0; i < rotatePuzzle2.length; i++) {
                for (int j = 0; j < rotatePuzzle2[i].length; j++) {
                    pan[i + y][j + x] += rotatePuzzle2[i][j];
                    if (pan[i + y][j + x] > 1) check = false;
                }
            }
            if (check) {
                int maxX = Math.max(x + rotatePuzzle2[0].length, maxLenPuzzle2 + m1);
                int maxY = Math.max(y + rotatePuzzle2.length, maxLenPuzzle2 + n1);
                int minX = Math.min(x, maxLenPuzzle2);
                int minY = Math.min(y, maxLenPuzzle2);
                ans = Math.min(ans, (maxX - minX) * (maxY - minY));
            }
            for (int i = 0; i < rotatePuzzle2.length; i++) {
                for (int j = 0; j < rotatePuzzle2[i].length; j++) {
                    pan[i + y][j + x] -= rotatePuzzle2[i][j];
                }
            }
            rotate++;
        }
    }

    private static int[][] rotate(int[][] puzzle2) {
        int[][] rotate = new int[puzzle2[0].length][puzzle2.length];
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[0].length; j++) {
                rotate[i][j] = puzzle2[puzzle2.length - 1 - j][i];
            }
        }
        return rotate;
    }
}
