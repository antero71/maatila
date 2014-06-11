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
public class TuotantoAika {

  
    private long tuotantoaikaMs = 60 * 10 * 1000; // oletus 10 minuuttia
    private long tuotantoAlkoi = 0; // 0, ei alkanut

    public TuotantoAika() {
    }

    public TuotantoAika(long tayttoaika) {
        tuotantoaikaMs = tayttoaika;
    }

    public boolean isTuotantoAloitettu() {
        return tuotantoAlkoi != 0;
    }

    public void aloitaTuotanto(long currentTimeMs) {
        tuotantoAlkoi = currentTimeMs;
    }

    public boolean isTaynna() {
        if (tuotantoAlkoi == 0) {
            return false;
        }
        long erotus = System.currentTimeMillis() - tuotantoAlkoi;
        if (erotus > tuotantoaikaMs) {
            return true;
        } else {
            return false;
        }
    }

    public void nollaa() {
        if (isTaynna()) {
            tuotantoAlkoi = 0;
        }
    }


}
