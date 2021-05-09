package kakao2021internship;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Num1 {
    public static void main(String[] args) {

    }
    static Map<String, Integer> map = new HashMap<>();
    public int solution(String s) {
        setMap();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int startPos = 0;
        int endPos = startPos+1;
        while (startPos < len) {
            if(Character.isDigit(s.charAt(startPos))) {
                sb.append(s.charAt(startPos));
                startPos++;
                endPos = startPos+1;
            }
            else{
                while(map.get(s.substring(startPos,endPos))==null){
                    endPos++;
                }
                sb.append(map.get(s.substring(startPos,endPos)));
                startPos = endPos;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private void setMap() {
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
    }
}
