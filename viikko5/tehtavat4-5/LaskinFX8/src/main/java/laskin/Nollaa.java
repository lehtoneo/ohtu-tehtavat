/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author ossij
 */
public class Nollaa extends Komento {
    private int edellinen;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
        edellinen = 0;
    }

    @Override
    public void suorita() {
         undo.disableProperty().set(false);
         edellinen = sovellus.tulos();
         sovellus.nollaa();
         nollaa.disableProperty().set(true);
         tuloskentta.setText("" + sovellus.tulos());
         syotekentta.setText("");
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        sovellus.nollaa();
        sovellus.plus(edellinen);
        tuloskentta.setText("" + sovellus.tulos()); 
        undo.disableProperty().set(true);
    }
    
}
