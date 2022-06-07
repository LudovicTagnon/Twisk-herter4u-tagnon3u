package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;

/**
 * Class Etape.
 */
public abstract class Etape implements Iterable<Etape>{

    /**
     * The Nom.
     */
    protected String nom;
    /**
     * The Gest succ.
     */
    protected GestionnaireSuccesseurs gestSucc;
    /**
     * The Cpt etape.
     */
    protected int cptEtape;
    /**
     * The Ligne.
     */
    protected StringBuilder ligne;
    /**
     * The Ligne define.
     */
    protected StringBuilder ligneDefine;
    /**
     * The Ligne sem.
     */
    protected StringBuilder ligneSem;
    /**
     * The Temps.
     */
    protected int temps;
    /**
     * The Ecart temps.
     */
    protected int ecartTemps;
    /**
     * The Nb jetons.
     */
    protected int nbJetons;


    /**
     * Instantiates a new Etape.
     *
     * @param nom the nom
     */
    public Etape(String nom) {
        this.nom = nom;
        this.gestSucc = new GestionnaireSuccesseurs();
        FabriqueNumero fabNum = FabriqueNumero.getInstance();
        this.cptEtape = fabNum.getNumeroEtape();
        ligne = new StringBuilder();
        this.ligneDefine = new StringBuilder();
        this.ligneSem = new StringBuilder();
        temps = 0;
        ecartTemps = 0;
        nbJetons = 0;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Changement nom string.
     *
     * @return the string
     */
    public String changementNom() {
        String changementNom = this.nom.replace(' ', '_');
        changementNom = changementNom.replace('è', 'e');
        changementNom = changementNom.replace('é', 'e');
        return changementNom;
    }

    /**
     * Gets cpt etape.
     *
     * @return the cpt etape
     */
    public int getCptEtape() {
        return cptEtape;
    }

    /**
     * Gets temps.
     *
     * @return the temps
     */
    public int getTemps() {
        return temps;
    }

    /**
     * Gets ecart temps.
     *
     * @return the ecart temps
     */
    public int getEcartTemps() {
        return ecartTemps;
    }

    /**
     * Ajouter successeur.
     *
     * @param etapes the etapes
     */
    public void ajouterSuccesseur(Etape ... etapes){
        this.gestSucc.ajouter(etapes);
    }

    /**
     * Est une activite boolean.
     *
     * @return the boolean
     */
    public boolean estUneActivite(){
        return false;
    }

    /**
     * Est un guichet boolean.
     *
     * @return the boolean
     */
    public boolean estUnGuichet(){
        return false;
    }

    /**
     * Est une sortie boolean.
     *
     * @return the boolean
     */
    public boolean estUneSortie(){
        return false;
    }

    /**
     * Est une entree boolean.
     *
     * @return the boolean
     */
    public boolean estUneEntree(){
        return false;
    }

    /**
     * Nb etapes int.
     *
     * @return the int
     */
    public int nbEtapes(){              // utile pour test ajouterSuccesseur()
        return gestSucc.nbEtapes();
    }

    /**
     * Gets nb jetons.
     *
     * @return the nb jetons
     */
    public int getNbJetons() {
        return nbJetons;
    }

    /**
     * To define string.
     *
     * @return the string
     */
    public abstract String toDefine();

    /**
     * To c string.
     *
     * @return the string
     */
    public abstract String toC();

    /**
     * To sem string.
     *
     * @return the string
     */
    public abstract String toSem();

    @Override
    public Iterator<Etape> iterator() {
        return this.iterator();
    }

    @Override
    public String toString() {
        return nom ;
    }


}
