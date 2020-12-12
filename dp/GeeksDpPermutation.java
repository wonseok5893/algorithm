package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeeksDpPermutation {
    static String printStr = "";
    static int[]visited = new int[26];
    public static void main (String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String s = br.readLine();
            permutation(s,0,s.length()-1);
        }
    }
    public static void permutation(String s, int startIdx,int endIdx){
        if(startIdx == endIdx){
            System.out.print(printStr);
            visited = new int[26];
            printStr = "";
            return;
        }
        for(int i=0;i<s.length();i++){
            if(visited[s.charAt(i)-'A']==1)continue;
            printStr += s.charAt(i);
            visited[(int)(s.charAt(i)-'A')]=1;
            permutation(s,startIdx+1,endIdx);
            visited[(int)(s.charAt(i)-'A')]=0;
            if(printStr.length()!=0)
            printStr = printStr.substring(0,printStr.length()-1);
        }
    }
}
