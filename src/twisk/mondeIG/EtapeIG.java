package twisk.mondeIG;

import twisk.outils.TailleComposants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class EtapeIG implements Iterable<PointDeControleIG> {
    protected String nom;
    protected String identifiant;
    protected int posX;
    protected int posY;
    protected int largueur;
    protected int hauteur;

    protected int delai;
    protected int ecartTemps;

    protected int nbJetons;

    protected ArrayList<PointDeControleIG> points;

    protected boolean estEntree;
    protected boolean estSortie;

    public EtapeIG(String nom, String idf, int larg, int haut) {
        this.nom = nom;
        this.identifiant = idf;
        this.largueur = larg;
        this.hauteur = haut;

        Random r = new Random();
        this.posX = r.nextInt(TailleComposants.getInstance().getTailleEcranX() - larg);
        this.posY = r.nextInt(TailleComposants.getInstance().getTailleEcranY() - haut);

        this.points = new ArrayList<>(4);

        this.setPosPDC();
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void suppPDC(){
        this.points.clear();
    }

    public void setPosPDC(){
        this.points.add(new PointDeControleIG(this.posX + this.largueur/2, this.posY, this.nom + "_Point1", this));
        this.points.add(new PointDeControleIG(this.posX, this.posY + this.hauteur/2, this.nom + "_Point2", this));
        this.points.add(new PointDeControleIG(this.posX + this.largueur/2, this.posY + this.hauteur, this.nom + "_Point3", this));
        this.points.add(new PointDeControleIG(this.posX + this.largueur, this.posY + this.hauteur/2, this.nom + "_Point4", this));
    }

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        this.suppPDC();
        this.setPosPDC();
    }

    public boolean getEstEntree() {
        return estEntree;
    }

    public boolean getEstSortie() {
        return estSortie;
    }

    public void setEstEntree() {
        if(!this.estEntree){
            this.estEntree = true;
            this.estSortie = false;
        }else{
            this.estEntree = false;
        }
    }

    public void setEstSortie() {
        if(!this.estSortie){
            this.estSortie = true;
            this.estEntree = false;
        }else{
            this.estSortie = false;
        }
    }

    public void setDelaiEcartTemps(int delai, int ecartTemps) {
        this.delai = delai;
        this.ecartTemps = ecartTemps;
    }

    public void setJeton(int nbJetons) {
        this.nbJetons = nbJetons;
    }

    public boolean estUneActivite(){
        return false;
    }
    public boolean estUnGuichet(){
        return false;
    }

    public int getDelai() {
        return delai;
    }

    public int getEcartTemps() {
        return ecartTemps;
    }

    public int getNbJetons() {
        return nbJetons;
    }

    @Override
    public Iterator<PointDeControleIG> iterator() {
        return points.iterator();
    }

    @Override
    public String toString() {
        return "EtapeIG{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
