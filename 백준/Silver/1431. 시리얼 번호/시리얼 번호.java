import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());        
        String[] snArr = new String[N];

        for (int i=0; i<N; i++) {
        	snArr[i] = br.readLine();  
        }
        
        Arrays.sort(snArr, new Comparator<String>() {
        	@Override
        	public int compare(String s1, String s2) {
        		if (s1.length() > s2.length()) return 1;
        		else if (s1.length() < s2.length()) return -1;
        		else {
        			int sum1 = 0;
        			int sum2 = 0;
        			for (int i=0; i<s1.length(); i++) {
        				if (Character.isDigit(s1.charAt(i))) sum1+=s1.charAt(i)-'0';
        				if (Character.isDigit(s2.charAt(i))) sum2+=s2.charAt(i)-'0';
        			}
        			if (sum1>sum2) return 1;
    				else if (sum1<sum2) return -1;
    				else {
    					return s1.compareTo(s2);
    				}
        		}
        	}
        });
        
        
        for (int i=0; i<N; i++) {
        	sb.append(snArr[i]).append("\n");
        }
        
        System.out.println(sb);
    }
}