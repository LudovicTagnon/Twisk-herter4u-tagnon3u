package twisk.monde;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EtapeTest {

    Etape activite;
    Etape guichet;

    @BeforeEach
    void setUp() {
        activite = new Activite("activité");
        guichet = new Guichet("guichet");
        activite.ajouterSuccesseur(new Guichet("a"));
    }

    @Test
    void ajouterSuccesseur() {
        activite.ajouterSuccesseur(new Guichet("a"), new Guichet("b"), new Activite("c"));
        assertEquals(activite.nbEtapes(), 3);
        assertNotEquals(activite.nbEtapes(), 2);

        guichet.ajouterSuccesseur(new Guichet("a"), new Guichet("b"), new Activite("c"));
        assertEquals(guichet.nbEtapes(), 3);
        assertNotEquals(guichet.nbEtapes(), 2);
    }

    @Test
    void estUneActivite() {
        assertTrue(activite.estUneActivite());
        assertFalse(guichet.estUneActivite());
    }

    @Test
    void estUnGuichet() {
        assertTrue(guichet.estUnGuichet());
        assertFalse(activite.estUnGuichet());
    }

    @Test
    void testToString() {
        System.out.println(activite);
        System.out.println(guichet);
    }

    @Test
    void testCptEtape(){
        System.out.println(activite.getCptEtape());
    }
}