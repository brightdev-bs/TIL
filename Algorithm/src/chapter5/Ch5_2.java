package chapter5;

import java.util.Scanner;
import java.util.Stack;

public class Ch5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.add(c);
            }
            else if(c == ')') {
                stack.pop();
            }
            else if(stack.size() != 0) {

            }else {
                answer += c;
            }
        }

        System.out.println(answer);
    }
}
