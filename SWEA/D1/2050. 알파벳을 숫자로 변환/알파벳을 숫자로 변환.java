import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String str = br.readLine();
        
        for (int i=0; i<str.length(); i++) {
        	int v = str.charAt(i)-'0'-16;
        	sb.append(v).append(" ");
        }
        System.out.print(sb);
    }
}