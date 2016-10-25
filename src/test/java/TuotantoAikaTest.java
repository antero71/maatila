/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.TuotantoAika;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Antero Oikkonen
 */
public class TuotantoAikaTest {

    private TuotantoAika tuotantoAika;

    public TuotantoAikaTest() {
    }



    @Before
    public void setUp() {
        tuotantoAika = new TuotantoAika();
    }

    @After
    public void tearDown() {
        tuotantoAika = null;
    }

    @Test
    public void mitenPitkaAikaValmistumiseenKelloAikana() {

        Assert.assertEquals("01:00:00", tuotantoAika.mitenPitkaAikaValmistumiseenKelloAikana(3600));

        Assert.assertEquals("00:01:00", tuotantoAika.mitenPitkaAikaValmistumiseenKelloAikana(60));

        Assert.assertEquals("00:59:59", tuotantoAika.mitenPitkaAikaValmistumiseenKelloAikana(3599));

        Assert.assertEquals("08:00:10", tuotantoAika.mitenPitkaAikaValmistumiseenKelloAikana(28810));

        
    }

    @Test
    public void testaaOnkoTuotantoAloitettuJosSitaEiOleAloitettu(){
        assertFalse(tuotantoAika.isTuotantoAloitettu());
        
    }
    
    @Test
    public void testaaOnkoTuotantoValmisJosEiAloitettu(){
        assertFalse(tuotantoAika.isValmis());
    }
    
    @Test
    public void testaaOnkoTuotantoAloitettuJosSeOnAloitettu(){
        tuotantoAika.aloitaTuotanto(System.currentTimeMillis());
        assertTrue(tuotantoAika.isTuotantoAloitettu());
    }
    
    @Test
    public void testaaOnkoValmisJosEiValmis(){
        tuotantoAika.aloitaTuotanto(System.currentTimeMillis());
        assertFalse(tuotantoAika.isValmis());
    }
    
    @Test
    public void testaaOnkoValmisJosValmis(){
        tuotantoAika = new TuotantoAika(1000L);
        tuotantoAika.aloitaTuotanto(System.currentTimeMillis());
        try {
            Thread.sleep(1100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TuotantoAikaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(tuotantoAika.isValmis());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void aloitaTuontantoAikaEiValidi(){
        tuotantoAika.aloitaTuotanto(100);
    }
    
    @Test
    public void testaaAikaValmistumiseenKunValmis(){
        tuotantoAika = new TuotantoAika(500L);
        try {
            Thread.sleep(550L);
        } catch (InterruptedException ex) {
            Logger.getLogger(TuotantoAikaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(0, tuotantoAika.mitenPitkaAikaValmistumiseen());
    }
    
    @Test
    public void testaaAikaValmistumiseenKunEiValmis(){
        tuotantoAika = new TuotantoAika(5000L);
          try {
            Thread.sleep(1000L);
        } catch (InterruptedException ex) {
            Logger.getLogger(TuotantoAikaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
          int aika = tuotantoAika.mitenPitkaAikaValmistumiseen();
          assertTrue(aika < 4100 && aika > 3900);
    }
}
