package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj17433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String ans = "";
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[k];
            for (int j = 0; j < k; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int result = checkWonder(arr);
            if(result!=-1) ans += result;
            else ans += "INFINITY";
            ans += " ";
        }
        System.out.println(ans);
    }

    private static int checkWonder(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < arr.length-1; i++) {
            int diff = arr[i + 1] - arr[1];
            if(diff !=0) list.add(diff);
        }
        if(list.size()==0)return -1;

        int gcd = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            gcd = getGcd(gcd, list.get(i));
        }
        return gcd;
    }

    private static int getGcd(int a, Integer b) {
        while(b!=0){
            int temp =b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
