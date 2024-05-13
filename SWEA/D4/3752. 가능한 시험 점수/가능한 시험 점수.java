import java.io.*;
import java.util.*;
public class Solution {
	static Set<Integer> set = new HashSet<Integer>();
	static int[] score;
	static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	N = Integer.parseInt(br.readLine());
        	score = new int[N];        	
        	set.add(0);
        	        	
        	st = new StringTokenizer(br.readLine());
        	for (int n=0; n<N; n++) {	
        		score[n] = Integer.parseInt(st.nextToken());
        	}
        	
        	for (int n=0; n<N; n++) {	
        		addScore(score[n]);
        	}
        	
        	sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        	set.clear();
        }
        System.out.print(sb);
    }
    
    static void addScore(int num) {
    	Set<Integer> tempSet = new HashSet<Integer>();
    	tempSet.addAll(set);
    	Iterator<Integer> iterTemp = tempSet.iterator();
    	while (iterTemp.hasNext()) {
    		set.add(iterTemp.next()+num);
    	}
    }
}