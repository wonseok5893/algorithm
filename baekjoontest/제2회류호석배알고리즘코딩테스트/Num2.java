package baekjoontest.제2회류호석배알고리즘코딩테스트;

import com.sun.scenario.effect.impl.state.AccessHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<String> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        // 인접 리스트
        Map<String, ArrayList<String>> map = new HashMap<>();
        Map<String, Integer> degree = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String child = st.nextToken();
            String ancestor = st.nextToken();
            if (map.get(child) == null) {
                ArrayList<String> ancestors = new ArrayList<>();
                ancestors.add(ancestor);
                map.put(child,ancestors);
            }else{
                map.get(child).add(ancestor);
            }
            if(degree.get(ancestor)==null){
                degree.put(ancestor, 1);
            } else degree.put(ancestor, degree.get(ancestor) + 1);
        }

        //위상 정렬
        Map<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        // 차수가 0인 사람 큐에넣어
        addZeroDegreePeson(n, lists, degree, visited, queue);



        while (!queue.isEmpty()) {
            String poll = queue.poll();
        }


    }

    private static void addZeroDegreePeson(int n, ArrayList<String> lists, Map<String, Integer> degree, Map<String, Integer> visited, Queue<String> queue) {
        for (int i = 0; i < n; i++) {
            if(visited.get(lists.get(i))!=null) continue;
            if(degree.getOrDefault(lists.get(i), 0)==0)
                queue.offer(lists.get(i));
        }
    }
}
