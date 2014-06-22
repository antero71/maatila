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
public class Kanala extends MaatilanOsa implements Varastoitava {

    private int kanalanKoko = 5;
    private Collection<Kana> kanat = new <Kana>ArrayList();

    public Kanala(String nimi) {
        super(nimi);
        setHinta(100);
    }

    public int munita() {

        int munienLkm = 0;

        for (Kana kana : kanat) {
            if (kana.muni()) {
                munienLkm++;
            }
        }
        return munienLkm;
    }

    public void lisaaKana(Kana kana) {
        if (kanat.size() < kanalanKoko) {
            kanat.add(kana);
        }
    }

    public void ruokiKanat() {
        for (Kana kana : kanat) {
            if (kana.isNalkainen()) {
                kana.ruoki();
            }
        }
    }

    public int montaKanaa() {
        return kanat.size();
    }

    public int getKanalanKoko() {
        return kanalanKoko;
    }

    @Override
    public int getKoko() {
       return kanalanKoko;
    }

}
