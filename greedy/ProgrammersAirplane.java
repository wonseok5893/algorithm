package greedy;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class ProgrammersAirplane {
    public static void main(String[] args) {
        solution(new String[][]{{"ICN", "SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}});
    }

    public static String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] info : tickets) {
            if (graph.get(info[0]) == null) {
                PriorityQueue<String> list = new PriorityQueue<>();
                list.offer(info[1]);
                graph.put(info[0], list);
            } else graph.get(info[0]).offer(info[1]);
        }

        ArrayList<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("ICN");
        result.add("ICN");
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            PriorityQueue<String> nextQueue = graph.get(poll);
            if (nextQueue!=null&&!nextQueue.isEmpty()) {
                String next = nextQueue.poll();
                queue.offer(next);
                result.add(next);
            }else break;
        }
        String[] resultArr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
            System.out.println(resultArr[i]);
        }
        return resultArr;
    }
}
