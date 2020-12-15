package daikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FolydExample {
    public static void main(String[] args) throws IOException {
        //미래도시
        // 간선의 가중치: 1로 동일
        // 회사의 개수: N
        // 간선의 개수: M
        // k번을 거쳐
        // X회사로 가야함
        //ex)
        int N = 5;
        int M = 7;
        int K = 2;
        int X = 4;
        int[][] edges = {{1, 3, 1}, {1, 4, 1}, {2, 4, 1}, {3, 4, 1}
                , {3, 5, 1}, {4, 5, 1}, {4, 5, 1}};
        int[][] table = floydwarshall(N, edges);
        for (int[] ints : table) {
            for (int e : ints) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
        System.out.println(table[1][K]+table[K][X]);
    }

    private static int[][] floydwarshall(int n, int[][] edges) {
        int[][] table = new int[n + 1][n + 1];
        for (int[] arr : table) {
            Arrays.fill(arr, (int) 1e9 + 7);
        }
        for (int[] info : edges) {
            int start = info[0];
            int end = info[1];
            int weight = info[2];
            //초기 테이블 갱신
            table[start][end] = weight;
        }
        for (int i = 1; i <= n; i++) {
            table[i][i] = 0;
        }
        // 자기 노드-> 자기노드 0으로 초기화

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                if (k == a) continue;
                for (int b = 1; b <= n; b++) {
                    if (b == a || b == k) continue;
                    table[a][b] = Math.min(table[a][b], table[a][k] + table[k][b]);
                }
            }
        }
        /// step 1 ~N까지 nP2만큼 a-> b > a->k + k->b
        return table;
    }
}
