// 문자열
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str = br.readLine();
        String res = "";
        
        for (char c : str.toCharArray()) {
        	if (Character.isLowerCase(c)) res += Character.toUpperCase(c);
        	else res += Character.toLowerCase(c);
        }
        System.out.print(res);
    }
}