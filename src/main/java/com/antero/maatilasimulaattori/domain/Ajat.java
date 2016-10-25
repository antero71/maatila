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
public enum Ajat {

    MINUUTTI_PUOLI(30*1000),
    MINUUTTI(60 * 1000),
    MINUUTTI_2(2 * 60 * 1000),
    MINUUTTI_5(5 * 60 * 1000),
    MINUUTTI_10(10 * 60 * 1000),
    MINUUTTI_15(15 * 60 * 1000),
    TUNTI_PUOLI(30 * 60 * 1000),
    TUNTI(60 * 60 * 1000);

    private long aika;

    Ajat(long aika) {
        this.aika = aika;
    }
    
    public long getAika(){
        return aika;
    }

}
