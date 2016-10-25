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
public class Tuote extends MaatilanOsa implements Varastoitava {

    private Valmistusaineet aineet;
    protected TuotantoAika tuotantoAika;

    public Tuote(String nimi) {
        super(nimi);
        aineet = new Valmistusaineet(nimi);
    }

    public Tuote(String nimi, Valmistusaineet aineet) {
        super(nimi);
        this.aineet = aineet;
    }

    public Tuote(String nimi, Valmistusaineet aineet, int tuotantoAikaSek) {
        this(nimi, aineet);
        tuotantoAika = new TuotantoAika(tuotantoAikaSek * 1000);
    }
    
    public void setTuotantoAika(int ms){
        if(ms<0)
            throw new IllegalArgumentException("Aika pitää olla nollaa suurempi");
        tuotantoAika = new TuotantoAika(ms);
    }

    /**
     * jos tuotantoAika objekti on asetettu eikä tuotantoa ole vielä aloitettu
     * palauttaa true, muuten false (=jos tuotanto aloitetaan metodin kutsusta,
     * palautuu true, muuten false
     *
     * @return
     */
    public boolean aloitaTuotanto() {
        if (tuotantoAika != null && !tuotantoAika.isTuotantoAloitettu()) {
            tuotantoAika.aloitaTuotanto(System.currentTimeMillis());
            return true;
        }
        return false;
    }
    
    /**
     * jos valmistusaineet mätsää tuotteen valmistusaineisiin
     * eikä tuotantoa ole vielä aloitettu palautuu true
     * muuten false
     * @param aineet
     * @return 
     */
    
    public boolean aloitaTuotanto(Valmistusaineet aineet){
        if(aineet==null)
            return false;
        
        if(this.aineet.equals(aineet) 
                && tuotantoAika != null 
                && !tuotantoAika.isTuotantoAloitettu()){
            tuotantoAika.aloitaTuotanto(System.currentTimeMillis());
            return true;
        }else
            return false;
    }

    /**
     * palauttaa true, jos tuotantoaikaa ei ole asettu, muuten palauttaa
     * tuotantoajan mukaisen arvon.
     *
     * @return
     */
    public boolean isValmis() {
        if (tuotantoAika == null) {
            return true;
        }
        return tuotantoAika.isValmis();
    }

    @Override
    public int getKoko() {
        return this.aineet.getKoko();
    }

    public void lisaaValmistusaine(Varastoitava aine) {
        aineet.lisaaAine(aine);
    }

    public Valmistusaineet getAineet() {
        return aineet;
    }

    public void setAineet(Valmistusaineet aineet) {
        this.aineet = aineet;
    }
    
    

    @Override
    public String toString() {
        StringBuffer b = new StringBuffer("Tuote: ");
        b.append(getNimi());
        b.append("\n - koko ");
        b.append(getKoko());
        b.append("\n - hinta ");
        b.append(getHinta());
        b.append("\n");
        b.append(aineet);
        b.append("\n");

        return b.toString();
    }

    /**
     * hinta on 2 * valmistusaineiden hinta
     * jos valmistusaineiden hinta on 0, hinta on 200.
     * @return 
     */
    
    @Override
    public int getHinta() {
        int hintaKerroin = 2;

        int valmistusaineidenHinnat = 0;

        if (aineet != null) {
            for (Varastoitava aine : this.aineet.getAineet()) {
                valmistusaineidenHinnat += aine.getHinta();
            }

            if (valmistusaineidenHinnat == 0) {
                valmistusaineidenHinnat = 10 * this.aineet.getMaara();
            }
        }else{
            valmistusaineidenHinnat=100;
        }
        
        return valmistusaineidenHinnat * hintaKerroin;
    }

}
