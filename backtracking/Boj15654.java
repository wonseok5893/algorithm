package com.wonseok.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Boj15654 {
    static int[]visited = new int[10001];
    static String str="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int[] info = new int[2];
        int pos = 0;
        while(st.hasMoreTokens()){
            info[pos++] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[info[0]];
        for (int i = 0; i < info[0]; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //////
        Arrays.sort(arr);
        backtacking(arr,info[1]);

    }

    private static void backtacking(int[] arr, int count) {
        if(count==0){
            System.out.println(str);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(visited[arr[i]]==1)continue;
            visited[arr[i]]=1;
            str+=arr[i]+" ";
            backtacking(arr,count-1);
            visited[arr[i]]=0;
            String[] strArr = str.split(" ");
            str = "";
            for (int j = 0; j < strArr.length-1; j++) {
                str+=strArr[j]+" ";
            }
        }
    }

}
