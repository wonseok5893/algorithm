package com.wonseok.algorithm_note.topology_sorting;

import java.io.*;
import java.util.*;

public class Boj1766 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] degree = new int[n + 1];
        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            adjList[start].add(end);
            degree[end]++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <=n ; i++) {
            if(degree[i]==0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now+" ");
            for (int next : adjList[now]) {
                if(--degree[next]==0) queue.offer(next);
            }
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
