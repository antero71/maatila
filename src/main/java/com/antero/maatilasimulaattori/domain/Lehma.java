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
public class Lehma extends MaatilanElain implements Varastoitava {

    static final int utareetTayttyy = 2 * 60 * 1000; // 2 * 60 * 1000 2 minuuttia millisekunteina
    
    public Lehma(String nimi) {
        super(nimi,utareetTayttyy);
    }

    @Override
    public int getKoko() {
        return 1;
    }
    
    public boolean lypsa(){
        return super.tuota();
    }
    
    
}
