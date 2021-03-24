package baekjoontest.제2회류호석배알고리즘코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num4 {
    static final int INF = (int) 1e9;
    static int[][] table;
    static int ans = INF;
    static int minNum = INF;
    static int maxNum = INF;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        table = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                table[i][j] = INF;
            }
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            table[start][end] = 1;
            table[end][start] = 1;
        }
        for (int i = 1; i <= n; i++) {
            table[i][i] = 0;
        }

        //플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                if (k == a) continue;
                for (int b = 1; b <= n; b++) {
                    if (b == a || b == k) continue;
                    table[a][b] = Math.min(table[a][b], table[a][k] + table[k][b]);
                }
            }
        }

        // 100c2<5000
        getMaxByCombination(n, 0, new ArrayList<Integer>());
        System.out.println(minNum + " " + maxNum + " " + ans);
    }

    private static void getMaxByCombination(int n, int start, ArrayList<Integer> lists) {
        if (lists.size() == 2) {
            //a,b 그러면 그때 최단거리 구해
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                int min = INF;
                for (Integer chickenNum : lists) {
                    min = Math.min(table[i][chickenNum], min);
                }
                sum += 2 * min;
            }
            if (ans >= sum) {
                int min = Math.min(lists.get(0), lists.get(1));
                int max = Math.max(lists.get(0), lists.get(1));
                if (ans == sum) {
                    if (minNum > min) {
                        if (minNum == min) {
                            if (maxNum > max) {
                                minNum = min;
                                maxNum = max;
                            }
                        } else
                            minNum = min;
                    }
                }else{
                    minNum = min;
                    maxNum = max;
                }
                ans = sum;

            }
            return;
        }
        for (int i = start + 1; i <= n; i++) {
            if (visited[i] != 0) continue;
            visited[i] = 1;
            lists.add(i);
            getMaxByCombination(n, start + 1, lists);
            lists.remove(new Integer(i));
            visited[i] = 0;
        }


    }
}
