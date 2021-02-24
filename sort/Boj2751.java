package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2751 {
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr,0,arr.length-1);

        StringBuffer sb = new StringBuffer();
        for (int e : arr) {
            sb.append(e + "\n");
        }
        System.out.println(sb);
    }

    private static void mergeSort(int[] arr,int start,int end) {
        if(end-start <1)return;
            int mid = (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);

    }

    private static void merge(int[] arr, int start, int mid, int end) {

        int startAPos = start;
        int startBPos = mid+1;
        int pos = start;

        while(startAPos<=mid&&startBPos<=end){
            if(arr[startAPos]<=arr[startBPos]){
                temp[pos++] = arr[startAPos++];
            }else temp[pos++] = arr[startBPos++];
        }

        while(startAPos<=mid){
            temp[pos++] = arr[startAPos++];
        }
        while(startBPos<=end){
            temp[pos++] = arr[startBPos++];
        }

        for (int i = start; i <=end ; i++) {
            arr[i] = temp[i];
        }
    }
}
