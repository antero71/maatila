/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.ui;

import com.antero.maatilasimulaattori.ui.komennot.KeraaLeivatVarastoon;
import com.antero.maatilasimulaattori.ui.komennot.KeraaMunat;
import com.antero.maatilasimulaattori.ui.komennot.KorjaaVilja;
import com.antero.maatilasimulaattori.ui.komennot.KylvaPelto;
import com.antero.maatilasimulaattori.ui.komennot.KylvaViljaKasviValiten;
import com.antero.maatilasimulaattori.ui.komennot.LeivoLeipa;
import com.antero.maatilasimulaattori.ui.komennot.LopetaKomento;
import com.antero.maatilasimulaattori.ui.komennot.OstaKana;
import com.antero.maatilasimulaattori.ui.komennot.OstaKanala;
import com.antero.maatilasimulaattori.ui.komennot.OstaLeipomo;
import com.antero.maatilasimulaattori.ui.komennot.OstaPeltoKomento;
import com.antero.maatilasimulaattori.ui.komennot.RuokiKanat;
import com.antero.maatilasimulaattori.ui.komennot.TulostaPellonTila;
import com.antero.maatilasimulaattori.ui.komennot.TulostaKaupanTavarat;
import com.antero.maatilasimulaattori.ui.komennot.TulostaTilanne;
import com.antero.maatilasimulaattori.ui.komennot.Komento;
import com.antero.maatilasimulaattori.ui.komennot.TulostaVarastosaldo;
import com.antero.maatilasimulaattori.domain.Kasvi;
import com.antero.maatilasimulaattori.domain.Maatila;
import com.antero.maatilasimulaattori.domain.Nimet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Antero Oikkonen
 */
public class Kayttoliittyma {

    private Scanner lukija;
    private Maatila maatila;

    private Map<String, Komento> komennot = new TreeMap<String, Komento>();

    public Kayttoliittyma() {

    }

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        maatila = new Maatila("Antero tila");
        maatila.alustaKauppa();

        komennot.put("0", new LopetaKomento());
        komennot.put("1", new OstaPeltoKomento(maatila));
        komennot.put("2", new KylvaPelto(maatila));
        komennot.put("3", new KorjaaVilja(maatila));
        komennot.put("4", new TulostaPellonTila(maatila));
        komennot.put("5", new TulostaTilanne(maatila));
        komennot.put("6", new TulostaVarastosaldo(maatila));
        komennot.put("7", new OstaKanala(maatila));
        komennot.put("8", new OstaKana(maatila));
        komennot.put("9", new TulostaPellonTila(maatila));

        komennot.put("10", new RuokiKanat(maatila));
        komennot.put("11", new KeraaMunat(maatila));
        komennot.put("12", new OstaLeipomo(maatila));
        komennot.put("13", new LeivoLeipa(maatila));
        komennot.put("14", new KylvaViljaKasviValiten(maatila, lukija));
        komennot.put("15", new TulostaKaupanTavarat(maatila));
        komennot.put("16", new KeraaLeivatVarastoon(maatila));
    }

    public void kaynnista() {

        String komento = "0";

        while (true) {

            for (String indeksi : komennot.keySet()) {
                System.out.println(indeksi + ") " + komennot.get(indeksi).tulosta());
            }

            komento = lukija.nextLine();

            Komento k = komennot.get(komento);

            if (k != null) {
                komennot.get(komento).suorita();
            }

        }
    }

}
