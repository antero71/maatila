/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Kasvi;
import com.antero.maatilasimulaattori.domain.Nimet;
import com.antero.maatilasimulaattori.domain.Valmistusaineet;
import com.antero.maatilasimulaattori.domain.Varasto;
import com.antero.maatilasimulaattori.domain.Vehnaleipa;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Antero Oikkonen
 */
public class VehnaleipaTest {

    private Varasto varasto;//(50)
    private Vehnaleipa leipa;

    public VehnaleipaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        leipa = new Vehnaleipa(null);
        varasto = new Varasto(50);
    }

    @After
    public void tearDown() {
        leipa = null;
        varasto = null;
    }

    @Test
    public void leivanvalmistus() {
        varasto.addTuote(Kasvi.VEHNA, 2);

        Valmistusaineet vertailuAineet = new Valmistusaineet(Nimet.VEHNALEIPA.getNimi());
        vertailuAineet.lisaaAineet(Kasvi.VEHNA, 2);

        Valmistusaineet aineet = leipa.getAineet();

        Assert.assertEquals(vertailuAineet, aineet);

        Valmistusaineet varastosta = varasto.annaValmistusaineet(aineet);

        Assert.assertEquals(vertailuAineet, varastosta);

        leipa.aloitaTuotanto(varastosta);

        Assert.assertFalse(leipa.isValmis());

        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(VehnaleipaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Assert.assertTrue(leipa.isValmis());
    }
}
