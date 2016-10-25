/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.antero.maatilasimulaattori.ui.komennot;

import com.antero.maatilasimulaattori.domain.Maatila;
import com.antero.maatilasimulaattori.ui.komennot.Komento;

/**
 *
 * @author Antero Oikkonen
 */
public class TulostaVarastosaldo implements Komento{

    private Maatila maatila;

    public TulostaVarastosaldo(Maatila maatila) {
        this.maatila = maatila;
    }
    
    
    
    @Override
    public void suorita() {
        maatila.tulostaVarastosaldo();
    }

    @Override
    public String tulosta() {
        return "tulosta varastosaldo";
    }
    
    
    
}
