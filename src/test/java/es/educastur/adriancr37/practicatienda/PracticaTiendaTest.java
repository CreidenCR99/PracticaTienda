package es.educastur.adriancr37.practicatienda;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 1dawd09
 */
public class PracticaTiendaTest {

    PracticaTienda t = new PracticaTienda();

    public PracticaTiendaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        t.cargaDatos();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of totalPedido method, of class PracticaTienda.
     */
    @Test
    public void testTotalPedido() {
        assertAll(
            () -> assertEquals(1000, t.totalPedido(t.getPedidos().get(0))),
            () -> assertEquals(1500, t.totalPedido(t.getPedidos().get(1))),
            () -> assertEquals(2000, t.totalPedido(t.getPedidos().get(2))),
            () -> assertEquals(2500, t.totalPedido(t.getPedidos().get(3)))
        );
    }
    
}
