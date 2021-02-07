package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장큰수 {
    public static void main(String[] args) {
        String solution = new 가장큰수().solution(new int[]{2, 11, 23, 123});
        System.out.println(solution);
    }

    public String solution(int[] numbers) {
        Integer[] number = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(number, (a, e) -> {
            String aStr = String.valueOf(a);
            String eStr = String.valueOf(e);
            return (eStr+aStr).compareTo(aStr+eStr);
        });

        if(Arrays.stream(number).allMatch(e->e==0))return "0";
        return Arrays.stream(number).map(String::valueOf).collect(Collectors.joining(""));


    }
}
