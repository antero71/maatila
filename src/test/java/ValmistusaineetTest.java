/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Kasvi;
import com.antero.maatilasimulaattori.domain.Muna;
import com.antero.maatilasimulaattori.domain.Valmistusaineet;
import com.antero.maatilasimulaattori.domain.Varastoitava;
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
public class ValmistusaineetTest {

    private Valmistusaineet aineet = new Valmistusaineet("testi");

    public ValmistusaineetTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        aineet.lisaaAine(Kasvi.VEHNA);
        aineet.lisaaAine(Kasvi.RUIS);
    }

    @After
    public void tearDown() {
        aineet = null;
    }

    @Test
    public void getHinta() {
        int hintaAluksi = Kasvi.VEHNA.getHinta() + Kasvi.RUIS.getHinta();
        Assert.assertEquals("Hinnat ei täsmää", hintaAluksi, aineet.getHinta());

        aineet.lisaaAine(Kasvi.RUIS);

        hintaAluksi += Kasvi.RUIS.getHinta();

        assertEquals(hintaAluksi, aineet.getHinta());

    }

    @Test
    public void getKoko() {

        int kokoAluksi = Kasvi.VEHNA.getKoko() + Kasvi.RUIS.getKoko();

        assertEquals(kokoAluksi, aineet.getKoko());

        aineet.lisaaAine(Kasvi.MAISSI);

        kokoAluksi += Kasvi.MAISSI.getKoko();

        assertEquals(kokoAluksi, aineet.getKoko());
    }

    @Test
    public void getMaara() {

        int maaraAluksi = 2;

        assertEquals(maaraAluksi, aineet.getMaara());

        aineet.lisaaAine(Kasvi.MAISSI);

        assertEquals(maaraAluksi + 1, aineet.getMaara());

    }

}
