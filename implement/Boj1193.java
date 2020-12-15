package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int start = 1;
        int sum = start;
        while(sum<X){
            start++;
            sum+= start;
        }

        int diff = sum-X;
        if(start%2==0){
            int y = start-diff;
            int x = 1+diff;
            System.out.println(y+"/"+x);
        }else{
            int y = 1+diff;
            int x = start-diff;
            System.out.println(y+"/"+x);
        }
    }
}
