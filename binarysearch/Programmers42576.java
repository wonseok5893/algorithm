package com.wonseok.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers42576 {
    public static void main(String[] args) {
        Programmers42576 ps = new Programmers42576();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(ps.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        /*
        Arrays.sort(participant);
        Arrays.sort(completion);

        String result = "";
        int low = 0;
        int high = completion.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (!completion[mid].equals(participant[mid])) {
                    if (completion[mid - 1].equals(participant[mid - 1])) {
                        result += participant[mid];
                        break;
                    } else high = mid;
                } else {
                    low = mid + 1;
                }
            }

        return result.equals("")?participant[participant.length-1]:result;
        정렬로 풀었지만 효율성 테스트 실패*/
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String e : completion) map.put(e, map.get(e) - 1);
        for (String key : map.keySet()) {
            if(map.get(key)!=0)return key;
        }
        return null;
    }
}
