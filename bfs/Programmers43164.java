package com.wonseok.bfs;

import java.util.*;

public class Programmers43164 {
    public static void main(String[] args) {
        solution(new String[][]{{"ICN", "JFK"},{"HND","IAD"}
        ,{"JFK","HND"}});
    }
    public static String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            if(graph.get(ticket[0])==null){
            graph.put(ticket[0],new PriorityQueue<>(
            ));
            graph.get(ticket[0]).offer(ticket[1]);
            }else{
                graph.get(ticket[0]).offer(ticket[1]);
            }
        }
        for (String s : graph.keySet()) {
            System.out.print(s+":");
            PriorityQueue<String> strings = graph.get(s);
            Iterator iter = strings.iterator();
            while (iter.hasNext()) System.out.print(iter.next()+" ");
            System.out.println();

        }
        Map<String, Integer> visited = new HashMap<>();

        PriorityQueue<String> nextStations = graph.get("ICN");
        visited.put("ICN",new Integer(1));

        Queue<String> queue = new LinkedList<>();
        queue.offer("ICN");
        while(!queue.isEmpty()){
            String now = queue.poll();
            PriorityQueue<String> pqueue = graph.get(now);
            if(pqueue==null) continue;
            Iterator iter = pqueue.iterator();
            while (iter.hasNext()){
                String next = (String) iter.next();
                if(visited.get(next)!=null)continue;
                queue.offer(next);
                visited.put(next,visited.get(now)+1);
                pqueue.remove(next);
                break;
            }
        }
        ArrayList<String> strings = new ArrayList<>(visited.keySet());

        Collections.sort(strings,(o1,o2)->visited.get(o1)-visited.get(o2));

        String[] ans = new String[strings.size()];
        int pos = 0;
        for (String s : strings) {
            System.out.print(s+" ");
            ans[pos++] = s;
        }
        System.out.println();
        return ans;
    }
}
