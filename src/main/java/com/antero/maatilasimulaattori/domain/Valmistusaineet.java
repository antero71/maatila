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

    public Valmistusaineet(String nimi) {
        super(nimi);
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
        s.append("\nAineet:");
        for (Varastoitava aine : valmistusaineet) {
            s.append("\n");
            s.append(aine.getNimi());
        }

        return s.toString();
    }

}
