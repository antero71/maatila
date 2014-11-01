/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Antero Oikkonen
 */
public class Valmistusaineet extends MaatilanOsa implements Varastoitava {

    private Collection<Varastoitava> valmistusaineet = new ArrayList();

    private String tuotteenNimi;
    
    public Valmistusaineet(String nimi) {
        super(nimi+": valmistusaineet");
    }

    public String getTuotteenNimi() {
        return tuotteenNimi;
    }

    public void setTuotteenNimi(String tuotteenNimi) {
        this.tuotteenNimi = tuotteenNimi;
    }

    
    
    @Override
    public int getHinta() {
        int hinta = 0;
        for (Varastoitava tuote : valmistusaineet) {
            hinta += tuote.getHinta();
        }
        return hinta;
    }

    public void lisaaAine(Varastoitava tuote) {
        valmistusaineet.add(tuote);
    }
    
    public void lisaaAineet(Varastoitava tuote, int maara){
        for(int i = 0; i < maara;i++){
            lisaaAine(tuote);
        }
    }

    @Override
    public int getKoko() {
        int koko = 0;
        for (Varastoitava aine : valmistusaineet) {
            koko += aine.getKoko();
        }
        return koko;
    }

    /**
     * valmistusaineiden määrä
     *
     * @return
     */
    public int getMaara() {
        return valmistusaineet.size();
    }

    Collection<Varastoitava> getAineet() {
        return valmistusaineet;
    }

    /**
     * lisää olemassaolevaan ArrayListiin paramterina tulevan Collectionin
     *
     * @param aineet
     */
    public void lisaaAineet(Collection<Varastoitava> aineet) {
        valmistusaineet.addAll(aineet);
    }

    @Override
    public String toString() {

        StringBuffer s = new StringBuffer(getNimi());
        for (Varastoitava aine : valmistusaineet) {
            s.append("\n - ");
            s.append(aine.getNimi());
        }

        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
