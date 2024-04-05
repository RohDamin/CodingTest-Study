import java.util.*;

class Solution {
    public int solution(String t, String p) {
    
        int answer = 0;    
        int tLen = t.length();
        int pLen = p.length();
        long pNum = Long.parseLong(p);
        
        for (int i = 0; i<tLen-pLen+1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j<pLen; j++) sb.append(t.charAt(i+j));
            Long num = Long.parseLong(sb.toString());
            if (num<=pNum) answer++;
        }
        return answer;
    }
}