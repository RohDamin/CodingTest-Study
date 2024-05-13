// 문자열
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int cnt = N;
       
        for (int i=0; i<N; i++) {
        	String s = br.readLine();
        	int[] alp = new int[27];
        	
        	for (int idx=1; idx<=s.length(); idx++) {
        		int v = s.charAt(idx-1)-'0'-48;
        		if (alp[v] == 0) {
        			alp[v] = idx;
        		} else {
        			if (alp[v]+1 == idx) {
        				alp[v] = idx;
        			}
        			else {
        				cnt--;
            			break;
        			} 
        		}	
        	}
        }
        System.out.print(cnt);
    }
}