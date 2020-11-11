package combination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Programmers42839 {
    public static void main(String[] args) {
        System.out.println(new Programmers42839().solution("17"));
    }

    static int[] isUsed;
    static Set<Integer> set;

    public int solution(String numbers) {
        int[] arr = Arrays.stream(numbers.split(""))
                .mapToInt(Integer::parseInt).toArray();
        isUsed = new int[arr.length];
        set = new HashSet<>();
        for (int i = 1; i <= arr.length; i++) {
            permutation(arr, "", i, 0);
        }
        int count = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (checkPrime(iterator.next()))
                count++;
        }
        return count;
    }

    private boolean checkPrime(Integer next) {
        boolean result = true;
        for (int i = 2; i < next; i++) {
            if (next % i == 0) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        if (next <= 1) result = false;
        return result;
    }


    private void permutation(int[] arr, String result, int count, int start) {
        if (start == count) {
            System.out.println(result);
            set.add(Integer.valueOf(result));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (isUsed[i] != 0) continue;
            isUsed[i] = 1;
            result += arr[i];
            permutation(arr, result, count, start + 1);
            isUsed[i] = 0;
            if (result.length() > 0)
                result = result.substring(0, result.length() - 1);
        }
    }
}
