package twisk.monde;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MondeTest {

    Monde m;
    Activite a1, a2;
    Guichet g1, g2, g3;

    @BeforeEach
    void setUp() {
        m = new Monde();
        a1 = new Activite("a1");
        a2 = new Activite("a2");
        g1 = new Guichet("g1");
        g2 = new Guichet("g2");
        g3 = new Guichet("g3");

        g1.ajouterSuccesseur(a1);
        g2.ajouterSuccesseur(a2);
        g3.ajouterSuccesseur(a2);

    }

    @Test
    void aCommmeEntree() {
        m.aCommeEntree(g1, g2, g3);

        System.out.println(m.getEntree().nbEtapes());
    }

    @Test
    void aCommmeSortie() {
    }

    @Test
    void ajouter() {
        m.ajouter(new Guichet("guichet"), new Activite("activité"));
        assertEquals(m.nbEtapes(), 2);
        assertNotEquals(m.nbEtapes(), 1);
    }

    @Test
    void nbEtapes() {
    }

    @Test
    void nbGuichets() {
        m.ajouter(new Guichet("guichet1"), new Guichet("guichet2"), new Activite("activité"));
        assertEquals(m.nbGuichets(), 2);
        assertNotEquals(m.nbGuichets(), 3);
    }
}