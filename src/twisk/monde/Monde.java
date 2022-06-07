package twisk.monde;

import java.util.Iterator;

/**
 * Class Monde.
 */
public class Monde implements Iterable<Etape>{

    private SasEntree sasEntree;
    private GestionnaireEtapes lesEtapes;
    private SasSortie sasSortie;

    /**
     * Instantiates a new Monde.
     */
    public Monde(){
        this.sasEntree = new SasEntree();
        this.lesEtapes = new GestionnaireEtapes();
    }

    /**
     * Get nom etape string.
     *
     * @param i the
     * @return the string
     */
    public String getNomEtape(int i){
        return lesEtapes.getNomEtape(i);
    }

    /**
     * Get etape etape.
     *
     * @param i the
     * @return the etape
     */
    public Etape getEtape(int i){
        return lesEtapes.getEtape(i);
    }

    /**
     * Gets sas entree.
     *
     * @return the sas entree
     */
    public SasEntree getSasEntree() {
        return sasEntree;
    }

    /**
     * A comme entree.
     *
     * @param etapes the etapes
     */
    public void aCommeEntree(Etape ... etapes){
        this.sasEntree.ajouterSuccesseur(etapes);
    }

    /**
     * A comme sortie.
     *
     * @param etapes the etapes
     */
    public void aCommeSortie(Etape ... etapes){
        this.sasSortie = new SasSortie();
        for(Etape e : etapes) {
            e.ajouterSuccesseur(this.sasSortie);
        }
    }

    /**
     * Ajouter.
     *
     * @param etapes the etapes
     */
    public void ajouter(Etape ... etapes){
        this.lesEtapes.ajouter(etapes);
    }

    /**
     * Nb etapes int.
     *
     * @return the int
     */
    public int nbEtapes(){
        return this.lesEtapes.nbEtapes()+2;
    }


    /**
     * Nb guichets int.
     *
     * @return the int
     */
    public int nbGuichets(){
        int S=0;
        for (Etape E : lesEtapes){
            if (E.estUnGuichet()){
                S++;
            }
        }
        return S;
    }

    /**
     * To c string.
     *
     * @return the string
     */
    public String toC(){

        String ligne = "#include <stdlib.h>\n" +
                "#include <stdio.h>\n" +
                "#include \"def.h\"\n" +
                sasEntree.toDefine() +
                sasSortie.toDefine() +
                sasEntree.toSem() +
                "void simulation(int ids){\n" +
                sasEntree.toC() +
                "}";

        return String.valueOf(ligne);
    }

    @Override
    public Iterator<Etape> iterator() {
        return lesEtapes.iterator();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(this.sasEntree + "\n" + this.sasSortie + "\n");

        for(Etape e : lesEtapes){
            res.append(e).append("\n");
        }
        return res.toString();
    }
}
