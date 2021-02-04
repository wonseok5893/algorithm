package sort;

import java.util.Arrays;

public class 가장큰수 {
    public static void main(String[] args) {
        new 가장큰수().solution(new int[]{0,0,0,0});
        System.out.println(ans);
    }
    static String ans;
    public String solution(int[] numbers) {
        Integer[] number = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(number, (a, e) -> {
            String aStr = String.valueOf(a);
            String eStr = String.valueOf(e);
            return (eStr+aStr).compareTo(aStr+eStr);
        });
        ans = "";
        if(Arrays.stream(number).allMatch(e->e==0))return "0";
        Arrays.stream(number).forEach(e->ans+=e);
        return ans;
    }
}
