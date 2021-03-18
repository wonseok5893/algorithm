package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj20207 {
    static int[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int minX, minY, maxX, maxY;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] cnt = new int[366];
        int[][] calender = new int[n + 1][366];
        visited = new int[n + 1][366];
        PriorityQueue<Work> queue = new PriorityQueue<Work>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue.offer(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        while (!queue.isEmpty()) {
            Work work = queue.poll();
            // 위에서부터 순차적으로 붙일 코팅
            for (int i = 0; i < n; i++) {
                boolean possible = true;
                for (int j = work.start; j <= work.end; j++) {
                    if (calender[i][j] != 0) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    for (int j = work.start; j <= work.end; j++) {
                        calender[i][j] = 1;
                        cnt[j]++;
                    }
                    break;
                }
            }
        }

        int sum = 0;
        int pos = 1;
        while (pos <= 365) {
            if (cnt[pos] != 0) {
                int start = 0;
                int mathLength = 0;
                while (pos<=365&&cnt[pos] != 0) {
                    start++;
                    mathLength = Math.max(mathLength, cnt[pos]);
                    pos++;
                }
                sum+=start*mathLength;
            }
            pos++;
        }
        System.out.println(sum);
    }

    private static class Work implements Comparable<Work> {
        int start;
        int end;
        int distance;

        public Work(int start, int end) {
            this.start = start;
            this.end = end;
            this.distance = end - start;
        }

        @Override
        public int compareTo(Work o) {
            if (start > o.start) return 1;
            else if (start == o.start) {
                if (distance < o.distance) return 1;
            }
            return -1;
        }
    }
}
