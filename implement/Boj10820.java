package implement;

import java.io.*;


public class Boj10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while (true) {
            String str = br.readLine();
            if(str==null)break;
            int[] ans = new int[4];
            for (char c : str.toCharArray()) {
                if (Character.isLowerCase(c)) ans[0]++;
                else if (Character.isUpperCase(c)) ans[1]++;
                else if (Character.isDigit(c)) ans[2]++;
                else if (Character.isWhitespace(c)) ans[3]++;
            }
            for (int e : ans) {
                sb.append(e + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


}
