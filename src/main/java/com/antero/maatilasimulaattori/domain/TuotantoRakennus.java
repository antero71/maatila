/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Antero Oikkonen
 */
public class TuotantoRakennus extends MaatilanOsa implements Varastoitava {

    private List<Varastoitava> valmistettavatTuotteet = new ArrayList();

    private List<Varastoitava> valmistetut = new ArrayList();

    public TuotantoRakennus(String nimi) {
        super(nimi);
    }

    public void lisaaValmistettavaTuote(Tuote tuote) {
        valmistettavatTuotteet.add(tuote);
    }

    public List<Varastoitava> getValmistettavatTuotteet() {
        return valmistettavatTuotteet;
    }

    @Override
    public int getKoko() {
        return 1;
    }

    public void tuotaTuote(Tuote tuote, Valmistusaineet v) {

        for (Varastoitava tuoteArraysta : valmistettavatTuotteet) {

            if (tuoteArraysta.equals(tuote)) {
                if (((Tuote) tuoteArraysta).aloitaTuotanto(v)) {
                    valmistetut.add(tuoteArraysta);
                }
            }

        }

    }

    public List<Varastoitava> getValmiitTuotteet() {
        List<Varastoitava> lista = new ArrayList<>();
        
        for (Varastoitava tuote : valmistetut) {
            if (((Tuote) tuote).isValmis()) {
                lista.add(tuote);
            }
        }
        valmistetut.removeAll(lista);
        return lista;
    }
}
