/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Antero Oikkonen
 */
public class Maatila extends MaatilanOsa {

    private int rahat = 10000; // alkusaldo
    private Taso taso = new Taso(1);
    private Varasto varasto = new Varasto(100);
    private Kanala kanala;
    private final Collection<Peltotilkku> pelto;
    private Kauppa kauppa;
    private List<TuotantoRakennus> tuotantoRakennukset = new ArrayList();

    public Maatila(String nimi) {
        super(nimi);
        this.pelto = new ArrayList<>();
    }

    public boolean isKanalaOstettu() {
        return kanala != null;
    }

    public void ruokiKanat() {

        if (kanala != null) {
            kanala.ruokiKanat();
            int kanoja = kanala.montaKanaa();
            for (int i = 0; i < kanoja; i++) {
                taso.lisaaMaxPisteita(10);
            }
            System.out.println("Kanat ruokittu, kanoja oli ruokittavana " + kanoja);
        } else {
            System.out.println("Osta ensin kanala");
        }

    }

    public void ostaKanala() {
        kanala = (Kanala) kauppa.osta(new Kanala(Nimet.KANALA.getNimi()), rahat);

        if (kanala != null) {
            rahat -= kanala.getHinta();
            System.out.println("Kanalan osto onnistui, rahaa jäi " + rahat);
        }

    }

    public void keraaMunat() {
        if (kanala != null) {
            int munienLkm = kanala.munita();
            for (int i = 0; i < munienLkm; i++) {
                Muna muna = new Muna(Nimet.MUNA.getNimi());
                muna.setHinta(10);
                varasto.addTuote(muna);
                taso.lisaaMaxPisteita(10);
                System.out.println("Muna lisätty varastoon");
            }
        } else {
            System.out.println("Osta ensin kanala ja kanoja");
        }
    }

    public void ostaPeltotilkku() {

        Peltotilkku tilkku = (Peltotilkku) kauppa.osta(new Peltotilkku(Nimet.PELTO.getNimi()), rahat);

        //System.out.println("Peltotilkku " + tilkku);
        if (tilkku != null) {
            rahat -= tilkku.getHinta();
            taso.lisaaMaxPisteita(10);
            pelto.add(tilkku);
            System.out.println("Ostin peltotilkun");
            return;
        }
        System.out.println("Peltotilkun ostaminen epäonnistui.");
    }

    public void kylvaVilja() {
        if (pelto != null) {
            for (Peltotilkku peltotilkku : pelto) {
                if (!peltotilkku.onkoKylvetty()) {
                    peltotilkku.kylva(Kasvi.VEHNA);
                    taso.lisaaMaxPisteita(10);
                }
            }
        } else {
            System.out.println("Osta ensin peltoa");
        }
    }

    public void kylvaVilja(Kasvi kasvi) {
        for (Peltotilkku peltotilkku : pelto) {
            if (!peltotilkku.onkoKylvetty()) {
                peltotilkku.kylva(kasvi);
                taso.lisaaMaxPisteita(10);
            }
        }
    }

