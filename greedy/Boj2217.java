package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
        // w/k
        // 10 15 20 30 40
        //
        int max = -1;
        for (int i = 0; i < ropes.length; i++) {
            int min = ropes[i];
            max = Math.max(max,min*(ropes.length-i));
        }
        System.out.println(max);
    }
}
