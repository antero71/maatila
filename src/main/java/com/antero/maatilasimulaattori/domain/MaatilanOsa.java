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
public class MaatilanOsa {
    private String nimi;
    private int hinta;

    public MaatilanOsa(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getHinta() {
        return hinta;
    }

    public void setHinta(int hinta) {
        this.hinta = hinta;
    }
    
    
    
}
