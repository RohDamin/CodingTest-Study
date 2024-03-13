import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            boolean check = true;
            if (s.equals("0")) break;

            int []arr = new int[s.length()];

            for (int i = 0; i<s.length(); i++) {
                arr[i] = s.charAt(i);
            }
            for (int i = 0; i<s.length()/2; i++) {
                if (arr[i] != arr[s.length() - i - 1]) {
                    check = false;
                    break;
                }
            }

            if (check) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
