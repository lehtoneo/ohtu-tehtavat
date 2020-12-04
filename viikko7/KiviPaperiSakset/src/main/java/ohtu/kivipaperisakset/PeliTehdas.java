package ohtu.kivipaperisakset;

import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ossij
 */
public class PeliTehdas {
    
    private HashMap<String, KiviPaperiSakset> pelit;
    private KiviPaperiSakset tuntematon;
    public PeliTehdas() {
        
        pelit = new HashMap<String, KiviPaperiSakset>();
        pelit.put("a", new KPSPelaajaVsPelaaja());
        pelit.put("b", new KPSTekoaly());
        pelit.put("c", new KPSParempiTekoaly());
        tuntematon = null;
        
    }
    
    public KiviPaperiSakset hae(String peli) {
        
        return pelit.getOrDefault(peli, tuntematon);
            
        
        
    }
    
}
