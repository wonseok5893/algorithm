package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj20436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char[] zero = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] one = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] two = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        Map<Character, int[]> keyboard = new HashMap<>();

        for (int i = 0; i < zero.length; i++) {
            keyboard.put(zero[i], new int[]{i, 0});
        }
        for (int i = 0; i < one.length; i++) {
            keyboard.put(one[i], new int[]{i, 1});
        }
        for (int i = 0; i < two.length; i++) {
            keyboard.put(two[i], new int[]{i, 2});
        }

        int[] left;
        left = keyboard.get(st.nextToken().charAt(0));
        int[] right;
        right = keyboard.get(st.nextToken().charAt(0));

        String target = br.readLine();

        char[] targetChars = target.toCharArray();
        int time = 0;
        for (char targetChar : targetChars) {
            int[] target1 = keyboard.get(targetChar);
            if (!isMoum(targetChar,keyboard)) {
                int distanceRight = getDistance(target1, right);
                right = target1;
                time += distanceRight;
            }else {
                int distanceLeft = getDistance(target1, left);
                left = target1;
                time += distanceLeft;
            }
            time++;
        }
        System.out.println(time);
    }

    private static boolean isMoum(char targetChar, Map<Character, int[]> keyboard) {
        int[] target = keyboard.get(targetChar);
        if(target[0]<4)return true;
        if(target[0]==4){
            if(target[1]<2)return true;
        }
        return false;
    }

    private static int getDistance(int[] target, int[] hand) {
        return Math.abs(target[0] - hand[0]) + Math.abs(target[1] - hand[1]);
    }
}
