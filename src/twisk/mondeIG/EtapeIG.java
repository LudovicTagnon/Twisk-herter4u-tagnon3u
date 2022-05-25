package twisk.mondeIG;

import twisk.monde.Etape;
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

    protected ArrayList<EtapeIG> successeurs;

    protected boolean estEntree;
    protected boolean estSortie;

    public EtapeIG(String nom, String idf, int larg, int haut) {
        this.nom = nom;
        this.identifiant = idf;
        this.largueur = larg;
        this.hauteur = haut;
        this.successeurs = new ArrayList<>(5);

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
    public boolean estUneActiviteRestreinte(){
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

    public void ajouterSuc(EtapeIG ... etapes){
        for (int i = 0; i < etapes.length; i++) {
            this.successeurs.add(etapes[i]);
        }
    }

    public void enleverSuc(EtapeIG ... etapes){
        for (int i = 0; i < etapes.length; i++) {
            this.successeurs.remove(etapes[i]);
        }
    }

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
