package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 어두운길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] roads = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                roads[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(n, m, roads);
    }

    private static void solution(int n, int m, int[][] roads) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int sum = 0;
        Arrays.sort(roads, (o1, o2) -> o1[2] - o2[2]);
        for (int[] road : roads) {
            if (findParent(parent, road[0]) == findParent(parent, road[1])) continue;
            union(parent, road[0], road[1]);
            sum += road[2];
        }
        int res = Arrays.stream(roads).map(e -> e[2]).mapToInt(e -> e).sum();
        System.out.println(res-sum);
    }

    private static void union(int[] parent, int a, int b) {
        a = findParent(parent,a);
        b = findParent(parent, b);
        if(a<b) parent[b] = findParent(parent,a);
        else parent[a] = findParent(parent, b);

    }

    private static int findParent(int[] parent, int num) {
        if(parent[num]==num) return num;
        return parent[num] = findParent(parent, parent[num]);
    }
}
