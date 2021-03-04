package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[2][3];
        int[][] min = new int[2][3];

        for (int i = 0; i < n; i++) {
            min[1][0] = arr[i][0] + Math.min(min[0][0], min[0][1]);
            min[1][1] = arr[i][1] + Math.min(min[0][0], Math.min(min[0][1], min[0][2]));
            min[1][2] = arr[i][2] + Math.min(min[0][1], min[0][2]);

            min[0][0] = min[1][0];
            min[0][1] = min[1][1];
            min[0][2] = min[1][2];


            max[1][0] = arr[i][0] + Math.max(max[0][0], max[0][1]);
            max[1][1] = arr[i][1] + Math.max(max[0][0], Math.max(max[0][1], max[0][2]));
            max[1][2] = arr[i][2] + Math.max(max[0][1], max[0][2]);

            max[0][0] = max[1][0];
            max[0][1] = max[1][1];
            max[0][2] = max[1][2];
        }
        Arrays.sort(min[1]);
        Arrays.sort(max[1]);
        System.out.println(max[1][2]+" "+min[1][0]);
    }
}