    public void korjaaVilja() {
        for (Peltotilkku peltotilkku : pelto) {
            Kasvi kasvi = peltotilkku.korjaaSato();
            if (kasvi != null) {
                varasto.addTuote(kasvi);
                taso.lisaaMaxPisteita(10);
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

    public void tulostaPellonTila() {
        for (Peltotilkku peltotilkku : pelto) {
            System.out.println(peltotilkku.toString());
        }
    }

    public void ostaKana() {
        if (kanala == null) {
            System.out.println("Osta ensin kanala");
            return;
        }
        if (kanala.montaKanaa() < kanala.getKanalanKoko()) {

            Varastoitava kana = kauppa.osta(new Kana(Nimet.KANA.getNimi()), rahat);

            rahat -= kana.getHinta();

            kanala.lisaaKana((Kana) kana);

            System.out.println("Ostin kanan, rahaa jäi " + rahat);

        }
    }

    public void alustaKauppa() {
        Random r = new Random();
        kauppa = new Kauppa();
        Kanala kanala = new Kanala(Nimet.KANALA.getNimi());
        kanala.setHinta(r.nextInt(50) + 51);

        kauppa.lisaaTuote(kanala);

        Kana kana = null;

        for (int i = 0; i < 5; i++) {
            kana = new Kana(Nimet.KANA.getNimi());
            kana.setHinta(r.nextInt(10) + 11);
            kauppa.lisaaTuote(kana);
        }

        Peltotilkku ptilkku = null;

        for (int i = 0; i < taso.montaPeltotilkkuaVoiOstaa(); i++) {
            ptilkku = new Peltotilkku(Nimet.PELTO.getNimi());
            ptilkku.setHinta(r.nextInt(5) + 1);
            kauppa.lisaaTuote(ptilkku);
        }

        TuotantoRakennus leipomo = new TuotantoRakennus(Nimet.LEIPOMO.getNimi());

        leipomo.setHinta(r.nextInt(500) + 500);

        kauppa.lisaaTuote(leipomo);

        Kaivos kaivos = new Kaivos(Nimet.KAIVOS.getNimi());

        kaivos.setHinta(r.nextInt(5000) + 5000);
        
        kauppa.lisaaTuote(kaivos);
        System.out.println("Kaupassa on tuotteita " + kauppa.getTuotteet().size() + " kappaletta");

    }

    public void leivoLeipa() {
        TuotantoRakennus temp = new TuotantoRakennus(Nimet.LEIPOMO.getNimi());

        int index = tuotantoRakennukset.indexOf(temp);

        if (index > -1) {
            TuotantoRakennus leipomo = tuotantoRakennukset.get(index);

            Vehnaleipa leipa = new Vehnaleipa(null);

            leipomo.lisaaValmistettavaTuote(leipa);

            Valmistusaineet v = varasto.annaValmistusaineet(leipa.getAineet());

            if (null != v) {
                leipomo.tuotaTuote(leipa, v);
                System.out.println("Leipä on uunissa, aikaa valmistumiseen " + leipa.tuotantoAika.mitenPitkaAikaValmistumiseen() + " sekuntia");
            } else {
                System.out.println("Valmistuaineet puuttuivat, tarvittavat aineet ovat " + leipa.getAineet());
            }

        } else {
            System.out.println("Leipomoa ei löytynyt");
        }
    }

    public void keraaLeivatVarastoon() {
        TuotantoRakennus temp = new TuotantoRakennus(Nimet.LEIPOMO.getNimi());

        int index = tuotantoRakennukset.indexOf(temp);

        if (index > -1) {
            TuotantoRakennus leipomo = tuotantoRakennukset.get(index);

            List<Varastoitava> leivat = leipomo.getValmiitTuotteet();

            if (leivat.size() > 0) {
                varasto.addTuotteet(leivat);

                System.out.println("Leipiä oli " + leivat.size() + ", ne on lisätty varastoon");
            } else {
                System.out.println("Valmiita leipiä ei löytynyt");
            }

        } else {
            System.out.println("Leipomoa ei löytynyt");
        }

    }

    public void tulostaKaupanTavarat() {
        kauppa.tulostaVarastossaOlevatTuotteet();
    }

    public void ostaRakennus(String nimi) {
        TuotantoRakennus rakennus = (TuotantoRakennus) kauppa.osta(new TuotantoRakennus(nimi), rahat);

        if (rakennus != null) {

            if (tuotantoRakennukset.contains(rakennus)) {
                System.out.println(rakennus.getNimi()+" voi olla vain yksi");
            } else {
                rahat -= rakennus.getHinta();
                tuotantoRakennukset.add(rakennus);
            }

            System.out.println(nimi + " osto onnistui");
        } else {
            System.out.println("Kaupassa ei ollut " + nimi + " tai rahat eivät riittäneet");
        }
    }

    public void kaivaMalmia() {
        TuotantoRakennus temp = new TuotantoRakennus(Nimet.KAIVOS.getNimi());
        
        int index = tuotantoRakennukset.indexOf(temp);
        
        if(index != -1){
            Kaivos kaivos = (Kaivos)tuotantoRakennukset.get(index);
            varasto.addTuotteet(kaivos.kaivaMalmia());
            
            
        }else{
            System.out.println("Kaivosta ei löytynyt");
        }
    }
    
    

}
