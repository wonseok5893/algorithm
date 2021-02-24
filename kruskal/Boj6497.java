package kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj6497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //입력값 초기화
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(v==0&&e==0)break;
            // 크루스칼 초기화
            int[] parentArr = new int[v];
            for (int i = 0; i < v; i++) {
                parentArr[i] = i;
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            int total = 0;
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                total += weight;
                queue.offer(new int[]{start, end, weight});
            }

            int count = 0;
            int ans = 0;

            while (count < v - 1 && !queue.isEmpty()) {
                int[] now = queue.poll();
                if (find(parentArr, now[0]) != find(parentArr, now[1])) {
                    ans += now[2];
                    union(parentArr, now[0], now[1]);
                    count++;
                }
            }
            System.out.println(total-ans);
        }
    }
    private static int union(int[] parentArr, int a, int b) {
        int aParent = find(parentArr, a);
        int bParent = find(parentArr, b);
        if (aParent < bParent)
            return parentArr[bParent] = aParent;
        return parentArr[aParent] = bParent;
    }

    private static int find(int[] parentArr, int a) {
        if (a == parentArr[a]) return a;
        return parentArr[a] = find(parentArr, parentArr[a]);
    }
}
