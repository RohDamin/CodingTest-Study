// 재귀
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int res = Fibonacci(N);
        System.out.println(res);
    }

    static int Fibonacci(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 1;

        return Fibonacci(n-1) +Fibonacci(n-2);
    }
}