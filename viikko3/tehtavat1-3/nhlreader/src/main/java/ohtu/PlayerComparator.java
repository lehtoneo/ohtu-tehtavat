/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.Comparator;

/**
 *
 * @author ossij
 */
public class PlayerComparator implements Comparator<Player>{

    @Override
    public int compare(Player p1, Player p2) {
        int p1points = p1.getGoals() + p1.getAssists();
        int p2points = p2.getGoals() + p2.getAssists();
        
        if (p1points == p2points) {
            return 0;
        } else if (p1points < p2points) {
            return 1;
        } else {
            return -1;
        }
        
    }
}
