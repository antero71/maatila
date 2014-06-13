/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Peltotilkku;
import com.antero.maatilasimulaattori.domain.Viljelykasvi;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Antero Oikkonen
 */
public class PeltotilkkuTest {
    
    private static String viljalaatu ="Vehnä";
    private Peltotilkku pelto;
    
    public PeltotilkkuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelto = new Peltotilkku("Pelto");
    
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void korjaaSato() {
        pelto.kylva(new Viljelykasvi(viljalaatu, 10));
        
        try {
            Thread.sleep(11100);
        } catch (InterruptedException ex) {
            Logger.getLogger(PeltotilkkuTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        Assert.assertTrue(pelto.isValmisKorjattavaksi());
        
        Viljelykasvi vilja = new Viljelykasvi(viljalaatu);
        
        Assert.assertEquals(vilja, pelto.korjaaSato());
    
    }
}
