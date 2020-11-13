package ohtu;

public class TennisGame {
    
    private int p1_points = 0;
    private int p2_points = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            p1_points += 1;
        else
            p2_points += 1;
    }
    
    
    public String evenScore(int points) {
        
        switch (points)
            {
                case 0:
                        return "Love-All";
                case 1:
                        return "Fifteen-All";
                case 2:
                        return "Thirty-All";
                case 3:
                        return "Forty-All";
                default:
                        return "Deuce";
                
            }
        
    }
    
    public String getEndGamePoints(int p1_points, int p2_points) {
        String score = "";
        int minusResult = p1_points-p2_points;
        if (minusResult==1) score ="Advantage " + player1Name;
            else if (minusResult ==-1) score ="Advantage " + player2Name;
            else if (minusResult>=2) score = "Win for " + player1Name;
            else score ="Win for " + player2Name;
        
        return score;
    }
    
    public String getNormalPoints(int points) {
        switch(points)
                {
                    case 0:
                        return "Love";
                    case 1:
                        return "Fifteen";
                    case 2:
                        return "Thirty"; 
                    default:
                        return "Forty";
                }
    }

    public String getScore() {
        
        
        if (p1_points==p2_points) {
            return evenScore(p1_points);
        }
        else if (p1_points>=4 || p2_points>=4)
        {
            return getEndGamePoints(p1_points, p2_points);
        }
        else
        {
           return getNormalPoints(p1_points) + "-" + getNormalPoints(p2_points);
        }
        
    }
}