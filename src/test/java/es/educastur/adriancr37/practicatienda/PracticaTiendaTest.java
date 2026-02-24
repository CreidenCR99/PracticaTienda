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

    PracticaTienda t = new PracticaTienda();

    /**
     * Test of cargaDatos method, of class PracticaTienda.
     */
    @Test
    public void testCargaDatos() {
        assertAll(
                () -> assertEquals(10, t.getArticulos().size()),
                () -> assertEquals(4, t.getClientes().size()),
                () -> assertEquals(5, t.getPedidos().size())
        );
    }

    /**
     * Test of totalPedido method, of class PracticaTienda.
     */
    @Test
    public void testTotalPedido() {
        assertAll(
                () -> assertEquals(585, t.totalPedido(t.getPedidos().get(0))),
                () -> assertEquals(2980, t.totalPedido(t.getPedidos().get(1))),
                () -> assertEquals(390, t.totalPedido(t.getPedidos().get(2))),
                () -> assertEquals(1980, t.totalPedido(t.getPedidos().get(3))),
                () -> assertEquals(2160, t.totalPedido(t.getPedidos().get(4)))
        );
    }

    /**
     * Test of totalCliente2 method, of class PracticaTienda.
     */
    @Test
    public void testTotalCliente2() {
        assertAll(
                () -> assertEquals(3565, t.totalCliente2(t.getClientes().get("80580845T"))),
                () -> assertEquals(2370, t.totalCliente2(t.getClientes().get("36347775R"))),
                () -> assertEquals(2160, t.totalCliente2(t.getClientes().get("63921307Y"))),
                () -> assertEquals(0, t.totalCliente2(t.getClientes().get("02337565Y")))
        );
    }

    /**
     * Test of generaIdPedido method, of class PracticaTienda.
     */
    @Test
    public void testGeneraIdPedido() {
        assertAll(
                () -> assertEquals("80580845T-003/2026", t.generaIdPedido("80580845T")),
                () -> assertEquals("36347775R-003/2026", t.generaIdPedido("36347775R")),
                () -> assertEquals("63921307Y-002/2026", t.generaIdPedido("63921307Y")),
                () -> assertEquals("02337565Y-001/2026", t.generaIdPedido("02337565Y"))
        );
    }

}
