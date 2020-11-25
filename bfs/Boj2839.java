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

//        soltutionBFS(N);
        // 0 +3 = 3
        // 0 +5 = 5
        // 0 +3 +3 = 6
        // 0 +3 +5 = 8
        // 0 +5 +3 = 8
        // 0 +5 +5 = 10
        // 18
        // 19
        // 4
        if (N % 5 == 0) System.out.println(N / 5);
        else {
            int count5 = N / 5;
            //나머지를
            int namage = N % 5;
            if (namage % 3 == 0) {
                int count3 = namage / 3;
                System.out.println(count5 + count3);
            } else {
                boolean result = false;
                while (count5 > 0) {
                    count5--;
                    namage += 5;
                    if (namage % 3 == 0) {
                        System.out.println(count5 + namage / 3);
                        result = true;
                        break;
                    } else continue;
                }
                if(!result)
                System.out.println(-1);
            }
        }


        // 3+3
        // 3+5
        // 3+3+3
        // 3+3+5
        // 3+3+3+3
        // 3+3+3+5


    }

    private static void soltutionBFS(int n) {
        int[] arr = new int[n + 1];
        int[] dx = {3, 5};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < 2; i++) {
                int next = poll + dx[i];
                if (next > n) continue;
                if (arr[next] != 0) continue;
                arr[next] = arr[poll] + 1;
                queue.offer(next);
            }
        }
        if (arr[n] == 0) System.out.println(-1);
        else System.out.println(arr[n]);
    }


}
