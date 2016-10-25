/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Kasvi;
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
        pelto.kylva(Kasvi.VEHNA);
        
        Assert.assertFalse(pelto.isValmisKorjattavaksi());
        
        try {
            Thread.sleep(Kasvi.VEHNA.getKasvuaikaSekuntia()*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PeltotilkkuTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        System.out.println("valmis korjattavaksi "+pelto.isValmisKorjattavaksi());
        Assert.assertTrue(pelto.isValmisKorjattavaksi());
        
        Assert.assertEquals(Kasvi.VEHNA, pelto.korjaaSato());
    
    }
    
    @Test
    public void testaaOnkoKylvetty(){
        assertFalse(pelto.onkoKylvetty());
    }
    
    @Test
    public void onkoValmisKorjattavaksiJosEiOleKylvetty(){
        assertFalse(pelto.isValmisKorjattavaksi());
    }
    
    @Test
    public void testaaToStringJosEiKasvaMitaan(){
        assertEquals("pellossa ei kasva mitään", pelto.toString());
    }
    
    @Test
    public void korjaaSatoPalauttaaNullinJosEiKylvetty(){
        assertNull(pelto.korjaaSato());
    }
    
    @Test
    public void korjaaSatoPalauttaaNullinJosEiValmis(){
        pelto.kylva(Kasvi.VEHNA);
        assertNull(pelto.korjaaSato());
    }
    
    @Test
    public void testaaOnkoKylvettyJosEiKylvetty(){
        assertFalse(pelto.onkoKylvetty());
    }
    
    @Test
    public void testaaOnkoKylvettyJosKylvetty(){
        pelto.kylva(Kasvi.VEHNA);
        assertTrue(pelto.onkoKylvetty());
    }
}
