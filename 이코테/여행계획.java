package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행계획 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N개의 여행지가 있다 1~N까지
        // 양방향 관계

        // 1 2
        // 1 4
        // 1 5
        // 2 3
        // 2 4

        //여행계획 2 -> 3 -> 4 -> 5
        // 연결되어있는지 판단 YES or NO

        // 1 <= N,M <= 500

        // Union Find
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int[] targetNum = new int[m];
        for (int i = 0; i < m; i++) {
            targetNum[i] = Integer.parseInt(st.nextToken());
        }
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
               // graph[i][j] => i+1 -> j+1
                if (findParent(parent,i + 1) != findParent(parent,j + 1)) {
                    union(parent, i + 1, j + 1);
                }
            }
        }
        //
        boolean result = true;
        int temp = findParent(parent, targetNum[0]);
        for (int i = 1; i < m; i++) {
            if(findParent(parent,targetNum[i])!=temp){
                result = false;
                break;
            }
        }
        if(result) System.out.println("YES");
        else System.out.println("NO");

    }

    private static void union(int[] parent, int a, int b) {
        int aParent = findParent(parent, a);
        int bParent = findParent(parent, b);
        if(aParent<bParent) parent[bParent] = aParent;
        else parent[aParent] = bParent;
    }

    private static int findParent(int[] parent, int num) {
        if(parent[num]!=num) parent[num] = findParent(parent,parent[num]);
        return parent[num];
    }
}
