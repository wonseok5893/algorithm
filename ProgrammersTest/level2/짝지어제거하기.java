package ProgrammersTest.level2;

import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {

    }
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char now = chars[i];
            stack.push(now);
            while(stack.size()>=2){
                if(checkStack(stack))continue;
                else break;
            }
        }
        return stack.size()==0?1:0;
    }

    private boolean checkStack(Stack<Character> stack) {
        char peek = stack.pop();
        char peek2 = stack.peek();
        if(peek==peek2) {
            stack.pop();
            return true;
        }
        else {
            stack.push(peek);
            return false;
        }
    }
}
