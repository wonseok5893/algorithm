package graph;

import java.io.*;
import java.util.*;

public class Boj2251 {
    static int[] limit = new int[3];
    static boolean[][][] visit = new boolean[201][201][201];

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        for (int i = 0; i < 3; i++) {
            limit[i] = sc.nextInt();
        }
        boolean[] ans = new boolean[201];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, limit[2]});
        visit[0][0][limit[2]] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == 0) ans[now[2]] = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    int[] temp = now.clone();
                    if (temp[i] + temp[j] > limit[j]) {
                        temp[i] -= limit[j] - temp[j];
                        temp[j] = limit[j];
                    } else {
                        temp[j] += temp[i];
                        temp[i] = 0;
                    }
                    if (visit[temp[0]][temp[1]][temp[2]]) continue;
                    visit[temp[0]][temp[1]][temp[2]] = true;
                    queue.offer(temp);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= 200; i++) {
            if (ans[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


}
