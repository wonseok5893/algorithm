package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 행성터널 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Planet[] planets = new Planet[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(x, y, z, i);
        }
        ArrayList<Edge> edges = new ArrayList<>();
        Arrays.sort(planets, (o1, o2) -> o1.x - o2.x);
        for (int i = 1; i <n ; i++) {
            edges.add(new Edge(planets[i - 1].num, planets[i].num, Math.abs(planets[i - 1].x - planets[i].x)));
        }
        Arrays.sort(planets, (o1, o2) -> o1.y - o2.y);
        for (int i = 1; i <n ; i++) {
            edges.add(new Edge(planets[i - 1].num, planets[i].num, Math.abs(planets[i - 1].y - planets[i].y)));
        }
        Arrays.sort(planets, (o1, o2) -> o1.z - o2.z);
        for (int i = 1; i <n ; i++) {
            edges.add(new Edge(planets[i - 1].num, planets[i].num, Math.abs(planets[i - 1].z - planets[i].z)));
        }
        edges.sort((o1, o2) -> o1.w - o2.w);

        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for(Edge edge : edges){
            if (findParent(parent, edge.s) == findParent(parent, edge.e)) continue;
            union(parent, edge.s, edge.e);
            ans += edge.w;
        }
        System.out.println(ans);
    }

    private static int calcWeight(Planet a, Planet b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y) + Math.abs(a.z - b.z);
    }

    private static void union(int[] parent, int s, int e) {
        int aParent = findParent(parent, s);
        int bParent = findParent(parent, e);
        if(aParent<bParent) parent[bParent] = aParent;
        else parent[aParent] = bParent;
    }

    public static int findParent(int[]parent,int num){
        if(parent[num]==num) return num;
        return parent[num] = findParent(parent, parent[num]);
    }
    private static class Planet {
        int x;
        int y;
        int z;
        int num;

        public Planet(int x, int y, int z, int num) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }
    }

    private static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
