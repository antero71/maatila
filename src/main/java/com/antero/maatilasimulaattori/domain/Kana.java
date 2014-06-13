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
public class Kana extends MaatilanOsa implements Elava {

    private boolean nalkainen = true;

    private long munaValmistuu = 60 * 1 * 1000; // millisekuntia

    private TuotantoAika tuotantoAika;

    public Kana(String nimi) {
        super(nimi);
        tuotantoAika = new TuotantoAika(munaValmistuu);
    }

    @Override
    public boolean isNalkainen() {
        return nalkainen;
    }

    /**
     * metodikutsu aloittaa munantuotannon
     */
    
    @Override
    public void ruoki() {
        nalkainen = false;
        tuotantoAika.aloitaTuotanto(System.currentTimeMillis());
    }

    public boolean muni() {
        if (!tuotantoAika.isTuotantoAloitettu()) {
            return false;
        }
        if (tuotantoAika.isTaynna()) {
            tuotantoAika.nollaa();
            nalkainen=true;
            return true;
        }else{
            return false;
        }
    }

}
