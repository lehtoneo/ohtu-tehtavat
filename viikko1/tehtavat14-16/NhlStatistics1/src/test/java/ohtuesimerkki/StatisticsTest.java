/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ossij
 */
public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
    public List<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
 
        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Kurri",   "EDM", 37, 53));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Gretzky", "EDM", 35, 89));
 
        return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    @Test
    public void testTeam() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Kurri",   "EDM", 37, 53));
        players.add(new Player("Gretzky", "EDM", 35, 89));
        List<Player> inList = stats.team("EDM");
        
        for (int i = 0; i < players.size(); i++) {
            boolean h = false;
            for (int j = 0; j < inList.size(); j++) {
                if(players.get(i).getName() == inList.get(j).getName()) {
                    h = true;
                    break;
                }
            }
            assertTrue(h);
        }
        
    }
    
    @Test
    public void testSearchWhenPlayerExists() {
        Player p = stats.search("Lemieux");
        
        assertEquals("Lemieux", p.getName());
        
    }
    
    @Test
    public void testSearchWhenPlayerDoesntExist() {
        Player p = stats.search("Lemieuuuux");
        
        assertEquals(null, p);
        
    }
    
    @Test
    public void testTopScorers() {
        List<Player> scorers = stats.topScorers(2);
        List<Player> shouldBe = new ArrayList<Player>();
        shouldBe.add(new Player("Gretzky", "EDM", 35, 89));
        shouldBe.add(new Player("Lemieux", "PIT", 45, 54));
        
        for(int i = 0; i < shouldBe.size(); i++) {
            boolean h = false;
            for (int j = 0; j < scorers.size(); j++) {
                if(shouldBe.get(i).getName() == scorers.get(j).getName()) {
                    h = true;
                    break;
                }
            }
            assertTrue(h);
        }
    }
    
}
