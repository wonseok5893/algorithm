package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj16719_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] arr = str.toCharArray();
        boolean[] checked = new boolean[arr.length];
        // arr : B      A      C
        //     : false false false
        String res = "";
        int count = 0;
        while(count<arr.length) {
            int pos = -1;
            String min = "ZZZZZZZZZZZZZZZZZZZZZZZZZZ";
            // 0~arr.length-1
            for (int i = 0; i < arr.length; i++) {
                //체크를 했으면
                if(checked[i]) continue;
                //체크를 하고
                checked[i] = true;
                //체크한 문자열을 구해보는것
                String temp = "";

                for (int j = 0; j < arr.length; j++) {
                    if (checked[j]) temp += arr[j];
                }

                if (min.compareTo(temp) > 0) {
                    min = temp;
                    pos = i;
                }
                checked[i] = false;
            }
            checked[pos] = true;

            String ans = "";
            for (int i = 0; i < arr.length; i++) {
                if(checked[i]) ans += arr[i];
            }
            System.out.println(ans);
            count++;
        }
    }
}
