package dummy.chapter5;

import java.util.Scanner;
import java.util.Stack;

public class Ch5_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                else {
                    stack.pop();
                }
            }
        }
        if(stack.size() != 0) System.out.println("NO");
        else System.out.println("YES");
    }
}
