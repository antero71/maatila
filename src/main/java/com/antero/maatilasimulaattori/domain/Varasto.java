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
public class Varasto {

    private Collection<Varastoitava> tuotteet = new ArrayList<Varastoitava>();

    private int tilavuus = 1; // oletustilavuus 1

    public Varasto(int tilavuus) {
        this.tilavuus = tilavuus;
    }

    public void addTuote(Varastoitava tuote) throws IllegalArgumentException {
        if (tilavuus >= tuotteet.size() + 1) {
            tuotteet.add(tuote);
        } else {
            throw new IllegalArgumentException("Varastoon ei mahdu tuotteita");
        }
    }

    public Collection<Varastoitava> getTuotteet() {
        return tuotteet;
    }

    public int getTilavuus() {
        return tilavuus;
    }

    public void setTilavuus(int tilavuus) {
        this.tilavuus = tilavuus;
    }

}
