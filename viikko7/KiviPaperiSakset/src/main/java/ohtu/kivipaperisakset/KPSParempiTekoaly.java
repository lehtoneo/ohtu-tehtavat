package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;


public class KPSParempiTekoaly extends KiviPaperiSakset {

    public TekoalyParannettu tekoaly = new TekoalyParannettu(20);


    @Override
    protected String toisenSiirto() {
       String tokanSiirto = tekoaly.annaSiirto();
       System.out.println("Tietokone valitsi " + tokanSiirto);
       tekoaly.asetaSiirto(viimeSiirto);
       return tokanSiirto;//To change body of generated methods, choose Tools | Templates.
    }
}
