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
public class Kaivos extends TuotantoRakennus {

    private Random rand = new Random();
    
    public Kaivos(String nimi) {
        super(nimi);
        alustaTuotteet();
    }

    private void alustaTuotteet() {
     
        Tuote hopeaMalmi = new Tuote(Nimet.HOPEAMALMI.getNimi());
        hopeaMalmi.setTuotantoAika(1000);
        hopeaMalmi.setHinta(100);
        
        super.lisaaValmistettavaTuote(hopeaMalmi);
        
        Tuote kupariMalmi = new Tuote(Nimet.KUPARIMALMI.getNimi());
        kupariMalmi.setTuotantoAika(1000);
        kupariMalmi.setHinta(50);
        super.lisaaValmistettavaTuote(kupariMalmi);
        
        Tuote rautaMalmi = new Tuote(Nimet.RAUTAMALMI.getNimi());
        rautaMalmi.setTuotantoAika(1000);
        rautaMalmi.setHinta(30);
        
        Tuote kultamalmi = new Tuote(Nimet.KULTAMALMI.getNimi());
        kultamalmi.setTuotantoAika(1000);
        kultamalmi.setHinta(200);
        
        super.lisaaValmistettavaTuote(rautaMalmi);
    }
    
    /*
     kaivaa 1-5 malmia kerralla
    */
    
    public Collection<Varastoitava> kaivaMalmia(){
        // arvo ensin malmien määrä
        // arvo sitten malmin laatu
        // palauta louhittu malmi Varastoitava -interfacein
        // toteuttamina Tuote -olioina
        List<Varastoitava> malmit = new ArrayList();
        int maara = rand.nextInt(5)+1;
        for(int i = 1 ; i <= maara;i++ ){
            int indeksi = rand.nextInt(getValmistettavatTuotteet().size());
            malmit.add(getValmistettavatTuotteet().get(indeksi));
        }
        
        return malmit;
    }

}
