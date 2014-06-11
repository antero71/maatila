/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.antero.maatilasimulaattori.ui;

import java.util.Scanner;

/**
 *
 * @author Antero Oikkonen
 */
public class Kayttoliittyma {
    
    private Scanner lukija;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
    }
    
    public void kaynnista(){
        
        String komento = "0";
        
        while(true){
            
            System.out.println("Syötä komento, 0 -päättää luupin");
            
            komento = lukija.nextLine();
            
            if(komento.equals("0")){
                System.out.println("exit");
                break;
            }
  
        }
    }
    
}
