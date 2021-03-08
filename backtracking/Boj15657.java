package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj15657 {
    static int m;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(arr, new LinkedList<Integer>(),0,0);
        System.out.println(sb);
    }

    private static void backtracking(int[] arr, LinkedList<Integer> list,int start,int count) {
        if(count==m){
            for (Integer e : list) {
                sb.append(e + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <arr.length; i++) {
            list.addLast(arr[i]);
            backtracking(arr,list,i,count+1);
            list.removeLast();
        }
    }
}
