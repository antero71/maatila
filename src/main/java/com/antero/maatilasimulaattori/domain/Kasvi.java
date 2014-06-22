/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.domain;

/**
 *
 * @author Antero Oikkonen
 */
public enum Kasvi implements Varastoitava {

    VEHNA("Vehnä", 30, 1, 2),
    RUIS("Ruis", 40, 2, 2),
    OHRA("Ohra", 50, 5, 2),
    KAURA("Kaura", 60, 6, 2),
    HEINA("Heinä", 70, 3, 1),
    MAISSI("Maissi", 80, 10, 5),
    SOKERIRUOKO("Sokeriruoko", 120, 7, 2);

    private String nimi;
    private int kasvuaikaSek;
    private int hinta;
    private int koko;
    private TuotantoAika tuotantoAika;

    public String getNimi() {
        return nimi;
    }

    public int getKasvuaikaSekuntia() {
        return kasvuaikaSek;
    }

    Kasvi(String nimi, int kasvuaika, int hinta, int koko) {
        this.nimi = nimi;
        this.kasvuaikaSek = kasvuaika;
        this.hinta = hinta;
        this.koko = koko;
        tuotantoAika = new TuotantoAika(kasvuaika * 1000);
    }

    @Override
    public int getHinta() {
        return hinta;
    }

    @Override
    public int getKoko() {
        return 1;
    }

    public boolean isValmis() {
        if (!tuotantoAika.isTuotantoAloitettu()) {
            return false;
        }

        if (tuotantoAika.isValmis()) {
            //tuotantoAika.nollaa();
            return true;
        }
        return false;
    }

    public void setKylvettyAika(long kylvetty) {
        tuotantoAika.aloitaTuotanto(kylvetty);
    } 
}
