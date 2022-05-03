package twisk.outils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.monde.Activite;
import twisk.monde.Etape;
import twisk.monde.Guichet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FabriqueNumeroTest {
    FabriqueNumero fabNum;
    Etape a1, a2, g1, g2, g3;

    @BeforeEach
    void setUp() {
        fabNum = FabriqueNumero.getInstance();
        a1 = new Activite("a1");
        a2 = new Activite("a2");
        g1 = new Guichet("g1");
        g2 = new Guichet("g2");
        g3 = new Guichet("g3");
    }

    @Test
    void getNumeroEtape(){
        assertEquals(fabNum.getNumeroEtape(), 5);
    }

    @Test
    void getNumeroSemaphore(){
        assertEquals(fabNum.getNumeroSemaphore(), 4);
    }

    @Test
    void reset(){
        fabNum.reset();
        assertEquals(fabNum.getNumeroEtape(), 0);
        assertEquals(fabNum.getNumeroSemaphore(), 0);
    }
}