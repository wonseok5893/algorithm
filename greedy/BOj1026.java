package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOj1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][]info = new int[2][n];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(info[0]);
        Arrays.sort(info[1]);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res+=info[0][n-i-1]*info[1][i];
        }
        System.out.println(res);
    }
}
