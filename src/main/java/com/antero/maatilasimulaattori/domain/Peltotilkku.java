/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antero.maatilasimulaattori.domain;

import java.util.Date;

/**
 *
 * @author Antero Oikkonen
 */
public class Peltotilkku extends MaatilanOsa {

    private Viljelykasvi kasvilaatu;

    public Peltotilkku(String nimi) {
        super(nimi);
    }

    public boolean onkoKylvetty(){
        return kasvilaatu!=null;
    }
    
    public void kylva(Viljelykasvi kasvi) {
        kasvilaatu = kasvi;
        kasvilaatu.setKylvettyAika(System.currentTimeMillis());
    }

    public boolean isValmisKorjattavaksi() {
        if (kasvilaatu != null) {
            return kasvilaatu.isValmis();
        } else {
            return false;
        }
    }

    public Viljelykasvi korjaaSato() {  
        if (kasvilaatu!=null && kasvilaatu.isValmis()) {
            Viljelykasvi kasvi = new Viljelykasvi(kasvilaatu.getNimi());
            kasvilaatu = null;
            System.out.println("kasvi "+kasvi);
            return kasvi;
        }
        return null;
    }

    @Override
    public String toString() {
        
        if(kasvilaatu!=null){
            return "pelto kylvetty, kasvi "+kasvilaatu;
        }else
            return "pellossa ei kasva mitään";
        
        
    }
    
    
}
