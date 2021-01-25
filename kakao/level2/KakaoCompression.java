package com.wonseok.kakao.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KakaoCompression {
    public static void main(String[] args) {

        new KakaoCompression().solution("TOBEORNOTTOBEORTOBEORNOT");
    }

    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'A');
            dictionary.put(String.valueOf(c), i + 1);
        }
        int num = 27;
        // 사전
        int length = msg.length();
        int nowPos = 0;
        int findLen = 1;
        int add = -1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (nowPos < length&&nowPos+findLen<=length) {
            String str = msg.substring(nowPos, nowPos + findLen);
            //있으면 다음꺼 까지 봐
            if (dictionary.keySet().contains(str)) {
                add = dictionary.get(str);
                findLen++;
                continue;
            }
            ans.add(add);
            //없으면 사전에 등록하고
            dictionary.put(str, num++);
            nowPos = nowPos + findLen - 1;
            findLen = 1;
            add = -1;
        }
        if (add != -1)
            ans.add(add);
        int[] res = new int[ans.size()];
        int pos = 0;
        for (Integer an : ans) {
            res[pos++] = an;
        }
        return res;
    }
}
