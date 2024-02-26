// 스택(Stack)
import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        for (int i = 0; i<str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') { // 알파벳을 만나면 바로 출력
                System.out.print(str.charAt(i));
            } else if(str.charAt(i) == '*' || str.charAt(i) == '/') {
                if (stack.empty() || stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') stack.push(str.charAt(i));
                else {
                    while (!stack.empty()) {
                        if (stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') break;
                        System.out.print(stack.pop());
                    }
                    stack.push(str.charAt(i));
                }
            } else if(str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (stack.empty() || stack.peek() == '(') stack.push(str.charAt(i));
                else {
                    while (!stack.empty()) {
                        if (stack.peek() == '(') break;
                        System.out.print(stack.pop());
                    }
                    stack.push(str.charAt(i));
                }
            } else if(str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if(str.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    System.out.print(stack.pop());
                }
                stack.pop(); // 스택 top의 '(' 제거
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}