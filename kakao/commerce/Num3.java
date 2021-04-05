package kakao.commerce;

import java.util.ArrayList;

public class Num3 {
    //출발역은 1번
    //종착역을 정해야함
    // 같은역을 두번이상 방문 x - 사이클 존재 x
    //출발역은 1번


    // 완전 탐색 x
    static boolean[] visited;
    static int ans;
    static int ansNum;

    public int[] solution(int n, int[] passenger, int[][] train) {
        //연결된 끝
        // 1->a->b->c->d ->
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] trainInfo : train) {
            int start = trainInfo[0];
            int end = trainInfo[1];
            adjList[start].add(end);
            adjList[end].add(start);
        }
        visited = new boolean[n + 1];
        //1번부터 갈수 있는 경로를 탐색하여 최댓값을 구하자
        dfs(1, adjList, 0, passenger);
        return new int[]{ansNum, ans};
    }

    private void dfs(int start, ArrayList<Integer>[] adjList, int sum, int[] passenger) {
        visited[start] = true;
        sum += passenger[start-1];
        if (ans < sum) {
            ans = sum;
            ansNum = start;
        } else if (ans == sum) {
            if (ansNum < start) {
                ansNum = start;
            }
        }
        for (Integer next : adjList[start]) {
            if (visited[next]) continue;
            dfs(next, adjList, sum, passenger);
        }

    }

}
