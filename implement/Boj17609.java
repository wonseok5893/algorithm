package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int res = 0;
            if(isPalindrome(str))res= 0;
            else if(isPseudoPalindrome(str))res=1;
            else res =2;
            System.out.println(res);
        }
    }

    private static boolean isPalindrome(String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();
        if (reverseStr.equals(str)) return true;
        return false;
    }

    private static boolean isPseudoPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end))
                return isPalindrome(str.substring(start, end)) || isPalindrome(str.substring(start + 1, end + 1));
            start++;
            end--;
        }
        return false;
    }

}
