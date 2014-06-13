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
public class Taso {

    private int taso;
    private int pisteet;
    private int montaPeltotilkkua;

    public Taso(int taso) {
        this.taso = taso;
        this.montaPeltotilkkua=5;
    }

    public void addPisteita(int maara) {
        if (maara > 0) {
            pisteet += maara;
        }
    }

    public int getTaso() {
        return taso;
    }

    public int getPisteet() {
        return pisteet;
    }

    public int montaPeltotilkkuaVoiOstaa(){
        return montaPeltotilkkua+(taso+3);
    }
    
    @Override
    public String toString() {
        return "Taso: "+taso+", pisteet: "+pisteet;
    }
 
}
