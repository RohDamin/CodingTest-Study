import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // today 저장
        int year = Integer.parseInt(today.substring(0,4));
        int month = Integer.parseInt(today.substring(5,7));
        int day = Integer.parseInt(today.substring(8,10));
        
        // terms 저장
        HashMap<Character, Integer> termMap = new  HashMap<Character, Integer>();
        for (int i = 0; i<terms.length; i++) {
            StringTokenizer st = new StringTokenizer(terms[i]);
            char term = st.nextToken().charAt(0);
            int period = Integer.parseInt(st.nextToken());
            termMap.put(term, period);
        }
        
        // privacies 처리
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i<privacies.length; i++) {
            int pYear = Integer.parseInt(privacies[i].substring(0,4));
            int pMonth = Integer.parseInt(privacies[i].substring(5,7));
            int pDay = Integer.parseInt(privacies[i].substring(8,10));
            
            char pTerm = privacies[i].charAt(11);
            
            int period = termMap.get(pTerm);
            pYear += period/12;
            pMonth += period%12;
            if (pMonth>12) {
                pMonth -= 12;
                pYear++;
            }
            
            //System.out.printf("period: %d   %d.%d.%d\n", period, pYear, pMonth, pDay);
            
            if (pYear<year) ans.add(i+1);
            else if (pYear==year && pMonth<month) ans.add(i+1);
            else if (pYear==year && pMonth==month && pDay<=day) ans.add(i+1);
        }
        
        for (int i = 0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        
        int[] ansArr = ans.stream()
            .mapToInt(i -> i)
            .toArray();
        Arrays.sort(ansArr);
        
        return ansArr;
    }
}