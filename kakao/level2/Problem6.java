package com.wonseok.kakao.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static void main(String[] args) {
        System.out.println( new Problem6().solution(new int[]{70,80,50},100));
    }
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        ArrayList<Integer> list = new ArrayList<>();
        for (int person : people) {
            list.add(person);
        }
        int count = 0;
        while (list.size()>=2) {
            int startPos = list.size()-1;
            int possibleMax = limit-list.get(startPos);
            int possublePos = binarySearch(list, possibleMax);
            if(possublePos!=-1){
                list.remove(startPos);
                list.remove(possublePos-1);
                count++;
            }else{
                list.remove(startPos);
                count++;
            }
        }
        count+=list.size();
        return count;
    }
    private int binarySearch(ArrayList<Integer> list, int n) {
        int start = 0;
        int end = list.size() - 1;
        int mid = 0;
        int pos = -1;
        while (start <= end) {
            mid = (start + end) / 2;
                if (list.get(mid)>n) {
                    end = mid - 1;

                }
                else {
                    start = mid + 1;
                    pos = mid;
                }
        }
        return pos;
    }
}
