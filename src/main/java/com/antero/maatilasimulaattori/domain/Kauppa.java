/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.domain;

import java.util.Collection;

/**
 *
 * @author Antero Oikkonen
 */
public class Kauppa {

    private Varasto varasto;

    public Kauppa() {
        varasto = new Varasto(1000);
    }

    public Varastoitava osta(Varastoitava tuote, int rahaa) {

        return varasto.annaTuote(tuote, rahaa);
    }

    public void lisaaTuote(Varastoitava tuote) {

        varasto.addTuote(tuote);
    }

    public void lisaaTuotteet(Collection<Varastoitava> tuotteet) {
        varasto.addTuotteet(tuotteet);
    }

    public Collection<Varastoitava> getTuotteet() {
        return varasto.getTuotteet();
    }

    public void tulostaVarastossaOlevatTuotteet() {
        Collection<Varastoitava> tuotteet = varasto.getTuotteet();
        int i = 0;

        for (Varastoitava tuote : tuotteet) {
            System.out.println((i + 1) + ": " + tuote.getNimi() + " hinta " + tuote.getHinta());
            i++;
        }
        //System.out.println("");
        //System.out.println(varasto);

    }

}
