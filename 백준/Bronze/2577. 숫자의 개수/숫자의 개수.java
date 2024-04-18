// 배열
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int mul = A * B * C;
        String s = String.valueOf(mul);
        int[] arr = new int[10];

        for (int i=0; i<s.length(); i++) {
            int v = (s.charAt(i)-'0')%10;
            arr[v]++;
        }

        for (int i=0; i<10; i++) {
            System.out.println(arr[i]);
        }
    }
}