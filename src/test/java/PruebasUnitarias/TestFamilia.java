/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasUnitarias;

import Clases.Logica;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Darkgrey93
 */
public class TestFamilia {
    
    public TestFamilia() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testBuscar1() {
        Logica core = new Logica();
        
        String resultadoReal = core.buscar(1);
        String resultadoEsperado = "los hijos y nietos de: Miguel\nAlberto,Andres,Jonathan,";
        assertEquals(resultadoEsperado, resultadoReal);
    }
    public void testBuscar2() {
        Logica core = new Logica();
        
        String resultadoReal = core.buscar(3);
        String resultadoEsperado = "su nombre es: Alberto\n" +
                                    "su padre es: Miguel\n" +
                                    "sus hijos son:Andres,Jonathan,";
        assertEquals(resultadoEsperado, resultadoReal);
    }
    public void testBuscar3() {
        Logica core = new Logica();
        
        String resultadoReal = core.buscar(6);
        String resultadoEsperado = "su nombre es: Jonathan\n" +
                                    "su padre es: Alberto\n" +
                                    "su abuelo es: Miguel";
        assertEquals(resultadoEsperado, resultadoReal);
    }
    
    
}
