package kakao.level2;

import java.util.ArrayList;

public class Problem5 {
    public static void main(String[] args) {

    }
    public int solution(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        double ans = 0;
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        str1 = str1.trim();
        str1 = str1.toLowerCase();
        str2 = str2.trim();
        str2 = str2.toLowerCase();

        for(int i=0;i<len1-1;i++){
            String a = str1.substring(i,i+2);
            if(a.charAt(0)-'a'>=0&&a.charAt(0)-'a'<=26
                    &&a.charAt(1)-'a'>=0&&a.charAt(1)-'a'<=26)
                arr1.add(a);
        }

        for(int i=0;i<len2-1;i++){
            String b = str2.substring(i,i+2);
            if(b.charAt(0)-'a'>=0&&b.charAt(0)-'a'<=26
                    &&b.charAt(1)-'a'>=0&&b.charAt(1)-'a'<=26)
                arr2.add(b);
        }

        int arr1Len = arr1.size();
        int arr2Len = arr2.size();
        int count=0;

        for(int i=0;i<arr1.size();i++){
            String a = arr1.get(i);
            for(int j = 0;j<arr2.size();j++){
                String b = arr2.get(j);
                if(a.equals(b)){
                    count++;
                    arr2.remove(b);
                    break;
                }
            }
        }
        if(count==0) {
            if(str1.equals(str2))ans = 1;
            else ans = 0;
        }
        else
            ans = (double)count/(arr1Len+arr2Len-count);
        int res = (int)Math.floor(ans*65536);
        return res;
    }
}
