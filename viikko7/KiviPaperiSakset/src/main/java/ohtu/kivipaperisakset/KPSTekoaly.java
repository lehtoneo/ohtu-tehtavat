package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {
;
    public Tekoaly tekoaly = new Tekoaly();


    @Override
    protected String toisenSiirto() {
       String tokanSiirto = tekoaly.annaSiirto();
       System.out.println("Tietokone valitsi " + tokanSiirto);
       tekoaly.asetaSiirto(viimeSiirto);
       return tokanSiirto;//To change body of generated methods, choose Tools | Templates.
    }
}