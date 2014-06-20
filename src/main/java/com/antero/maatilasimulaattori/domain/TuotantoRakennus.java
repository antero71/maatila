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
public class TuotantoRakennus extends MaatilanOsa{

    private Collection<Varastoitava> valmistettavatTuotteet = new ArrayList(); 
    
    public TuotantoRakennus(String nimi) {
        super(nimi);
    }
    
    public void lisaaValmistettavaTuote(Tuote tuote){
        valmistettavatTuotteet.add(tuote);
    }
    
}
