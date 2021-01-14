package com.wonseok.sort;

import java.util.Arrays;
import java.util.Collections;

public class TestSorting {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        Arrays.sort(arr,((o1, o2) -> o2-o1));
    }
}
