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
public class Muna extends MaatilanOsa implements Varastoitava {

    public Muna(String nimi) {
        super(nimi);
    }

    @Override
    public int getKoko() {
        return 1;
    }
    
}
