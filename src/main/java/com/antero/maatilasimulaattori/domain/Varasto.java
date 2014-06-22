/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Antero Oikkonen
 */
public class Varasto extends MaatilanOsa {

    private final List<Varastoitava> tuotteet = new ArrayList<>();

    private int tilavuus = 50; // oletustilavuus

    public Varasto(int tilavuus) {
        super("Varasto");
        this.tilavuus = tilavuus;
    }

    /**
     * palauttaa <code>Valmistusaineet</code> jos kaikki aineet löytyy ja
     * poistaa ne varastosta. muuten palauttaa null
     */
    public Valmistusaineet annaValmistusaineet(Valmistusaineet aineet) {

        Collection<Varastoitava> haettavat = aineet.getAineet();
        Collection<Varastoitava> palautettavat = null;
        if (tuotteet.containsAll(haettavat)) {
            palautettavat = new ArrayList();
            palautettavat.addAll(haettavat);
            Iterator<Varastoitava> iter = haettavat.iterator();
            while (iter.hasNext()) {
                tuotteet.remove(iter.next());
            }
        }

        Valmistusaineet palAineet = null;
        if (palautettavat != null) {
            palAineet = new Valmistusaineet(aineet.getNimi());
            palAineet.lisaaAineet(palautettavat);
        }
        return palAineet;

    }

    public boolean mahtuuko(int koko) {

        return tilavuus >= (koko + this.getKoko());
    }

    public void addTuote(Varastoitava tuote) throws IllegalArgumentException {
        if (mahtuuko(tuote.getKoko())) {
            tuotteet.add(tuote);
        } else {
            throw new IllegalArgumentException("Varastoon ei mahdu tuotetta jonka koko on " + tuote.getKoko());
        }
    }

    public void addTuote(Varastoitava tuote, int maara) {
        for (int i = 0; i < maara; i++) {
            addTuote(tuote);
        }
    }

    public Collection<Varastoitava> getTuotteet() {
        return tuotteet;
    }

    /**
     * palauttaa varaston tilavuuden
     *
     * @return
     */
    public int getTilavuus() {
        return tilavuus;
    }

    public void setTilavuus(int tilavuus) {
        this.tilavuus = tilavuus;
    }

    @Override
    public String toString() {
        String tuot = "Varastossa:\n";

        for (Varastoitava tuote : tuotteet) {
            tuot += "Nimi: " + tuote.getNimi() + ", hinta: " + tuote.getHinta() + "\n";
        }

        return tuot;
    }

    public int getKoko() {
        int varastonkoko = 0;
        for (Varastoitava tuote : tuotteet) {
            varastonkoko += tuote.getKoko();
        }
        return varastonkoko;
    }

    /**
     * jos tuote löytyy, palautetaan true ja poistetaan tuote varastosta,
     * muutoin palautetaan false
     */
    public boolean annaTuote(Varastoitava tuote) {
        if (this.tuotteet.contains(tuote)) {
            tuotteet.remove(tuote);
            return true;
        }
        return false;
    }

    /**
     * jos tuote löytyy ja rahaa riittää palautetaan tuote ja poistetaan tuote
     * varastosta jos<code>tuote</code> on <code>null</code> tai rahaa on
     * vähemmän kuin 1 heittää <code>IllegalArgumentException</code> poikkeuksen
     *
     * @param tuote
     * @param rahaa
     * @return <code>null</code> jos ei löydy, muuten Varastoitava objektin
     */
    public Varastoitava annaTuote(Varastoitava tuote, int rahaa) throws IllegalArgumentException {
        if (tuote == null || rahaa < 1) {
            throw new IllegalArgumentException("Tuote ei saa olla null ja rahamäärän pitää olla suurempi kuin 0");
        }

        Iterator<Varastoitava> iter = tuotteet.iterator();

        Varastoitava t = null;

        Varastoitava loytyi = null;

        while (iter.hasNext()) {
            t = iter.next();
            if (t.getClass() == tuote.getClass()) {
                loytyi = t;
                break;
            }
        }
        if (loytyi != null) {
            tuotteet.remove(loytyi);
            return t;
        }

        return null;
    }

    public void addTuotteet(Collection<Varastoitava> lisattavattuotteet) {
        for (Varastoitava tuote : lisattavattuotteet) {
            addTuote(tuote);
        }
    }

}
