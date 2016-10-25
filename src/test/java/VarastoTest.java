/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Kasvi;
import com.antero.maatilasimulaattori.domain.Muna;
import com.antero.maatilasimulaattori.domain.Nimet;
import com.antero.maatilasimulaattori.domain.Peltotilkku;
import com.antero.maatilasimulaattori.domain.Tuote;
import com.antero.maatilasimulaattori.domain.Valmistusaineet;
import com.antero.maatilasimulaattori.domain.Varasto;
import com.antero.maatilasimulaattori.domain.Varastoitava;
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
public class VarastoTest {

    private Varasto varasto;
    private Peltotilkku peltotilkku;

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
        varasto = new Varasto(20);
        peltotilkku = new Peltotilkku("pelto 1");
    }

    @After
    public void tearDown() {
        varasto = null;
    }

    @Test
    public void lisaaTuoteJaTestaaKoko() {

        Tuote t = new Tuote("Kakku");
        t.lisaaValmistusaine(new Muna("Muna"));
        t.lisaaValmistusaine(Kasvi.VEHNA);

        Valmistusaineet aineet = new Valmistusaineet("Sokeri");
        aineet.lisaaAine(Kasvi.SOKERIRUOKO);

        t.lisaaValmistusaine(new Tuote("Sokeri", aineet));

        System.out.println(aineet);
        System.out.println(t);
        varasto.addTuote(t);

        Assert.assertEquals(1, varasto.getTuotteet().size());
        int valmistusaineidenKoko = 0;
        valmistusaineidenKoko += (new Muna("muna")).getKoko();
        valmistusaineidenKoko += Kasvi.VEHNA.getKoko();
        valmistusaineidenKoko += Kasvi.SOKERIRUOKO.getKoko();

        Assert.assertEquals(valmistusaineidenKoko, varasto.getKoko());
        System.out.println("varaston koko " + varasto.getKoko());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testaaKoko() {
        Tuote t = new Tuote("Kakku");
        t.lisaaValmistusaine(new Muna("Muna"));
        t.lisaaValmistusaine(Kasvi.VEHNA);

        Valmistusaineet aineet = new Valmistusaineet("Sokeri");
        aineet.lisaaAine(Kasvi.SOKERIRUOKO);

        t.lisaaValmistusaine(new Tuote("Sokeri", aineet));

        System.out.println(aineet);
        System.out.println(t);
        varasto.addTuote(t);

        varasto.setTilavuus(5);
        varasto.addTuote(t);

    }

    //@Test
    public void korjaaSatoVarastoon() {
        peltotilkku.kylva(Kasvi.VEHNA);

        try {
            Thread.sleep(Kasvi.VEHNA.getKasvuaikaSekuntia() * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(VarastoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        varasto.addTuote(peltotilkku.korjaaSato());

        Assert.assertEquals(1, varasto.getKoko());
    }

    @Test
    public void annaTuote() {

        varasto.addTuote(Kasvi.VEHNA);

        Assert.assertTrue(varasto.annaTuote(Kasvi.VEHNA));

        varasto.addTuote(Kasvi.VEHNA);

        Tuote kakku = new Tuote("Kakku");
        Valmistusaineet kakkuaineet = new Valmistusaineet("Kakku");

        kakkuaineet.lisaaAine(Kasvi.VEHNA);

        Valmistusaineet sokerinValmistusaineet = new Valmistusaineet("Sokeri");
        sokerinValmistusaineet.lisaaAine(Kasvi.SOKERIRUOKO);
        Tuote sokeri = new Tuote("Sokeri");
        sokeri.lisaaValmistusaine(sokerinValmistusaineet);

        kakkuaineet.lisaaAine(sokeri);

        Muna m = new Muna("Muna");

        kakkuaineet.lisaaAine(m);

        kakku.setAineet(kakkuaineet);

        varasto.addTuote(kakku);

        Assert.assertTrue(varasto.annaTuote(kakku));
        Assert.assertFalse(varasto.annaTuote(kakku));

        int hinta = sokeri.getHinta();
        hinta += m.getHinta();
        hinta += Kasvi.VEHNA.getHinta();
        hinta *= 2;

        Assert.assertEquals(hinta, kakku.getHinta());

    }

    @Test
    public void annaTuoteEiTuotettaVarastossa() {

        Tuote t = new Tuote(Nimet.SOKERI.getNimi());
        
        varasto.addTuote(t);
        
        Tuote tuoteEiVarastossa = new Tuote(Nimet.KAHVI.getNimi());
        tuoteEiVarastossa.setHinta(290);
        
        Varastoitava varastoitava = varasto.annaTuote(tuoteEiVarastossa,1000);
        
        Assert.assertNull(varastoitava);
        
        varasto.addTuote(tuoteEiVarastossa);
        
        Assert.assertNotNull(varasto.annaTuote(tuoteEiVarastossa,1000));
        
        varasto.addTuote(Kasvi.MAISSI);
        
        Assert.assertNotNull(varasto.annaTuote(Kasvi.MAISSI,1000));
        
        Assert.assertNull(varasto.annaTuote(Kasvi.RUIS,1000));
        
        Muna muna = new Muna("Muna");
        
        varasto.addTuote(muna);
        
        muna.setHinta(100);
        
        Assert.assertNotNull(varasto.annaTuote(muna,1000));
 
    }
    
    @Test
    public void peltotilkku(){
        Peltotilkku pelto = new Peltotilkku(Nimet.PELTO.getNimi());
        
        varasto.addTuote(pelto);
        
        pelto.setHinta(1002);
        
        Assert.assertNotNull(varasto.annaTuote(new Peltotilkku(Nimet.PELTO.getNimi()),2999));
        
    }
}
