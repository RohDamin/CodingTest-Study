import java.util.*;
import java.io.*;

public class Solution {
 public static void main(String[] args) throws IOException {
 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
 	StringTokenizer st;
        
    int T = Integer.parseInt(br.readLine());
    
    for (int t=0; t<T; t++) {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = -1;
        
        // 배열에 값 저장
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
        
    	for (int i=0; i<N-1; i++) {
    		for (int j=i+1; j<N; j++) {
    			
        		int value = arr[i]*arr[j];
        		String vstr = String.valueOf(value);
        		boolean isCorrect = true;
        		
        		for (int s=0; s<vstr.length()-1; s++) {
        			// 단조가 아닌 경우
        			if (vstr.charAt(s) > vstr.charAt(s+1)) {
        				isCorrect = false;
        			}
        		}	
        		if (isCorrect) max = Math.max(max, value);
        		
        	}
    	}
    	
    	sb.append("#").append(t+1).append(" ").append(max).append("\n");

    }
    System.out.print(sb);
  }
}