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
public class MaatilanElain extends MaatilanOsa implements Elava {

    private TuotantoAika tuotantoAika;

    private boolean nalkainen = true;

    public MaatilanElain(String nimi) {
        super(nimi);
    }
    public MaatilanElain(String nimi,long tuotantoAika) {
        super(nimi);
        this.tuotantoAika = new TuotantoAika(tuotantoAika*1000);
    }

    @Override
    public boolean isNalkainen() {
        return nalkainen;
    }

    @Override
    public void ruoki() {
        nalkainen = false;
        tuotantoAika.aloitaTuotanto(System.currentTimeMillis());
    }

    /**
     * palauttaa false mikäli tuotanto
     * ei ole valmis, esim. kanalla munat, lehmällä maito
     * jos palauttaa true, asettaa samalla nalkainen arvoksi true,
     * eli eläin pitää syöttää ennen uuden tuotantojakson alkua
     * @return 
     */
    
    public boolean tuota() {
        if (!tuotantoAika.isTuotantoAloitettu()) {
            return false;
        }
        if (tuotantoAika.isTaynna()) {
            tuotantoAika.nollaa();
            nalkainen = true;
            return true;
        } else {
            return false;
        }
    }

}
