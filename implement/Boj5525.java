package implement;

import java.util.Scanner;

public class Boj5525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = sc.nextInt();
        String s = sc.next();

        StringBuilder sb = new StringBuilder();

        int ans = 0;

        int patternCnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i <len-1 ; i++) {
            if (chars[i - 1] == 'I' && chars[i] == 'O' && chars[i + 1] == 'I') {
                patternCnt++;
                if(patternCnt==n){
                    ans++;
                    patternCnt--;
                }
                i++;
            }else patternCnt = 0;
        }
        System.out.println(ans);
    }
}
