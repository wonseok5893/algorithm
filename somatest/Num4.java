package somatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int[]block = new int[n];
        for (int i = 0; i < n; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max,game(i,block));
        }
        System.out.println(Math.min(n,max+1));

    }

    private static int game(int start, int[] block) {
        int[] visited = new int[block.length];
        visited[start] = 1;
        int count = 1;
        while(count<block.length){
            if(visited[start+block[start]]!=1){
                start = start+block[start];
                visited[start] =1;
                count++;
                continue;
            }
            break;
        }
        return count;
    }
}
