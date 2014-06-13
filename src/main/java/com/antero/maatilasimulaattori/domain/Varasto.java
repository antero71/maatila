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
public class Varasto extends MaatilanOsa{

    private final Collection<Varastoitava> tuotteet = new ArrayList<>();

    private int tilavuus = 1; // oletustilavuus 1

    public Varasto(int tilavuus) {
        super("Varasto");
        this.tilavuus = tilavuus;
    }

    public boolean mahtuuko(int koko){
        int varastonkoko=0;
        for(Varastoitava tuote:tuotteet){
            varastonkoko+=tuote.getKoko();
        }
        return tilavuus>=(koko+varastonkoko);
    }
    
    
    public void addTuote(Varastoitava tuote) throws IllegalArgumentException {
        if (mahtuuko(tuote.getKoko())) {
            boolean add = tuotteet.add(tuote);
        } else {
            throw new IllegalArgumentException("Varastoon ei mahdu tuotetta jonka koko on "+tuote.getKoko());
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

    @Override
    public String toString() {
        String tuot = "Varastossa:\n";
        
        for(Varastoitava tuote:tuotteet){
            tuot += "Nimi: "+tuote.getNimi()+", hinta: "+tuote.getHinta()+"\n";
        }
        
        return tuot;
    }
    
    

}
