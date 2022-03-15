package twisk.monde;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionnaireSuccesseursTest {

    GestionnaireSuccesseurs gs;

    @BeforeEach
    void setUp() {
        gs = new GestionnaireSuccesseurs();
    }

    @Test
    void ajouter() {
        gs.ajouter(new Activite("activite"), new Guichet("guichet"), new Activite("Activite2"));
        assertEquals(gs.nbEtapes(), 3);
        assertNotEquals(gs.nbEtapes(), 2);
    }

    @Test
    void nbEtapes() {
    }
}