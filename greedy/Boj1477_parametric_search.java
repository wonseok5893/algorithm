package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1477_parametric_search {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int addCount = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(0);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            lists.add(Integer.parseInt(st.nextToken()));
        }
        lists.add(end);

        Collections.sort(lists);

        int start = 0;

        while(start<=end){
            int mid = (start+end)/2;
            System.out.println("mid: "+mid);
            if(possible(mid,addCount,lists)){
                   start = mid+1;
            System.out.println("start: "+start);
            }else{
                    end = mid-1;
            System.out.println("end: "+end);
            }
        }
        System.out.println(start);

    }

    private static boolean possible(int mid,int addCount,ArrayList<Integer>lists) {
        int count = 0;
        for (int i = 0; i < lists.size()-1; i++) {
            if(lists.get(i+1)-lists.get(i)<=mid)count++;
        }
        System.out.println("count: "+count);
        return count>addCount;
    }
}
