package daikstra;

import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {
        //1~N개외 노드
        //int[][] = [[4,1,2],[1,2,3]]
        int N = 4;
        int[][] edges = new int[][]{{1, 2, 4}, {1, 4, 6}, {2, 1, 3}, {2, 3, 7}, {3, 1, 5}
                , {3, 4, 4}, {4, 3, 2}};
        solution(N, edges);
    }

    private static void solution(int N, int[][]edges) {
        int[][]table = floydwarshall(N,edges);

        int INF = (int)1e9+7;
        for (int[] ints : table) {
            for (int e : ints) {
                if(e==INF) e = -1;
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    private static int[][] floydwarshall(int n, int[][] edges) {
        int[][]table = new int[n+1][n+1];
        for (int[] arr : table) {
            Arrays.fill(arr, (int)1e9+7);
        }
        for (int[] info : edges) {
            int start = info[0];
            int end = info[1];
            int weight = info[2];
            //초기 테이블 갱신
            table[start][end] = weight;
        }
        for (int i = 1; i <=n ; i++) {
            table[i][i] = 0;
        }
        // 자기 노드-> 자기노드 0으로 초기화

        for (int k = 1; k <=n ; k++) {
            for (int a = 1; a <=n ; a++) {
                if(k==a)continue;
                for (int b = 1; b <=n ; b++) {
                    if(b==a||b==k)continue;
                    table[a][b] = Math.min(table[a][b],table[a][k]+table[k][b]);
                }
            }
        }
        /// step 1 ~N까지 nP2만큼 a-> b > a->k + k->b
        return table;
    }
}
