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
public class Viljelykasvi extends MaatilanOsa{
    
    private String nimi;
    private TuotantoAika tuotantoAika;
    private int hinta; // hinta / yksikko, peltotilkku tuottaa 
                       // kaksi yksikköä yhden kylvöllä

    public Viljelykasvi(String nimi) {
        super(nimi);
        tuotantoAika=new TuotantoAika();
    }

    public Viljelykasvi(String nimi, int kasvuAikaSek) {
        super(nimi);
        tuotantoAika=new TuotantoAika(kasvuAikaSek*1000);
    }
    
    public void setKylvettyAika(long kylvetty) {
        tuotantoAika.aloitaTuotanto(kylvetty);
    }
    
    public boolean isValmis(){
      if(!tuotantoAika.isTuotantoAloitettu()){
          return false;
      }
      
      if(tuotantoAika.isTaynna()){
          tuotantoAika.nollaa();
          return true;
      }
      return false;
    }
}
