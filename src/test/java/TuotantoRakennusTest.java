/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.TuotantoRakennus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Antero Oikkonen
 */
public class TuotantoRakennusTest {
    
    private TuotantoRakennus rakennus;
    
    public TuotantoRakennusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rakennus = new TuotantoRakennus("Leipomo");
    }
    
    @After
    public void tearDown() {
        rakennus = null;
    }


    @Test
    public void hello() {}
}
