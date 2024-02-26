import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("push")) {
                int v = Integer.parseInt(st.nextToken());
                stack.push(v);
            } else if (s.equals("top")) {
                if (!stack.isEmpty()) {
                    int v = stack.pop();
                    System.out.println(v);
                    stack.add(v);
                }
                else System.out.println(-1);
            } else if (s.equals("size")) {
                System.out.println(stack.size());
            } else if (s.equals("empty")) {
                if (stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (s.equals("pop")) {
                if (!stack.isEmpty()) System.out.println(stack.pop());
                else System.out.println(-1);
            }
        }
    }
}