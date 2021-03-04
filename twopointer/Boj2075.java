package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Boj2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{0,i,arr[0][i]});
        }
        int count = n*n-n+1;
        int ans = -1;
        while(count-->0){
            int[] poll = queue.poll();
            ans = poll[2];
            if(poll[0]>=n-1)continue;
            queue.offer(new int[]{poll[0]+1,poll[1],arr[poll[0]+1][poll[1]]});
        }
        System.out.println(ans);

    }
}
