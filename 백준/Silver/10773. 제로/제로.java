import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) stack.pop();
            else stack.add(num);
        }

        int sum = 0;
        int size = stack.size();
        for(int i=0; i<size; i++) {
            sum+=stack.pop();
        }

        System.out.println(sum);
    }
}