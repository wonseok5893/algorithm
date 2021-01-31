package kruskal;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 섬연결하기 {
    // https://programmers.co.kr/learn/courses/30/lessons/42861?language=java
    public static void main(String[] args) {
        new 섬연결하기().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
    }

    public int solution(int n, int[][] costs) {

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int count = 0;
        int[] parentArr = new int[n];
        for (int i = 0; i < n; i++) {
            parentArr[i] = i;
        }
        int len = costs.length;
        int pos = 0;
        int ans = 0;
        while (count < n - 1 && pos < len) {
            int a = costs[pos][0];
            int b = costs[pos][1];
            if (find(parentArr, a) != find(parentArr, b)) {
                ans += costs[pos][2];
                count++;
                union(parentArr, a, b);
            }
            find(parentArr, a);
            find(parentArr, b);
            pos++;
        }
        return ans;
    }

    private int union(int[] parentArr, int a, int b) {
        int aParent = find(parentArr, a);
        int bParent = find(parentArr, b);
        if (aParent < bParent)
            return parentArr[bParent] = aParent;
        return parentArr[aParent] = bParent;
    }

    private int find(int[] parentArr, int a) {
        if (a == parentArr[a]) return a;
        return parentArr[a] = find(parentArr, parentArr[a]);
    }

}
