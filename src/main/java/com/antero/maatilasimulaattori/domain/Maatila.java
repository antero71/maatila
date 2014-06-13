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
public class Maatila extends MaatilanOsa {

    private int rahat = 1000; // alkusaldo
    private Taso taso = new Taso(1);
    private Varasto varasto = new Varasto(100);
    private Kanala kanala;
    private final Collection<Peltotilkku> pelto;

    public Maatila(String nimi) {
        super(nimi);
        this.pelto = new ArrayList<>();
    }

    public void ruokiKanat() {
        kanala.ruokiKanat();
        int kanoja = kanala.montaKanaa();
        for (int i = 0; i < kanoja; i++) {
            taso.addPisteita(10);
        }
    }

    public void ostaKanala() {
        kanala = new Kanala("kanala");
    }

    public void keraaMunat() {
        int munienLkm = kanala.munita();
        for (int i = 0; i < munienLkm; i++) {
            Muna muna = new Muna("kananmuna");
            muna.setHinta(10);
            varasto.addTuote(muna);
            taso.addPisteita(2);
        }
    }

    public void ostaPeltotilkku() {
        if (rahat > 1 && pelto.size() < taso.montaPeltotilkkuaVoiOstaa()) {
            rahat -= 1;
            pelto.add(new Peltotilkku("Pelto"));
            taso.addPisteita(10);
            System.out.println("Ostin peltotilkun");
            return;
        }
        System.out.println("Tällä tasolla ei voi enää ostaa peltotilkkua.");

    }

    public void kylvaVilja() {
        for (Peltotilkku peltotilkku : pelto) {
            if (!peltotilkku.onkoKylvetty()) {
                peltotilkku.kylva(new Viljelykasvi("Vehnä", 60));
                taso.addPisteita(10);
            }
        }
    }

    public void kylvaVilja(Kasvi kasvi) {
        for (Peltotilkku peltotilkku : pelto) {
            if (!peltotilkku.onkoKylvetty()) {
                peltotilkku.kylva(new Viljelykasvi(kasvi.getNimi(),kasvi.getKasvuaikaMinuuttia()));
                taso.addPisteita(10);
            }
        }
    }

    public void korjaaVilja() {
        for (Peltotilkku peltotilkku : pelto) {
            Viljelykasvi kasvi = peltotilkku.korjaaSato();
            if (kasvi != null) {
                kasvi.setHinta(10);
                varasto.addTuote(kasvi);
                taso.addPisteita(10);
            }

        }
    }

    public void tulostaPisteetJaTaso() {
        System.out.println(taso);
        System.out.println("Rahat: " + rahat);
    }

    public void tulostaVarastosaldo() {
        System.out.println(varasto.toString());
    }
    
    public void tulostaPellonTila(){
        for(Peltotilkku peltotilkku:pelto){
            System.out.println(peltotilkku.toString());
        }
    }

    public void ostaKana() {
        if (kanala == null) {
            System.out.println("Osta ensin kanala");
            return;
        }
        if (kanala.montaKanaa() < kanala.getKanalanKoko()) {
            if (rahat > 10) {
                rahat -= 11;
                Kana kana = new Kana("kana");
                kana.setHinta(11);
                kanala.lisaaKana(kana);
            }

        }
    }

}
