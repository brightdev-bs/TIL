package chapter5;

import java.util.Scanner;
import java.util.Stack;

public class Ch5_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) stack.push((int)c - '0');
            else {
                int b = stack.pop();
                int a = stack.pop();
                if(c == '+') stack.push( a + b);
                else if(c == '-') stack.push(a - b);
                else if(c == '*') stack.push(a * b);
                else if(c == '/') stack.push(a / b);
            }
        }

        System.out.print(stack.pop());
    }
}
