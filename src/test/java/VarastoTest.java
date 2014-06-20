/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Kasvi;
import com.antero.maatilasimulaattori.domain.Valmistusaineet;
import com.antero.maatilasimulaattori.domain.Varasto;
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
public class VarastoTest {
    
    private Varasto varasto;
    
    public VarastoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        varasto = new Varasto(100);
    }
    
    @After
    public void tearDown() {
        varasto = null;
    }

    @Test
    public void annaValmistusaineet() {
        
        varasto.addTuote(Kasvi.VEHNA);
        varasto.addTuote(Kasvi.MAISSI);
        varasto.addTuote(Kasvi.RUIS);
        varasto.addTuote(Kasvi.VEHNA);
        
        assertEquals(4, varasto.getTuotteet().size());

        Valmistusaineet aineet = new Valmistusaineet("Lehmän rehu");
        
        aineet.lisaaAine(Kasvi.VEHNA);
        aineet.lisaaAine(Kasvi.MAISSI);
        
        assertEquals(aineet, varasto.annaValmistusaineet(aineet));
        assertNull(varasto.annaValmistusaineet(aineet));
        
        assertEquals(2, varasto.getTuotteet().size());
        
        aineet = new Valmistusaineet("Kanan rehu");
        
        aineet.lisaaAine(Kasvi.VEHNA);
        aineet.lisaaAine(Kasvi.RUIS);
        
        assertEquals(aineet, varasto.annaValmistusaineet(aineet));
        assertNull(varasto.annaValmistusaineet(aineet));
        
    }
}
