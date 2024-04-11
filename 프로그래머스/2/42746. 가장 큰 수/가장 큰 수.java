import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) { 
        String answer = "";
        
        int numLen = numbers.length;
        String[] strArr = new String[numLen];
        
        for (int i = 0; i<numLen; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strArr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if (strArr[0].equals("0")) return "0";
        
        for (int i = 0; i<numLen; i++) {
            answer += strArr[i];
        }
        
        return answer;
    }
}