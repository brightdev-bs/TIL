package chapter5;

import java.util.Scanner;
import java.util.Stack;

public class Ch5_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            else {
                if(s.charAt(i-1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
