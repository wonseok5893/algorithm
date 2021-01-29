package com.wonseok.kakao.kakao2021;

public class Problem1 {
    public static void main(String[] args) {

        new Problem1().solution("=.=");

    }
    public String solution(String new_id) {
        // 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
        //알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = removeException(new_id);
        // 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = removeMultiDot(new_id);
        //마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        new_id = removeFirstEndDot(new_id);
        //빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.length()==0) new_id = "a";
        //new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length()>=16){
            new_id = removeFirstEndDot(new_id.substring(0,15));
        }
        if(new_id.length()<=2){
            char end = new_id.charAt(new_id.length() - 1);
            int length = new_id.length();
            for (int i = 0; i < 3-length; i++) {
                new_id+=end;
            }
        }
        System.out.println(new_id);
        return new_id;
    }

    private String removeFirstEndDot(String new_id) {
        if(new_id.length()>=2) {
            if (new_id.charAt(0) == '.' && new_id.charAt(new_id.length() - 1) == '.')
                return new_id.substring(1, new_id.length() - 1);
            if (new_id.charAt(0) == '.')
                return new_id.substring(1);
            if (new_id.charAt(new_id.length() - 1) == '.')
                return new_id.substring(0, new_id.length() - 1);
            else return new_id;
        }else if(new_id.length()==1){
            if(new_id.charAt(0)=='.')
                return "";
        }
        return new_id;
    }

    private String removeMultiDot(String new_id) {
        char[] chars = new_id.toCharArray();
        StringBuilder sb = new StringBuilder();
        char before = chars[0];
        sb.append(before);
        for (int i = 1; i < chars.length; i++) {
            char now = chars[i];
            if(now!='.') {
                sb.append(now);
                before = now;
            }
            else{
                if(before!='.') {
                    sb.append(now);
                    before = now;
                }
            }
        }
        return sb.toString();
    }

    private String removeException(String new_id) {
        char[] chars = new_id.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if(Character.isAlphabetic(c)||Character.isDigit(c)||c=='-'||c=='_'||c=='.')
                sb.append(c);
        }
        return sb.toString();
    }
}
