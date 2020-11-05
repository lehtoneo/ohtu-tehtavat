package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Comparator<Player> comparator = new PlayerComparator();
        
        PriorityQueue<Player> pistep = new PriorityQueue<Player>(comparator);
        System.out.println("Oliot:");
        for (Player player : players) {
            System.out.println(player);
            if(player.getNationality().equals("FIN")) {
                 pistep.add(player);
            }
        } 
        System.out.println("Players from FIN");
        while(!pistep.isEmpty()) {
            Player p = pistep.poll();
            System.out.println(p.getName() + " " + p.getTeam() + " " + p.getGoals() + " + " + p.getAssists() + " = " + (p.getGoals() + p.getAssists()));
        }
    }
  
}
