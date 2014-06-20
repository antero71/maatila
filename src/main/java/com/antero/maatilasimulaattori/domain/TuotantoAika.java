/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.domain;

import java.util.ArrayList;
import java.util.Calendar;
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
        if(tayttoaika < 0)
            throw new IllegalArgumentException("Aika ei voi olla negatiivinen");
        tuotantoaikaMs = tayttoaika;
    }

    public boolean isTuotantoAloitettu() {
        return tuotantoAlkoi != 0;
    }

    public void aloitaTuotanto(long currentTimeMs) {
        if(currentTimeMs < (System.currentTimeMillis()-2000))
            throw new IllegalArgumentException("aloitusaika täytyy olla enintään 2 sekuntia aikaisempi kuin nykyhetki");
        tuotantoAlkoi = currentTimeMs;
    }

    public boolean isValmis() {
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
        if (isValmis()) {
            tuotantoAlkoi = 0;
        }
    }

    /*
     palauttaa 0:n jos valmis,
     muutoin sekunnit valmistumiseen
     */
    public int mitenPitkaAikaValmistumiseen() {
        long erotus = System.currentTimeMillis() - tuotantoAlkoi;

        if (erotus > tuotantoaikaMs) {
            return 0;
        } else {
            return (int) ((tuotantoaikaMs-erotus) / 1000);
        }
    }

    public String mitenPitkaAikaValmistumiseenKelloAikana(int sekunnit) {
      
        if(sekunnit<0)
            throw new IllegalArgumentException("sekunnit eivät voi olla negatiivisia");
        int tunnit = sekunnit / 3600;
        sekunnit = sekunnit - tunnit * 3600;
        int minuutit = sekunnit / 60;
        sekunnit = sekunnit - minuutit * 60;
        int sek = sekunnit;

        String stunnit = "" + tunnit;
        String sminuutit = "" + minuutit;
        String ssek = "" + sek;
        
        if (tunnit < 10) {
            stunnit = "0" + stunnit;
        }
        if (minuutit < 10) {
            sminuutit = "0" + sminuutit;
        }

        if (sek < 10) {
            ssek = "0" + ssek;
        }
        return stunnit + ":" + sminuutit + ":" + ssek;

    }
}
