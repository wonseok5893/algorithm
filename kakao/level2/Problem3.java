package com.wonseok.kakao.level2;

public class Problem3 {
    public static void main(String[] args) {
        new Problem3().solution(2, new String[]{"N~F=0", "R~T>2"});
    }

    static int[]visited = new int[8];
    static int answer;
    public int solution(int n, String[] data) {
        //조건의 개수 n: 1<=n<=100
        // data 원소 길이 <= 5
        // 8 명
        char[] arr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        permutation(arr,"",8,data);
        System.out.println(answer);
        return answer;
    }

    private boolean verify(String str, String[] data) {
        for (int i = 0; i < data.length; i++) {
            String condition = data[i];
            String[] conArr= condition.split("");
            String a = conArr[0];
            String b = conArr[2];
            String oper = conArr[3];
            int dist = Integer.parseInt(conArr[4])+1;
            int aIdx = str.indexOf(a);
            int bIdx = str.indexOf(b);
            switch (oper) {
                case "=":
                {
                    if(aIdx>bIdx){
                        if(aIdx-bIdx!=dist)return false;
                    }else{
                        if(bIdx-aIdx!=dist) return false;
                    }
                    break;
                }
                case "<":
                {
                    if(aIdx>bIdx){
                        if(aIdx-bIdx>=dist)return false;
                    }else{
                        if(bIdx-aIdx>=dist) return false;
                    }
                    break;
                }
                case ">":
                {
                    if(aIdx>bIdx){
                        if(aIdx-bIdx<=dist)return false;
                    }else{
                        if(bIdx-aIdx<=dist) return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    private void permutation(char[] arr, String str, int count, String[] data) {
        if(count==0){
           if(verify(str,data))
               answer++;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(visited[i]!=0) continue;
            visited[i] =1;
            str+=arr[i];
            permutation(arr, str, count - 1, data);
            str = str.substring(0, str.length() - 1);
            visited[i] = 0;
        }
    }

}
