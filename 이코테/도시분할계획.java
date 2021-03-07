package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 도시분할계획 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int[] parent = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            parent[i] = i;
        }
        int ans = 0;
        int max = 0;
        for (int[]edge:edges) {
            if(findParent(parent,edge[0])!=findParent(parent,edge[1])){
                unionParent(parent, edge[0], edge[1]);
                ans += edge[2];
                max = edge[2];
            }
        }
        System.out.println(ans-max);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if(a<b) parent[b] = a;
        else parent[a] = b;

    }

    private static int findParent(int[] parent, int num) {
        if(parent[num]!=num) parent[num] = findParent(parent,parent[num]);
        return parent[num];
    }
}
