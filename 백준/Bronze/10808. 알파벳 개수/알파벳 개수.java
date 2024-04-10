import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i<str.length(); i++) {
            ++arr[str.charAt(i)-'0'-49];
        }

        for (int i = 0; i<26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}