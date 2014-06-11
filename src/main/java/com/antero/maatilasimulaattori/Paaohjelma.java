/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.antero.maatilasimulaattori;

import com.antero.maatilasimulaattori.ui.Kayttoliittyma;
import java.util.Scanner;

/**
 *
 * @author Antero Oikkonen
 */
public class Paaohjelma {
    
    public static void main(String[] args) {
        Kayttoliittyma kl = new Kayttoliittyma(new Scanner(System.in));
        kl.kaynnista();
    }
    
}
