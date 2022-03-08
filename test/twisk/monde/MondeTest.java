package twisk.monde;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MondeTest {

    Monde m;
    Guichet g1, g2, g3;
    Activite a1, a2, a3;
    SasEntree e;
    SasSortie s;

    @BeforeEach
    void setUp() {
        m = new Monde();

        g1 = new Guichet("g1");

        a1 = new Activite("a1", 2, 1);
        a2 = new Activite("a2", 5, 2);


        e = new SasEntree();
        s = new SasSortie();

        m.aCommeEntree(g1);
        g1.ajouterSuccesseur(a1);
        a1.ajouterSuccesseur(a2);
        m.aCommeSortie(a2);

        m.ajouter(g1, a1, a2, e, s);
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