package standard;

import java.util.*;
import java.util.stream.Collectors;

public class JavaArrayListRemove {
    public static void main(String[] args) {
        //method 1 추상리스트
        Integer[]arr = new Integer[]{1,2,3,4};
        List<Integer> list = Arrays.asList(arr);




        //method 2
        int[] arr1 = new int[]{1,2,3,4};
        ArrayList<Integer> list1 = new ArrayList<>();
        Arrays.stream(arr1).forEach((e)->list1.add(e));

        //list.remove(1) -> idx
        list1.remove(1);
        for (Integer e : list1) {
            System.out.println(e);
        }
        //list.remove(new Integer(1)) -> Object o
        list1.remove(new Integer(1));

        for (Integer e : list1) {
            System.out.println(e);
        }
        //but set
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.remove(2);
        //set은 idx가 없음, Object o reference type 값을 제거
    }
}
