package es.educastur.adriancr37.practicatienda;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author 1dawd09
 */
public class MetodosAuxTest {
    
    public MetodosAuxTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of esInt method, of class MetodosAux.
     */
    @Test
    public void testEsInt() {
        assertTrue(MetodosAux.esInt("5"));
        assertTrue(MetodosAux.esInt("-5"));
        assertFalse(MetodosAux.esInt("5555555555"));
        assertFalse(MetodosAux.esInt("5.5"));
        assertFalse(MetodosAux.esInt("-5.5"));
        assertFalse(MetodosAux.esInt("Cinco"));
    }

    /**
     * Test of esDouble method, of class MetodosAux.
     */
    @Test
    public void testEsDouble() {
        assertTrue(MetodosAux.esDouble("5.5"));
        assertTrue(MetodosAux.esDouble("-5.5"));
        assertTrue(MetodosAux.esDouble("5"));
        assertTrue(MetodosAux.esDouble("-5"));
        assertFalse(MetodosAux.esDouble("Cinco"));
    }

    /**
     * Test of validarDNI method, of class MetodosAux.
     */
    @Test
    public void testValidarDNI() {
        assertTrue(MetodosAux.validarDNI("80580845T"));
        assertTrue(MetodosAux.validarDNI("36347775R"));
        assertFalse(MetodosAux.validarDNI("36347775A"));
        assertFalse(MetodosAux.validarDNI("80580845B"));
    }
    
}
