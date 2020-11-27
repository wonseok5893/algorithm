package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class quickSorting {
    int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int e : arr) {
            System.out.print(e+" ");
        }
        System.out.println();
        quickSort(arr,0,arr.length-1);
        for (int e : arr) {
            System.out.print(e+" ");
        }
    }

    private static void quickSort(int[] arr,int start,int end) {
        if(start>=end)return;
        int pivot = start;
        int leftPos = start+1;
        int rightPos = end;
        while(leftPos<=rightPos){
            while(leftPos<=end&&arr[leftPos]<=arr[pivot])leftPos++;
            while(rightPos>start&&arr[rightPos]>=arr[pivot])rightPos--;
            if(leftPos>rightPos){
                int temp = arr[rightPos];
                arr[rightPos] = arr[pivot];
                arr[pivot] = temp;
            }else{
                int temp = arr[leftPos];
                arr[leftPos] = arr[rightPos];
                arr[rightPos] = temp;
            }
        }
        quickSort(arr,0,rightPos-1);
        quickSort(arr,rightPos+1,end);
    }
}
