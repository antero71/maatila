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
public class Kana extends MaatilanElain implements Varastoitava{

    static final private long munaValmistuu = 60 * 1; // sekuntia

    public Kana(String nimi) {
        super(nimi,munaValmistuu);
    }


    /**
     * metodikutsu aloittaa munantuotannon
     */

    public boolean muni() {
        return super.tuota();
    }

    @Override
    public int getKoko() {
        return 1;
    }

}
