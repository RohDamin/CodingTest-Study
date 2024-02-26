import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i<N; i++) {

            String s = br.readLine();
            for (int j = 0; j<s.length(); j++) {
                if (s.charAt(j) == '(') stack.add(s.charAt(j)); // 여는 괄호인 경우 그냥 저장
                else { // 닫는 괄호인 경우
                    if(!stack.isEmpty() && stack.peek() == '(' ) stack.pop(); // 현재 스택의 top이 여는 괄호인 경우 pop
                    else stack.add(s.charAt(j)); // 아닌 경우 그냥 저장
                }
                // 여는 괄호는 스택의 왼쪽에, 닫는 괄호는 스택의 오른쪽에 저장됨
            }

            if (stack.isEmpty()) System.out.println("YES"); // 스택이 비어있는 경우 올바른 문자열
            else System.out.println("NO"); // 스택이 남아있는 경우 올바른 문자열 아님

            stack.clear(); // 스택 초기화
        }
    }
}