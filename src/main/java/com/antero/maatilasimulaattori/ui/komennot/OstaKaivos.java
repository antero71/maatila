/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.antero.maatilasimulaattori.ui.komennot;

import com.antero.maatilasimulaattori.ui.komennot.Komento;
import com.antero.maatilasimulaattori.domain.Maatila;
import com.antero.maatilasimulaattori.domain.Nimet;

/**
 *
 * @author Antero Oikkonen
 */
public class OstaKaivos implements Komento{

    private Maatila maatila;
    
    @Override
    public void suorita() {
        maatila.ostaRakennus(Nimet.KAIVOS.getNimi());
    }

    @Override
    public String tulosta() {
        return "osta kaivos";
    }
    
}
