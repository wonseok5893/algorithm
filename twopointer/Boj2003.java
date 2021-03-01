package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0, end = 0;
        int ans = 0;
        int sum = 0;

        while(start<=end){
            if(sum>=x) {
                if(sum==x) ans++;
                sum -= arr[start++];
            }
            else if(end==n)break;
            else sum+=arr[end++];
        }
        System.out.println(ans);
    }
}
