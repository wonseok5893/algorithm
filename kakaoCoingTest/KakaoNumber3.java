package com.wonseok.kakaoCoingTest;


public class KakaoNumber3 {

    public int[] solution(String[] info, String[] query) {

        //참가자 구성
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int count = 0;
            String[] queryInfo = query[i].split(" ");
            for (String s : info) {
                String[] applicantInfos = s.split(" ");
                if(checkInfo(applicantInfos[0], applicantInfos[1], applicantInfos[2], applicantInfos[3], Integer.parseInt(applicantInfos[4]), queryInfo))
                    count++;
            }
            answer[i] = count;

        }

        return answer;
    }

    boolean checkInfo(String language, String part, String career, String soulFood, int score, String[] info) {
        if (score < Integer.parseInt(info[7])) return false;
        if (!info[0].equals("-")) {
            if (!language.equals(info[0])) return false;
        }
        if (!info[2].equals("-")) {
            if (!part.equals(info[2])) return false;
        }
        if (!info[4].equals("-")) {
            if (!career.equals(info[4])) return false;
        }
        if (!info[6].equals("-")) {
            if (!soulFood.equals(info[6])) return false;
        }
        return true;
    }
}