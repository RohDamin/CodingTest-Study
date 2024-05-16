import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i=0; i<T; i++) {
        	int num = Integer.parseInt(br.readLine());
        	sb.append(dp(num)).append("\n");
        }

        System.out.println(sb);
    }
    
    static int dp(int num) {
    	int res = 0;
    	
    	if (num == 1) return 1;
    	else if (num == 2) return 2;
    	else if (num == 3) return 4;
    	else {
    		res = dp(num-1) + dp(num-2) + dp(num-3);
    	}
    	return res;
    }
}