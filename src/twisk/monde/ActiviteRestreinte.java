package twisk.monde;

/**
 * Class Activite restreinte.
 */
public class ActiviteRestreinte extends Activite{
    /**
     * Instantiates a new Activite restreinte.
     *
     * @param nom the nom
     */
    public ActiviteRestreinte(String nom) {
        super(nom);
    }

    /**
     * Instantiates a new Activite restreinte.
     *
     * @param nom        the nom
     * @param temps      the temps
     * @param ecartTemps the ecart temps
     */
    public ActiviteRestreinte(String nom, int temps, int ecartTemps) {
        super(nom, temps, ecartTemps);
    }
}
