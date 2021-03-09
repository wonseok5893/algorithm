package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //거리정보
        int K = Integer.parseInt(st.nextToken());
        // 출발 도시
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }
        // 초기화 끝

        ArrayList<Integer> ans = new ArrayList<>();
        // X에서 시작 -> 최단거리 == K 인 모든 도시의 번호를 출력

        int startNum = X;
        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);
        visited[startNum] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNum);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if(visited[next]!=-1) continue;
                queue.offer(next);
                visited[next] = visited[now] + 1;
                if(visited[next]==K){
                    ans.add(next);
                }
            }
        }
        Collections.sort(ans);
        StringBuffer sb = new StringBuffer();
        for (int e : ans) {
            sb.append(e + " ");
        }
        if(sb.length()==0) System.out.println(-1);
        else System.out.println(sb);

    }
}
