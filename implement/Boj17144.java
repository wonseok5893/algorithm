package implement;

import java.io.*;
import java.util.*;

public class Boj17144 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int t = sc.nextInt();
        int[] upStart = new int[2];
        int[] downStart = new int[2];

        ArrayList<Loc> nests = new ArrayList<>();
        boolean[][] visit = new boolean[r][c];

        boolean top = true;
        int[][] map = new int[r][c];
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    if (top) {
                        upStart[0] = j;
                        upStart[1] = i;
                        top = false;
                    } else {
                        downStart[0] = j;
                        downStart[1] = i;
                    }
                } else if (map[i][j] != 0) {
                    nests.add(new Loc(j, i));
                    visit[i][j] = true;
                }
            }
        }
        //1.미세먼지가 확산
        //2.모든 미세먼지가 동시에 확산된다.
        //3.공기청정기 or over range x
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        while (t-- > 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            //미세먼지 확산
            Queue<Loc> addLists = new LinkedList<>();
            for (Loc nest : nests) {
                ArrayList<Loc> lists = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    int nextY = nest.y + dy[i];
                    int nextX = nest.x + dx[i];
                    if (nextX < 0 || nextY < 0 || nextX >= c || nextY >= r || map[nextY][nextX] == -1) continue;
                    lists.add(new Loc(nextX, nextY));
                }
                int add = temp[nest.y][nest.x] / 5;
                for (Loc list : lists) {
                    map[list.y][list.x] += add;
                    if (!visit[list.y][list.x]) {
                        visit[list.y][list.x] = true;
                        addLists.offer(list);
                    }
                }
                map[nest.y][nest.x] -= add * lists.size();
            }
            nests.addAll(addLists);

            if (map[upStart[1] - 1][0] != 0) {
                nests.remove(new Loc(0, upStart[1] - 1));
                map[upStart[1] - 1][0] = 0;
            }
            if (map[downStart[1] + 1][0] != 0) {
                nests.remove(new Loc(0, downStart[1] + 1));
                map[downStart[1] + 1][0] = 0;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            for (int i = 1; i < c - 1; i++) {
                if (map[upStart[1]][i] != 0) {
                    nests.get(nests.indexOf(new Loc(i, upStart[1]))).x++;
                }
                queue.offer(map[upStart[1]][i]);
                map[upStart[1]][i] = queue.poll();
            }
            for (int i = upStart[1]; i > 0; i--) {
                if (nests.contains((new Loc(c - 1, i)))) {
                    nests.get(nests.indexOf(new Loc(c - 1, i))).y--;
                }
                queue.offer(map[i][c - 1]);
                map[i][c - 1] = queue.poll();
            }
            for (int i = c - 1; i > 0; i--) {
                if (map[0][i] != 0) {
                    nests.get(nests.indexOf(new Loc(i, 0))).x--;
                }
                queue.offer(map[0][i]);
                map[0][i] = queue.poll();
            }
            for (int i = 0; i < upStart[1] - 1; i++) {
                if (map[i][0] != 0) {
                    nests.get(nests.indexOf(new Loc(0, i))).y++;
                }
                queue.offer(map[i][0]);
                map[i][0] = queue.poll();
            }
            queue.clear();
            queue.offer(0);
            for (int i = 1; i < c - 1; i++) {
                if (nests.contains(new Loc(i, downStart[1]))) {
                    nests.get(nests.indexOf(new Loc(i, downStart[1]))).x++;
                }
                queue.offer(map[downStart[1]][i]);
                map[downStart[1]][i] = queue.poll();
            }
            for (int i = downStart[1]; i < r - 1; i++) {
                if (visit[i][c - 1]) {
                    nests.get(nests.indexOf(new Loc(c - 1, i))).y++;
                }
                queue.offer(map[i][c - 1]);
                map[i][c - 1] = queue.poll();
            }
            for (int i = c - 1; i > 0; i--) {
                if (visit[r - 1][i]) {
                    nests.get(nests.indexOf(new Loc(i, r - 1))).x--;
                }
                queue.offer(map[r - 1][i]);
                map[r - 1][i] = queue.poll();
            }
            for (int i = r - 1; i > downStart[1] + 1; i--) {
                if (visit[i][0]) {
                    nests.get(nests.indexOf(new Loc(0, i))).y--;
                }
                queue.offer(map[i][0]);
                map[i][0] = queue.poll();
            }

        }
        int ans = 0;
        for (int[] ints : map) {
            for (int e : ints) {
                if (e != 0 && e != -1) ans += e;
            }
        }
        System.out.println(ans);
    }

    static class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Loc loc = (Loc) o;
            return x == loc.x &&
                    y == loc.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
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
