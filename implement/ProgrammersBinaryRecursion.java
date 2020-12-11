package implement;

public class ProgrammersBinaryRecursion {
    public static void main(String[] args) {

    }
    static int transCount,count0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        //s->count1의 개수 이진법
        while(!s.equals("1")){
            int count1 = 0;
            for (String e : s.split("")) {
                if(e.equals("1")) count1++;
            }
            count0+= s.length()-count1;
            s = Integer.toBinaryString(count1);
            transCount++;
        }
        answer[0] = transCount;
        answer[1] = count0;
        return answer;
    }
}
