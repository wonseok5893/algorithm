package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dx = {3,5};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < 2; i++) {
                int next = poll+dx[i];
                if(next>N)continue;
                if(arr[next]!=0)continue;
                arr[next] = arr[poll] +1;
                queue.offer(next);
            }
        }

        if(arr[N]==0) System.out.println(-1);
        else System.out.println(arr[N]);
    }

}
