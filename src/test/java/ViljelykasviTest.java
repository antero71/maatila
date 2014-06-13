/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Viljelykasvi;
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
public class ViljelykasviTest {

    private Viljelykasvi kasvi;

    public ViljelykasviTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kasvi = new Viljelykasvi("Vehnä", 10); // 10 kasvuaika sekuntia 
    }

    @After
    public void tearDown() {
        kasvi = null;
    }

    @Test
    public void kasvuaika() {
        long time = System.currentTimeMillis();
        kasvi.setKylvettyAika(time);

        try {
            Thread.sleep(10100);
        } catch (InterruptedException ex) {
            Logger.getLogger(ViljelykasviTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Assert.assertTrue(kasvi.isValmis());

        time = System.currentTimeMillis();
        kasvi.setKylvettyAika(time);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ViljelykasviTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Assert.assertFalse(kasvi.isValmis());

    }
}
