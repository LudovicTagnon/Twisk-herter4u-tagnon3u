package twisk.mondeIG;

import twisk.monde.Etape;
import twisk.outils.CorrespondanceEtapes;
import twisk.outils.TailleComposants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Class Etape ig.
 */
public abstract class EtapeIG implements Iterable<PointDeControleIG> {
    /**
     * The Nom.
     */
    protected String nom;
    /**
     * The Identifiant.
     */
    protected String identifiant;
    /**
     * The Pos x.
     */
    protected int posX;
    /**
     * The Pos y.
     */
    protected int posY;
    /**
     * The Largueur.
     */
    protected int largueur;
    /**
     * The Hauteur.
     */
    protected int hauteur;

    /**
     * The Delai.
     */
    protected int delai;
    /**
     * The Ecart temps.
     */
    protected int ecartTemps;

    /**
     * The Nb jetons.
     */
    protected int nbJetons;

    /**
     * The Points.
     */
    protected ArrayList<PointDeControleIG> points;

    /**
     * The Successeurs.
     */
    protected ArrayList<EtapeIG> successeurs;

    /**
     * The Est entree.
     */
    protected boolean estEntree;
    /**
     * The Est sortie.
     */
    protected boolean estSortie;

    /**
     * Instantiates a new Etape ig.
     *
     * @param nom  the nom
     * @param idf  the idf
     * @param larg the larg
     * @param haut the haut
     */
    public EtapeIG(String nom, String idf, int larg, int haut) {
        this.nom = nom;
        this.identifiant = idf;
        this.largueur = larg;
        this.hauteur = haut;
        this.successeurs = new ArrayList<>(5);

        Random r = new Random();
        this.posX = r.nextInt(TailleComposants.getInstance().getTailleEcranX() - larg);
        this.posY = r.nextInt(TailleComposants.getInstance().getTailleEcranY() - 100 - haut);

        this.points = new ArrayList<>(4);

        this.setPosPDC();
    }

    /**
     * Gets identifiant.
     *
     * @return the identifiant
     */
    public String getIdentifiant() {
        return identifiant;
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
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets pos x.
     *
     * @return the pos x
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Gets pos y.
     *
     * @return the pos y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Supp pdc.
     */
    public void suppPDC(){
        this.points.clear();
    }

    /**
     * Set pos pdc.
     */
    public void setPosPDC(){
        this.points.add(new PointDeControleIG(this.posX + this.largueur/2, this.posY, this.nom + "_Point1", this));
        this.points.add(new PointDeControleIG(this.posX, this.posY + this.hauteur/2, this.nom + "_Point2", this));
        this.points.add(new PointDeControleIG(this.posX + this.largueur/2, this.posY + this.hauteur, this.nom + "_Point3", this));
        this.points.add(new PointDeControleIG(this.posX + this.largueur, this.posY + this.hauteur/2, this.nom + "_Point4", this));
    }

    /**
     * Set pos.
     *
     * @param posX the pos x
     * @param posY the pos y
     */
    public void setPos(int posX, int posY){
        this.posX = posX - this.largueur/2;
        this.posY = posY - this.hauteur/2;
        this.suppPDC();
        this.setPosPDC();
    }

    /**
     * Gets est entree.
     *
     * @return the est entree
     */
    public boolean getEstEntree() {
        return estEntree;
    }

    /**
     * Gets est sortie.
     *
     * @return the est sortie
     */
    public boolean getEstSortie() {
        return estSortie;
    }

    /**
     * Sets est entree.
     */
    public void setEstEntree() {
        if(!this.estEntree){
            this.estEntree = true;
            this.estSortie = false;
        }else{
            this.estEntree = false;
        }
    }

    /**
     * Sets est sortie.
     */
    public void setEstSortie() {
        if(!this.estSortie){
            this.estSortie = true;
            this.estEntree = false;
        }else{
            this.estSortie = false;
        }
    }

    /**
     * Sets delai ecart temps.
     *
     * @param delai      the delai
     * @param ecartTemps the ecart temps
     */
    public void setDelaiEcartTemps(int delai, int ecartTemps) {
        this.delai = delai;
        this.ecartTemps = ecartTemps;
    }

    /**
     * Sets jeton.
     *
     * @param nbJetons the nb jetons
     */
    public void setJeton(int nbJetons) {
        this.nbJetons = nbJetons;
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
     * Est une activite restreinte boolean.
     *
     * @return the boolean
     */
    public boolean estUneActiviteRestreinte(){
        return false;
    }

    /**
     * Gets delai.
     *
     * @return the delai
     */
    public int getDelai() {
        return delai;
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
     * Gets nb jetons.
     *
     * @return the nb jetons
     */
    public int getNbJetons() {
        return nbJetons;
    }

    /**
     * Ajouter suc.
     *
     * @param etapes the etapes
     */
    public void ajouterSuc(EtapeIG ... etapes){
        for (int i = 0; i < etapes.length; i++) {
            this.successeurs.add(etapes[i]);
        }
    }

    /**
     * Enlever suc.
     *
     * @param etapes the etapes
     */
    public void enleverSuc(EtapeIG ... etapes){
        for (int i = 0; i < etapes.length; i++) {
            this.successeurs.remove(etapes[i]);
        }
    }

    /**
     * A une sortie boolean.
     *
     * @return the boolean
     */
    public boolean aUneSortie(){
        if(this.estSortie){
            return true;
        }else if(this.successeurs.size() == 0){
            return false;
        }else{
            for(EtapeIG succ : successeurs){
                return succ.aUneSortie();
            }
        }
        return false;
    }

    /**
     * Ajout act restreinte.
     */
    public void ajoutActRestreinte(){
        if(!this.estSortie){
            for(EtapeIG succ : successeurs){
                if(this.estUnGuichet()){
                    if(succ.estUneActivite()){
                        ActiviteIG actTmp = (ActiviteIG) succ;
                        actTmp.setActRestreinte();
                    }
                }
                succ.ajoutActRestreinte();
            }
        }
    }

    public boolean aUnSucc(){
        if(this.successeurs.size() != 0 || this.successeurs != null){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<PointDeControleIG> iterator() {
        return points.iterator();
    }

    @Override
    public String toString() {
        if(estSortie){
            return nom + "(" + estEntree + " " + estSortie +")";
        }else{
            return nom + "(" + estEntree + " " + estSortie +") -> " + successeurs.get(0);
        }
    }

    /**
     * Gets largueur.
     *
     * @return the largueur
     */
    public int getLargueur() {
        return largueur;
    }

    /**
     * Gets hauteur.
     *
     * @return the hauteur
     */
    public int getHauteur() {
        return hauteur;
    }
}
