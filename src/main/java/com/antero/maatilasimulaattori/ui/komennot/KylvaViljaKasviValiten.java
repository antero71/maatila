/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.antero.maatilasimulaattori.ui.komennot;

import com.antero.maatilasimulaattori.ui.komennot.Komento;
import com.antero.maatilasimulaattori.domain.Kasvi;
import com.antero.maatilasimulaattori.domain.Maatila;
import java.util.Scanner;

/**
 *
 * @author Antero Oikkonen
 */
public class KylvaViljaKasviValiten implements Komento{

    private Maatila maatila;
    private Scanner lukija;

    public KylvaViljaKasviValiten(Maatila maatila,Scanner scanner) {
        this.maatila = maatila;
        this.lukija=scanner;
    }
    
    
    
    @Override
    public void suorita() {
       String kasvi = "";
        System.out.println("Valitse vielä kasvi");
        System.out.println("1) Vehnä");
        System.out.println("2) Ruis");
        System.out.println("3) Ohra");
        System.out.println("4) Kaura");
        System.out.println("5) Maissi");
        System.out.println("6) Heinä");
        System.out.println("7) Sokeriruoko");

        kasvi = lukija.nextLine();
        if (kasvi.equals("1")) {
            maatila.kylvaVilja(Kasvi.VEHNA);

        } else if (kasvi.equals("2")) {
            maatila.kylvaVilja(Kasvi.RUIS);

        } else if (kasvi.equals("3")) {
            maatila.kylvaVilja(Kasvi.OHRA);

        } else if (kasvi.equals("4")) {
            maatila.kylvaVilja(Kasvi.KAURA);

        } else if (kasvi.equals("5")) {
            maatila.kylvaVilja(Kasvi.MAISSI);

        } else if (kasvi.equals("6")) {
            maatila.kylvaVilja(Kasvi.HEINA);
        } else if (kasvi.equals("7")) {
            maatila.kylvaVilja(Kasvi.SOKERIRUOKO);
        } else {
            // oletuksenä kylvetään vehnää
            maatila.kylvaVilja();

        }

    }

    @Override
    public String tulosta() {
       return "kylvä vilja kasvi valiten";
    }
    
}
