/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.domain;

/**
 *
 * @author Antero Oikkonen
 */
public class Viljelykasvi extends MaatilanOsa implements Varastoitava {

    private TuotantoAika tuotantoAika;

    public Viljelykasvi(String nimi) {
        super(nimi);
        tuotantoAika = new TuotantoAika();
    }

    public Viljelykasvi(String nimi, int kasvuAikaSek) {
        super(nimi);
        tuotantoAika = new TuotantoAika(kasvuAikaSek * 1000);
    }

    public Viljelykasvi(Kasvi kasvi) {
        super(kasvi.getNimi());
        tuotantoAika = new TuotantoAika(kasvi.getKasvuaikaSekuntia() * 1000);
    }

    public void setKylvettyAika(long kylvetty) {
        tuotantoAika.aloitaTuotanto(kylvetty);
    }

    public boolean isValmis() {
        if (!tuotantoAika.isTuotantoAloitettu()) {
            return false;
        }

        if (tuotantoAika.isValmis()) {
            //tuotantoAika.nollaa();
            return true;
        }
        return false;
    }

    @Override
    public int getKoko() {
        return 1;
    }

    @Override
    public String toString() {
    
        return getNimi()+" aikaa valmistumiseen ("+this.tuotantoAika.mitenPitkaAikaValmistumiseenKelloAikana(tuotantoAika.mitenPitkaAikaValmistumiseen())+")";
        
       
    }
    
    

}
