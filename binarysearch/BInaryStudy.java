package binarysearch;

import java.util.Arrays;

public class BInaryStudy {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,12,12,12,13,13, 12, 12, 12,  12, 12,3,4,5,14};
        Arrays.sort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println(binarySearch(arr, 14));
        System.out.println(binaryUpperbound(arr, 13));
        System.out.println(binaryLowerbound(arr, 13));
    }
    // upperbound
    private static int binaryUpperbound(int[] arr, int find) {
        int start = 0;
        int end = arr.length - 1;
        int answer = -1;

        while (start < end) {
            int mid = (start+end)/2;
            if (arr[mid]<=find){
                if(arr[mid]==find) answer = mid;
                start = mid+1;
            }else if(arr[mid]>find){
                end = mid;
            }
        }
        //경계값 검사 한번더 해줘야함
        if(arr[arr.length-1]==find) answer = arr.length-1;
        return answer;
    }
    //lowerbound
    private static int binaryLowerbound(int[] arr, int find) {
        int start = 0;
        int end = arr.length - 1;
        int answer = -1;

        while (start < end) {
            int mid = (start+end)/2;
            if (arr[mid]<find){
                start = mid+1;
            }else if(arr[mid]>=find){
                if(arr[mid]==find) answer = mid;
                end = mid;
            }
        }

        if(answer==-1&&arr[arr.length-1]==find) answer = arr.length-1;
        return answer;
    }
    //중복값이 존재하는지 여부와 상관없이 값하나만 찾을때 사용
    private static int binarySearch(int[] arr, int find) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] == find) return mid;
            if (arr[mid] > find) end = mid;
            else if (arr[mid] < find) {
                start = mid + 1;
            }
        }
        if(arr[arr.length-1]==find) return arr.length-1;
        return -1;
    }
    //
}
