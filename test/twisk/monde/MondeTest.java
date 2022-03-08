package twisk.monde;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MondeTest {

    Monde m;
    Activite a1, a2;
    Guichet g1, g2, g3;
    SasEntree e;
    SasSortie s;

    @BeforeEach
    void setUp() {
        m = new Monde();
        a1 = new Activite("a1");
        a2 = new Activite("a2");
        g1 = new Guichet("g1");
        g2 = new Guichet("g2");
        g3 = new Guichet("g3");

        e = new SasEntree();
        s = new SasSortie();

        m.aCommeEntree(g1, g2, g3);
        g1.ajouterSuccesseur(a1);
        g2.ajouterSuccesseur(a2);
        g3.ajouterSuccesseur(a2);
        m.aCommeSortie(a1, a2);

        m.ajouter(a1, a2, g1, g2, g3, e, s);
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
        assertEquals(m.nbEtapes(), 9);
        assertNotEquals(m.nbEtapes(), 1);
    }

    @Test
    void nbEtapes() {
    }

    @Test
    void nbGuichets() {
        assertEquals(m.nbGuichets(), 3);
        assertNotEquals(m.nbGuichets(), 2);
    }

    @Test
    void toC(){
        System.out.println(m.toC());
    }
}