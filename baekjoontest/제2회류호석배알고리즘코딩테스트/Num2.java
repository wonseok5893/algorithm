package baekjoontest.제2회류호석배알고리즘코딩테스트;


import java.io.*;
import java.util.*;

public class Num2 {
    public static void main(String[] args) throws IOException {
        //7
        //daeil sangdo yuri hoseok minji doha haeun
        //7
        //hoseok sangdo
        //yuri minji
        //hoseok daeil
        //daeil sangdo
        //haeun doha
        //doha minji
        //haeun minji
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        ArrayList<String> people = new ArrayList<>();
        Map<String, Integer> degree = new HashMap<>();
        Map<String, ArrayList<String>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            people.add(name);
            degree.put(name, 0);
            degree.put(name, 0);
            adjList.put(name, new ArrayList<>());
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String child = sc.next();
            String ancestor = sc.next();
            degree.put(child, degree.get(child) + 1);
            adjList.get(ancestor).add(child);
        }

        Queue<String> queue = new LinkedList<>();
        ArrayList<String> roots = new ArrayList<>();
        //제일 아래 자손
        for (String name : people) {
            if(degree.get(name)==0) {
                queue.offer(name);
                roots.add(name);
            }
        }
        //바로 자식 수
        Map<String, ArrayList<String>> ans = new HashMap<>();
        while(!queue.isEmpty()){
            //위상 정렬을 해보자
            //root를 지우고 간선을 지우고 degree가 0인 사람
            String anscestor = queue.poll();
            ArrayList<String> children = new ArrayList<>();
            for (String s : adjList.get(anscestor)) {
                int value = degree.get(s) - 1;
                degree.put(s, value);
                if(value==0) {
                    queue.offer(s);
                    children.add(s);
                }
            }
            ans.put(anscestor, children);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(roots.size() + "\n");
        Collections.sort(roots);
        for (String root : roots) {
            sb.append(root + " ");
        }
        sb.append("\n");
        Collections.sort(people);
        for (String person : people) {
            sb.append(person + " ");
            sb.append(ans.get(person).size()+" ");
            Collections.sort(ans.get(person));
            for (String s : ans.get(person)) {
                sb.append(s + " ");
            }
            sb.append("\n");
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
