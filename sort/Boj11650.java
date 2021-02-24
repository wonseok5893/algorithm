package sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Location[] arr= new Location[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            arr[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (Location loc : arr) {
            sb.append(loc.x + " " + loc.y + "\n");
        }
        System.out.println(sb);
    }

    private static class Location implements Comparable<Location>{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location o) {
            if(x>o.x)return 1;
            else if(x==o.x){
                if(y>o.y)return 1;
                else if(y==o.y)return 0;
                return -1;
            }
            return -1;
        }
    }
}
