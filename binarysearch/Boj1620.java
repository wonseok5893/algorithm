package binarysearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1620 {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<PoketMon> poketmonlists = new ArrayList<>();
        ArrayList<PoketMon> idexLists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            poketmonlists.add(new PoketMon(i,sc.nextLine()));
        }
        Collections.sort(poketmonlists, (a, b) -> a.name.compareTo(b.name));
        idexLists.addAll(poketmonlists);
        Collections.sort(idexLists, (a, b) -> a.num-b.num);
        for (int i = 0; i < m; i++) {
            solution(sc.next(), poketmonlists, idexLists);
        }
        System.out.println(sb);
    }

    private static void solution(String next, ArrayList<PoketMon> poketMons, ArrayList<PoketMon> poketmonlists) {
        char firstChar = next.charAt(0);
        if(Character.isAlphabetic(firstChar)){
            sb.append(findPoketmonInList(poketMons, next)+1+"\n");
        }else{
            sb.append(poketmonlists.get(Integer.parseInt(next)-1).name+"\n");
        }
    }

    private static int findPoketmonInList(ArrayList<PoketMon> poketmonlists, String next) {
        int start = 0;
        int end = poketmonlists.size()-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int compare = poketmonlists.get(mid).name.compareTo(next);
            if (compare < 0) {
                start = mid+1;
            }else{
                if(compare==0)return poketmonlists.get(mid).num;
                end = mid-1;
            }
        }
        return -1;
    }
    private static class PoketMon {
        int num;
        String name;

        public PoketMon(int num, String name) {
            this.num = num;
            this.name = name;
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
