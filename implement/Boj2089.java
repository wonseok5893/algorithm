package implement;

import java.util.Scanner;
import java.util.Stack;

public class Boj2089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        if(n==0) stack.push(0);
        while (n != 0) {
            stack.push(n % -2);
            if(n>0) n /= -2;
            else n = (n-1)/-2;
        }
        while (!stack.isEmpty()) {
            System.out.print(Math.abs(stack.pop()));
        }
    }
}
