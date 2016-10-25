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
public enum Nimet {
    
    KANA("kana"),
    MUNA("muna"),
    SOKERI("sokeri"),
    KAHVI("kahvi"),
    MAITO("maito"),
    PELTO("peltotilkku"),
    KANALA("kanala"),
    LEIPOMO("leipomo"),
    VEHNALEIPA("vehnaleipa"), 
    KAIVOS("kaivos"),
    RAUTAMALMI("rautamalmi"),
    HOPEAMALMI("hopeamalmi"),
    KUPARIMALMI("kuparimalmi"), 
    KULTAMALMI("kultamalmi");
    
    private String nimi;
    
    Nimet(String nimi){
        this.nimi=nimi;
    }

    public String getNimi() {
        return nimi;
    }
    
    
    
}
