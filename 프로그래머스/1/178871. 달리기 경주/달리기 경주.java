import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        int numOfPlayers = players.length;
        Map<String, Integer> rankings = new HashMap<>();
        
        for (int i = 0; i<numOfPlayers; i++) rankings.put(players[i], i);
        
        
        for (String player : callings) {
            int playerRanking = rankings.get(player);
            String frontPlayer = players[playerRanking-1];
            
            rankings.replace(frontPlayer, playerRanking);
            players[playerRanking] = frontPlayer;
            
            rankings.replace(player, playerRanking-1);
            players[playerRanking-1] = player;
        }
        
        return players;
    }
}