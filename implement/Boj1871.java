package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] problems = new String[n];
        for (int i = 0; i < n; i++) {
             problems[i]=br.readLine();
        }
        String result = "";
        for (int i = 0; i < n; i++) {
            String str = problems[i];
            String[] strArr = str.split("-");
            int sum = 0;
            for (int j = 0; j < 3; j++) {
               int alpha = (int)str.charAt(j)-65;
                sum+= alpha*(int)Math.pow(26,2-j);
            }
            if(Math.abs(sum - Integer.parseInt(strArr[1]))<=100)
                result+="nice";
            else result+="not nice";
            result+="\n";
        }
        System.out.println(result);
    }
}
