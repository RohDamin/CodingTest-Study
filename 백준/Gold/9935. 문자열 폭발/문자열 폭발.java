import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String S = br.readLine();
        String exp = br.readLine(); 
        int explen = exp.length();
        
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<S.length(); i++) {
        	stack.push(S.charAt(i));
        	
        	if (stack.size()>=explen) {
        		boolean flag = true;
        		
        		for (int j=0; j<explen; j++) {
        			if (stack.get(stack.size()-explen+j) != exp.charAt(j)) {
        				flag = false;
        				break;
        			}
        		}
        		if (flag) {
        			for (int j=0; j<explen; j++) {
        				stack.pop();
        			}
        		}
        	}        	
        }
        
        String res = "";
        
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
        	for(Character c : stack) {
    			sb.append(c);
    		}
        	System.out.println(sb);
        }
    }
}