package com.wonseok.combination;

import java.util.ArrayList;
import java.util.List;

public class PartialParts {
    public int result;

    public static void main(String[] args) {

        List<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("3");

        List<String> result = new ArrayList<>();
        combination(arr, result, 0, arr.size(), 2);

    }

    private static void combination(List<String> arr, List<String> result, int index, int n, int r) {

        if (r == 0) {
            System.out.println(result.toString());
            return;
        }

        for (int i = index; i < n; i++) {

            result.add(arr.get(i));
            combination(arr, result, i + 1, n, r - 1);
            result.remove(result.size() - 1);
        }
    }
}
