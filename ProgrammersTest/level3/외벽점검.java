package ProgrammersTest.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 외벽점검 {
    public static void main(String[] args) {//
        //12	[1, 5, 6, 10]	[1, 2, 3, 4]	2
        //12	[1, 3, 4, 9, 10]	[3, 5, 7]	1
        new 외벽점검().solution(12,new int[]{1,5,6,10},new int[]{1,2,3,4});
    }

    public int solution(int n, int[] weak, int[] dist) {
        // 1 5 6 10 13  ->  4 1 4 3
        // 1 3 4 9 10 13 -> 2 1 5 1 3

        // 6 5 3 // 1 3 2 1
        // 가능한 많은 취약점을 조사

        // 최대 n명 -> n/2 명이되는지

        // 한명이서 가능 연속적인 간선 n-1개 선택

        // 2명 n - 뽑은개수 +1

        // 2명 3 2 1 1 -> 4개

        // 3명
        Arrays.sort(dist);


        int max = weak.length;

        ArrayList<Integer> lists = new ArrayList<>();
        Arrays.stream(weak).forEach(e -> lists.add(e));
        lists.add(n + weak[0]);
        // 원형 리스트
        // 1 3 4 9 10 13
        ArrayList<Integer> subLists = new ArrayList<>();
        for (int i = 0; i < lists.size() - 1; i++) {
            subLists.add(lists.get(i + 1) - lists.get(i));
        }
        // 간선 비용 리스트
        // 2 1 5 1 3

        int count = 0;
        for (int i = dist.length - 1; i >= 0; i--) {
            int now = dist[i];
            if(subLists.size()==1) return count+1;
            else if(subLists.size()==0) return count;
            //최대로
            else {
                ArrayList<Integer> ans = findMax(subLists, now);
                int maxPos = -1;
                List<Integer> collect = subLists.stream().filter(e -> !ans.contains(e)).collect(Collectors.toList());
                
            }
        }
        return 0;

    }

    private ArrayList<Integer> findMax(ArrayList<Integer> subLists, int value) {
        int startPos = 0;
        int max = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (startPos < subLists.size()) {
            // 더할수 있으면 더해
            int sum = 0;
            int temp = 0;
            ArrayList<Integer> tempAns = new ArrayList<>();
            for (int i = 0; i < subLists.size() - 1; i++) {
                if (sum + subLists.get((startPos + i) % subLists.size()) <= value) {
                    sum += subLists.get((startPos + i) % subLists.size());
                    tempAns.add((startPos + i) % subLists.size());
                    temp++;
                } else {
                    if (max < temp) {
                        max = temp;
                        ans.clear();
                        ans.addAll(tempAns);
                    }
                    break;
                }
            }
            startPos++;
        }
        return ans;
    }

}
