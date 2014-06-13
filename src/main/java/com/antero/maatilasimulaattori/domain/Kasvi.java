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
public enum Kasvi {
    VEHNA("Vehnä",30),
    RUIS("Ruis",40),
    OHRA("Ohra",50),
    KAURA("Kaura",60),
    HEINA("Heinä",70),
    MAISSI("Maissi",80);
    
    private String nimi;
    private int kasvuaikaSek;

    public String getNimi() {
        return nimi;
    }

    public int getKasvuaikaMinuuttia() {
        return kasvuaikaSek;
    }
    
    
    
    Kasvi(String nimi,int kasvuaika){
        this.nimi=nimi;
        this.kasvuaikaSek=kasvuaika;
    }
    
}
