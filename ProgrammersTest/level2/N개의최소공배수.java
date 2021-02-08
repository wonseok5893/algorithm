package ProgrammersTest.level2;

import java.util.Arrays;

public class N개의최소공배수 {
    public static void main(String[] args) {
        new N개의최소공배수().solution(new int[]{2,6,7,8});
    }
    public int solution(int[] arr) {
        int lca = 1;
        for (int e : arr) {
            lca = getLca(lca,e);
        }

        return lca;
    }

    private int getGcd(int a, int b) {
        if(a%b==0) return b;
        return getGcd(b,a%b);
    }
    private int getLca(int a, int b){
        return (a*b)/getGcd(a,b);
    }







    public int solution1(int[] arr) {
        int gcd = 1;
        int max = Arrays.stream(arr).max().getAsInt();
        for (int i = max; i >0 ; i--) {
            boolean result = true;
            for (int e : arr) {
                if(e%i!=0){
                    result = false;
                    break;
                }
            }
            if(result){
                gcd = i;
                break;
            }
        }
        int ans = gcd;
        for (int e : arr) {
            ans = ans*(e/gcd);
        }

        return ans;
    }
}
