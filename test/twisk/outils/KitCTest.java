package twisk.outils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KitCTest {

    KitC kitC;

    @BeforeEach
    void setUp() {
        kitC = new KitC();
    }

    @Test
    void creerEnvironnement() {
        kitC.creerEnvironnement();
    }


    @Test
    void creerFichier() {
        kitC.creerFichier("a");
    }
}