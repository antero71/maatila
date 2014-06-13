/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Kasvi;
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
public class KasviTest {
    
    public KasviTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

 
   @Test
   public void kasviNimi() {
   
       System.out.println("test");
       
       Kasvi [] values = Kasvi.values();
       
       for(int i = 0; i < values.length;i++){
           System.out.println("values "+values[i].getNimi());
       }
       
        for(int i = 0; i < values.length;i++){
           System.out.println("values "+values[i]);
       }
   
   }
}
