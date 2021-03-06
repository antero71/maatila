/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.antero.maatilasimulaattori.ui.komennot;

import com.antero.maatilasimulaattori.ui.komennot.Komento;
import com.antero.maatilasimulaattori.domain.Maatila;

/**
 *
 * @author Antero Oikkonen
 */
public class TulostaPellonTila implements Komento{

    private Maatila maatila;

    public TulostaPellonTila(Maatila maatila) {
        this.maatila = maatila;
    }
    
    @Override
    public void suorita() {
       maatila.tulostaPellonTila();
    }

    @Override
    public String tulosta() {
        return "tulosta pellon tila";
    }
    
    
    
}
