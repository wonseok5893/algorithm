package kakao.kakao2020Internship;

import java.util.*;
import java.util.stream.Collectors;

public class Problem3 {
    public static void main(String[] args) {
        solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
    }

    public static int[] solution(String[] gems) {
        int n = gems.length;
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(gems[i]);
        }
        int ans = Integer.MAX_VALUE;
        int startPos = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            String addGem = gems[i];
            if (!map.containsKey(addGem)) map.put(addGem, 1);
            else map.put(addGem, map.get(addGem) + 1);

            queue.offer(addGem);

            while (true) {
                if (map.get(queue.peek()) > 1) {
                    map.put(queue.peek(), map.get(queue.peek()) - 1);
                    queue.poll();
                    startPos++;
                } else break;
            }
            if (map.size() == set.size()) {
                if (ans > queue.size()) {
                    ans = queue.size();
                    start = startPos;
                }
            }
        }
        return new int[]{start + 1, start + ans};

    }
}