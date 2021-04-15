package dfs;

import java.io.*;
import java.util.*;

public class Boj16964 {
    static ArrayList<Integer>[] adjList;
    static int[] target;
    static int[] order;
    static boolean[] visit;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        target = new int[n];
        visit = new boolean[n+1];
        order = new int[n + 1];
        while (true) {
            int[] arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (arr.length == 2) {
                adjList[arr[0]].add(arr[1]);
                adjList[arr[1]].add(arr[0]);
            } else {
                target = arr;
                for (int i = 0; i < target.length; i++) {
                    order[target[i]] = i;
                }
                break;
            }
        }
        for (int i = 1; i <=n ; i++) {
            Collections.sort(adjList[i], (o1, o2) -> order[o1] - order[o2]);
        }
        if (target[0] != 1) {
            System.out.println(0);
            return;
        }

        dfs(1);
        boolean res = true;
        for (int i = 0; i < target.length; i++) {
            if(ans.get(i)!=target[i]){
                res = false;
                break;
            }
        }
        if(res) System.out.println(1);
        else System.out.println(0);

    }

    private static void dfs(int start) {
        visit[start] = true;
        ans.add(start);
        for (int next : adjList[start]) {
            if(visit[next]) continue;
            dfs(next);
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
