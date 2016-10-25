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
public class Vehnaleipa extends Tuote{

    public Vehnaleipa(String nimi) {
        super(Nimet.VEHNALEIPA.getNimi());
        Valmistusaineet aineet = new Valmistusaineet(getNimi());
        aineet.lisaaAineet(Kasvi.VEHNA,2);
        aineet.setTuotteenNimi(getNimi());
        super.setAineet(aineet);
        this.tuotantoAika = new TuotantoAika(1*30*1000);
    }
    
}
