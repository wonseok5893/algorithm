package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Boj16719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] arr = str.toCharArray();

        String res = "";
        ArrayList<Character> lists = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            lists.add(arr[i]);
        }
        boolean[] checked = new boolean[arr.length];
        int count = 0;
        while (count<arr.length) {
            // 뽑으면돼 제일 사전순으로
            String min = "ZZZZZZZZZZ";
            int pos = -1;
            char c = 'a';
            for (int i = 0; i < arr.length; i++) {
                if(checked[i]) continue;
                checked[i] = true;
                String temp = "";
                for (int j = 0; j < arr.length; j++) {
                    if(checked[j]) temp += arr[j];
                }
                if(min.compareTo(temp)>0){
                    min = temp;
                    pos = i;
                }
                checked[i] = false;
            }
            checked[pos] = true;
            String ans = "";
            for (int j = 0; j < arr.length; j++) {
                if(checked[j]) ans += arr[j];
            }
            System.out.println(ans);
            count++;
        }

    }
}
/// B A C
/// A B C