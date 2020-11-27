package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2887 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Planet planet = new Planet(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        }
    }

    private static class Planet {
        long x;
        long y;
        long z;

        public Planet(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
