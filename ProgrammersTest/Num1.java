package com.wonseok.ProgrammersTest;

public class Num1 {
    public static void main(String[] args) {

    }
    public int solution(int[] s1, int[] s2) {
       //끝에 0으로 끝나는지
        int ans = 0;

        int[] a = new int[6];
        int[] b = new int[6];
        int posA = 0;
        int posB = 0;
        for (int i = 0; i < 7; i++) {
            if(s1[i]!=0) a[posA++] = s1[i];
            if(s2[i]!=0) b[posB++] = s2[i];
        }
        for (int i = 0; i < 6; i++) {
            if(a[i]!=b[i])
                ans+=2;
        }
        if(ans!=0&&s2[6]!=0){
            ans++;
        }
        return ans;
    }
}
