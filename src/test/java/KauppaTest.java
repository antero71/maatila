/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.antero.maatilasimulaattori.domain.Kanala;
import com.antero.maatilasimulaattori.domain.Kauppa;
import com.antero.maatilasimulaattori.domain.Nimet;
import com.antero.maatilasimulaattori.domain.Peltotilkku;
import com.antero.maatilasimulaattori.domain.Varastoitava;
import java.util.Random;
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
public class KauppaTest {

    private Kauppa kauppa;
    private Random r = new Random();

    public KauppaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kauppa = new Kauppa();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void osto1() {

        Peltotilkku pt = new Peltotilkku("Tilkku");
        pt.setHinta(r.nextInt(10) + 1);

        kauppa.lisaaTuote(pt);

        pt.setHinta(r.nextInt(10) + 1);

        kauppa.lisaaTuote(pt);

        //Assert.assertEquals(new Peltotilkku("Pelto"),kauppa.osta(pt, 1000));
        //Assert.assertSame(new Peltotilkku("Pelto"),kauppa.osta(pt, 1000));
        Varastoitava ostettu = kauppa.osta(pt, 1000);
        int hinta = ostettu.getHinta();
        Assert.assertTrue(ostettu instanceof Peltotilkku);

        System.out.println("hinta " + hinta);

        ostettu = kauppa.osta(pt, 1000 - hinta);
        Assert.assertTrue(ostettu instanceof Peltotilkku);
        hinta = ostettu.getHinta();
        System.out.println("hinta " + hinta);

    }
    
    @Test
    public void ostaKanala(){
        Kanala k = new Kanala(Nimet.KANALA.getNimi());
        k.setHinta(1100);
        
        kauppa.lisaaTuote(k);
        
        Assert.assertNotNull(kauppa.osta(new Kanala(Nimet.KANALA.getNimi()), 2000));
        
        
    }
}
