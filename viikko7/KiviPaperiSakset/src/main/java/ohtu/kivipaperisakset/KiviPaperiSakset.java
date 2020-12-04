/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author ossij
 */
public abstract class KiviPaperiSakset {
    private static final Scanner scanner = new Scanner(System.in);
    public Tuomari tuomari = new Tuomari();
    // tämä on ns template metodi
    public String viimeSiirto;
    public void pelaa() {
        
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        
        String ekanSiirto = ensimmaisenSiirto();
        viimeSiirto = ekanSiirto;
        String tokanSiirto = toisenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            
            System.out.println(tuomari);
            System.out.println();
            
            ekanSiirto = ensimmaisenSiirto();
            viimeSiirto = ekanSiirto;
            tokanSiirto = toisenSiirto();
            
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto();
    
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
