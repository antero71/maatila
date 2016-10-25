/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Kaivos;
import com.antero.maatilasimulaattori.domain.Nimet;
import com.antero.maatilasimulaattori.domain.Varasto;
import java.util.Collection;
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
public class KaivosTest {
    
    private Varasto varasto;
    private Kaivos kaivos;
    
    public KaivosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kaivos = new Kaivos(Nimet.KAIVOS.getNimi());
        varasto = new Varasto(100);
    }
    
    @After
    public void tearDown() {
        kaivos = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void kaivaMalmia() {
    
        Collection malmit = kaivos.kaivaMalmia();
        int maxSize = 5;
        System.out.println("maxSize "+maxSize+", currentSize "+malmit.size());
        assertTrue(malmit.size()>0 && malmit.size()<=maxSize);
        
        varasto.addTuotteet(malmit);
        
        System.out.println(varasto);
        
        
    
    
    }
}
