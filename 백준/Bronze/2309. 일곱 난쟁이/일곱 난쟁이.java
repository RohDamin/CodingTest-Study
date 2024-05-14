// 완전탐색
import java.io.*;
import java.util.*;
public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //int N = Integer.parseInt(br.readLine());
        
        int[] num = new int[9];
        int sum = 0;
        for (int i=0; i<9; i++) {
        	num[i] = Integer.parseInt(br.readLine());
        	sum += num[i];
        }
        
        int ni=-1, nj=-1;
        boolean isfinish = false;
        for (int i=0; i<8; i++) {
        	for (int j=i+1; j<9; j++) {
        		if (num[i] + num[j] == sum - 100) {
        			ni = i;
        			nj = j;
        			isfinish = true;
        			break;
        		}
        	}
        	if(isfinish) break;
        }
        
        ArrayList<Integer> seven = new ArrayList<>();
        for (int i=0; i<9; i++) {
        	if (i == ni || i == nj) {
        		continue;
        	}
            seven.add(num[i]);
        }
        
        Collections.sort(seven);
        
        for (int i=0; i<7; i++) {
        	System.out.println(seven.get(i));
        } 
    }
}