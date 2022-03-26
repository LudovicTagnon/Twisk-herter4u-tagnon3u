package twisk.simulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.monde.*;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    Simulation simulation;
    Monde m;
    Guichet g1, g2, g3;
    Activite a1, a2, a3;

    @BeforeEach
    void setUp() {
        simulation = new Simulation();

        m = new Monde();

        g1 = new Guichet("g1");
        a1 = new Activite("a1", 2, 1);
        a2 = new Activite("a2", 5, 2);


        m.aCommeEntree(g1);

        g1.ajouterSuccesseur(a1);
        a1.ajouterSuccesseur(a2);

        m.aCommeSortie(a2);

        m.ajouter(g1, a1, a2);
    }

    @Test
    void simuler() {
        simulation.simuler(m);
    }
}