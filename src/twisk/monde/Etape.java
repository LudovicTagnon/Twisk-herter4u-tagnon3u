package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape>{

    protected String nom;
    protected GestionnaireSuccesseurs gestSucc;
    protected int cptEtape;
    protected StringBuilder ligne;
    protected StringBuilder ligneDefine;
    protected StringBuilder ligneSem;
    protected int temps;
    protected int ecartTemps;
    protected int nbJetons;



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

    public String getNom() {
        return nom;
    }

    public String changementNom() {
        String changementNom = this.nom.replace(' ', '_');
        changementNom = changementNom.replace('è', 'e');
        changementNom = changementNom.replace('é', 'e');
        return changementNom;
    }

    public int getCptEtape() {
        return cptEtape;
    }

    public int getTemps() {
        return temps;
    }

    public int getEcartTemps() {
        return ecartTemps;
    }

    public void ajouterSuccesseur(Etape ... etapes){
        this.gestSucc.ajouter(etapes);
    }

    public boolean estUneActivite(){
        return false;
    }

    public boolean estUnGuichet(){
        return false;
    }

    public boolean estUneSortie(){
        return false;
    }

    public boolean estUneEntree(){
        return false;
    }

    public int nbEtapes(){              // utile pour test ajouterSuccesseur()
        return gestSucc.nbEtapes();
    }

    public int getNbJetons() {
        return nbJetons;
    }

    public abstract String toDefine();

    public abstract String toC();

    public abstract String toSem();

    @Override
    public Iterator<Etape> iterator() {
        return this.iterator();
    }

    @Override
    public String toString() {
        return nom + " : " + nbEtapes() + " successeurs = " + gestSucc;
    }
}
