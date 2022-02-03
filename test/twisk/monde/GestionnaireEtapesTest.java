package twisk.monde;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionnaireEtapesTest {

    GestionnaireEtapes ge;

    @BeforeEach
    void setUp() {
        ge = new GestionnaireEtapes();
    }

    @Test
    void nbEtapes() {

    }

    @Test
    void ajouter() {
        ge.ajouter(new Activite("activite"), new Guichet("guichet"), new Activite("Activite2"));
        assertEquals(ge.nbEtapes(), 3);
        assertNotEquals(ge.nbEtapes(), 4);
    }


}