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
public class Summa extends Komento{
    int edellinen;
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
        edellinen = sovellus.tulos();
        
    }

    

    

    @Override
    public void suorita() {
        undo.disableProperty().set(false);
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        edellinen = arvo;
        sovellus.plus(arvo);
        tuloskentta.setText("" + sovellus.tulos() + "");
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0 ) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        sovellus.miinus(edellinen);
        tuloskentta.setText("" + sovellus.tulos());
        undo.disableProperty().set(true);
    }
    
}
