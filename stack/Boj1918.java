package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Boj1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('*',2);
        map.put('/',2);
        map.put('+',1);
        map.put('-',1);
        map.put('(',0);

        for (int i = 0; i < arr.length; i++) {
            if(Character.isLetter(arr[i])) sb.append(arr[i]);
            else{
                switch (arr[i]){
                    case '*':
                    case '/':
                    case '+':
                    case '-':{
                        if(!stack.isEmpty()) {
                            if (map.get(stack.peek()) < map.get(arr[i]))
                                stack.push(arr[i]);
                            else {
                                while(!stack.isEmpty()&&map.get(stack.peek())>=map.get(arr[i])){
                                    sb.append(stack.pop());
                                }
                                stack.push(arr[i]);
                            }
                        }
                        else stack.push(arr[i]);
                        break;
                    }
                    case '(':{
                        stack.push('(');
                        break;
                    }
                    case ')':{
                        while(stack.peek()!='('){
                            sb.append(stack.pop()) ;
                        }
                        stack.pop();
                        break;
                    }
                }
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
}
