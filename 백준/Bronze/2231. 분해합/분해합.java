import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
    	int res = 0;
        for (int i=1; i<N; i++) {
        	int v = divSum(i);
        	if (v == N) {
        		res = i;
        		break;
        	}
        }
        
        System.out.println(res);
    }
    
    static int divSum(int n) {
        String nStr = String.valueOf(n);
        int sum = Integer.parseInt(nStr);
        for (int i=0; i<nStr.length(); i++) {
        	sum += nStr.charAt(i)-'0';
        }
        return sum;
    }
}