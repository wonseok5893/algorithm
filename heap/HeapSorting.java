package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HeapSorting {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[]{6,3,5,1,7,2,4,8};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int e : arr) {
            list.add(e);
        }
        heapSort(list);
    }

    private static void heapSort(List<Integer> list) {
        int size = list.size()-1;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            heapify(list);
            result[i] = deleteMaxPriority(list);
        }
        for (int e : result) {
            System.out.print("정렬된"+e+" ");
        }
    }

    private static int deleteMaxPriority(List<Integer> list) {
        return list.remove(1);
    }

    private static void heapify(List<Integer> list) {
        // 1 3 2 4 5
        int idx = (list.size() - 1) / 2;
        for (int i = idx; i > 0; i--) {
            int root = list.get(i);
            if (i == idx && list.size() % 2 != 0) {
                int leftNode = list.get(i * 2);
                if (leftNode > root) {
                    list.set(i, leftNode);
                    list.set(i * 2, root);
                }
                continue;
            }
            int leftNode = list.get(i * 2);
            int rightNode = list.get(i * 2 + 1);
            if (leftNode > root) {
                list.set(i, leftNode);
                list.set(i * 2, root);
            }
            root = list.get(i);
            if (rightNode > root) {
                list.set(i, rightNode);
                list.set(i * 2 + 1, root);
            }
        }
        for (Integer e : list) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
}
