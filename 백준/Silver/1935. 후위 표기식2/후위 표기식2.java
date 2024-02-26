// 스택(Stack)
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int []arr = new int [101];
        String str = br.readLine();

        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                Double v = (double) arr[str.charAt(i) - 65];
                stack.push(v); // 알파벳인 경우 push
            } else {
                Double a = stack.pop();
                Double b = stack.pop();

                if (str.charAt(i) == '*')  stack.push(b*a);
                else if (str.charAt(i) == '/') stack.push(b/a);
                else if (str.charAt(i) == '+') stack.push(b+a);
                else if (str.charAt(i) == '-') stack.push(b-a);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}