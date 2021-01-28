package com.wonseok.kakao.level2;

public class Problem9 {
    public static void main(String[] args) {
        //https://programmers.co.kr/learn/courses/30/lessons/1835
        new Problem9().solution(2,new String[]{"N~F=0","R~T>2"});
    }
    static int ans;
    static String[] conditions;
    public int solution(int n, String[] data) {
        conditions = data;
        String[]people = new String[]{"A","C","F","J","M","N","R","T"};
        int[]visited = new int[8];
        permutation(people,visited,0,"");
        System.out.println(ans);
        return ans;
    }

    private void permutation(String[] people, int[] visited, int count,String res) {
        if(count==8){
            if(check(res)) {
                ans++;
            }
            return;
        }
        for (int i = 0; i < people.length; i++) {
            if(visited[i]==1)continue;
            visited[i] = 1;
            res+=people[i];
            permutation(people,visited,count+1,res);
            res =  res.substring(0,res.length()-1);
            visited[i] = 0;
        }
    }

    private boolean check(String res) {
        boolean result = true;
        for (String condition : conditions) {
            String[] split = condition.split("");
            int a = res.indexOf(split[0]);
            int b = res.indexOf(split[2]);
            int aMinusB = a-b>=0?a-b:(a-b)*-1;
            String cond = split[3];
            int distance = Integer.parseInt(split[4]);
            if(cond.equals("<")){
                if(aMinusB>=distance+1){
                    result = false;
                    break;
                }
            }else if(cond.equals(">")){
                if(aMinusB<=distance+1){
                    result = false;
                    break;
                }
            }else{
                if(aMinusB!=distance+1){
                    result = false;
                    break;
                }
            }

        }
        return result;
    }

}
