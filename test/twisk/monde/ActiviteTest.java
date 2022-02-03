package twisk.monde;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActiviteTest {
    Activite entree;
    Activite sortie;
    Activite actRestreinte;

    @BeforeEach
    void setUp(){
        entree = new SasEntree();
        sortie = new SasSortie();
        actRestreinte = new ActiviteRestreinte("arbre", 20, 2);
    }

    @Test
    void estUneActivite() {
        assertTrue(entree.estUneActivite());
        assertTrue(sortie.estUneActivite());
        assertTrue(actRestreinte.estUneActivite());

        assertFalse(entree.estUnGuichet());
        assertFalse(sortie.estUnGuichet());
        assertFalse(actRestreinte.estUnGuichet());
    }
}