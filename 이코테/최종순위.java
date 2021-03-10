package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 최종순위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int count = Integer.parseInt(br.readLine());
            int[][] changePriority = new int[count][2];
            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 2; k++) {
                    changePriority[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            solution(arr,count,changePriority);
        }


    }

    private static void solution(int[] lastYear, int count, int[][] changePriority) {
        int[][] graph = new int[lastYear.length + 1][lastYear.length + 1];
        int[] degree = new int[lastYear.length + 1];
        for (int i = 0; i < lastYear.length; i++) {
            for (int j = i + 1; j < lastYear.length; j++) {
                graph[lastYear[i]][lastYear[j]] = 1;
                degree[lastYear[j]]++;
            }
        }

        //
        for (int[] change : changePriority) {
            if (graph[change[0]][change[1]] == 1) {
                graph[change[0]][change[1]] = 0;
                graph[change[1]][change[0]] = 1;
                degree[change[1]]--;
                degree[change[0]]++;
            } else {
                graph[change[0]][change[1]] = 1;
                graph[change[1]][change[0]] = 0;
                degree[change[1]]++;
                degree[change[0]]--;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= lastYear.length; i++) {
            if (degree[i] == 0) queue.offer(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        boolean cycle = false;
        boolean multi = false;
        for (int i = 0; i < lastYear.length; i++) {
            if (queue.size() == 0) {
                cycle = true;
                break;
            }
            if (queue.size() >= 2) {
                multi = true;
                break;
            }
            int now = queue.poll();
            ans.add(now);
            for (int j = 1; j <= lastYear.length; j++) {
                if (graph[now][j] == 1) {
                    degree[j]--;
                    if (degree[j] == 0) queue.offer(j);
                }
            }
        }
        if (cycle) System.out.println("IMPOSSIBLE");
        else if (multi) System.out.println("?");
        else {
            System.out.println(ans.stream().map(e -> String.valueOf(e)).collect(Collectors.joining(" ")));
        }
    }
}
