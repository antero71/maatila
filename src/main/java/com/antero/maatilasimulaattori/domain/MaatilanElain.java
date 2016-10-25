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
            System.out.println("tuotantoa ei ole aloitettu, palautuu false");
            return false;
        }
        if (tuotantoAika.isValmis()) {
            tuotantoAika.nollaa();
            nalkainen = true;
            System.out.println("tuotento valmis, palautuu true");
            return true;
        } else {
            System.out.println("Tuotanto ei ole valmis, aika valmistumiseen "+tuotantoAika.mitenPitkaAikaValmistumiseen()+" sekuntia");
            return false;
        }
    }

}
