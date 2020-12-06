package implement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProgrammersthreeBInaryReverse {
    public static void main(String[] args) {
     new ProgrammersthreeBInaryReverse().solution(45);
    }
    public int solution(int n) {
        int degree = 3;
        Stack<Integer> stack = new Stack<>();
        while(n>=degree){
            stack.push(n%degree);
            n/=degree;
        }
        stack.push(n);
        int suffix = 1;
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop() * suffix;
            suffix*=degree;
        }
        System.out.println(sum);
        return sum;
    }
}
