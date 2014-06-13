/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.TuotantoAika;
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

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
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

}
