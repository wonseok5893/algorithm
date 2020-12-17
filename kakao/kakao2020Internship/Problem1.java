package kakao.kakao2020Internship;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    //키패드 누르기
    //https://programmers.co.kr/learn/courses/30/lessons/67256
    // 엄지손가락 상하좌우 1씩
    // 1 4 7 왼손 엄지
    // 3 6 9 오른손
    // 2 5 8 0 현재 키패디의 위치에서 더가까운 엄지손가락 을사용
    // 거리가 같다면 오른손 -> 오른손 왼손 -> 왼손
    public static void main(String[] args) {
        solution(new int[]{1, 2,3,4,5,6,7,8,9,0}, "right");
    }

    public static String solution(int[] numbers, String hand) {
        Map<Integer, int[]> phone = new HashMap<>();
        int y = 0;
        int x = 0;
        for (int i = 1; i <= 9; i++) {
            phone.put(i, new int[]{x, y});
            x++;
            if (x == 3) {
                x = 0;
                y++;
            }
        }
        phone.put(0, new int[]{1, 3});

        String result = "";
        int[] nowLeftPos = new int[]{0,3};
        int[] nowRightPos = new int[]{2, 3};
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int nowNumber = numbers[i];
            if (nowNumber == 1 || nowNumber == 4 || nowNumber == 7) {
                result += "L";
                nowLeftPos = phone.get(nowNumber);
            }
            if (nowNumber == 3 || nowNumber == 6 || nowNumber == 9) {
                result += "R";
                nowRightPos = phone.get(nowNumber);
            }
            if (nowNumber == 2 || nowNumber == 5 || nowNumber == 8 || nowNumber == 0){
                int[] nextPos = phone.get(nowNumber);
                int leftDistance = getDistance(nextPos, nowLeftPos);
                int rightDistance = getDistance(nextPos, nowRightPos);
                if(leftDistance<rightDistance){
                    result += "L";
                    nowLeftPos = nextPos;
                }else if(leftDistance==rightDistance){
                    if(hand.equals("right")){
                        result += "R";
                        nowRightPos = nextPos;
                    }else{
                        result += "L";
                        nowLeftPos = nextPos;
                    }
                }else{
                    result += "R";
                    nowRightPos = nextPos;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    private static int getDistance(int[] nowPos, int[] nowRightPos) {
        int sum = 0;
        sum+=nowPos[0]-nowRightPos[0]>=0?nowPos[0]-nowRightPos[0]:
                nowRightPos[0]-nowPos[0];
        sum+=nowPos[1]-nowRightPos[1]>=0?nowPos[1]-nowRightPos[1]:
                nowRightPos[1]-nowPos[1];
        return sum;
    }
}
