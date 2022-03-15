package twisk.monde;

import java.util.Iterator;

public class Monde implements Iterable<Etape>{

    private SasEntree entree;
    private GestionnaireEtapes lesEtapes;
    private SasSortie sortie;

    public Monde(){
        this.entree = new SasEntree();
        this.lesEtapes = new GestionnaireEtapes();
    }

    public GestionnaireEtapes getLesEtapes() {
        return lesEtapes;
    }

    public SasEntree getEntree() {
        return entree;
    }

    public void aCommeEntree(Etape ... etapes){

        this.entree.ajouterSuccesseur(etapes);
    }

    public void aCommeSortie(Etape ... etapes){
        this.sortie = new SasSortie();
        for(Etape e : etapes) {
            e.ajouterSuccesseur(this.sortie);
        }
    }

    public void ajouter(Etape ... etapes){
        this.lesEtapes.ajouter(etapes);
    }

    public int nbEtapes(){
        return this.lesEtapes.nbEtapes();
    }


    public int nbGuichets(){
        int S=0;
        for (Etape E : lesEtapes){
            if (E.estUnGuichet()){
                S++;
            }
        }
        return S;
    }

    public String toC(){
        StringBuilder ligne = new StringBuilder();
        ligne.append("#include <stdlib.h>\n" +
                "#include <stdio.h>\n" +
                "#include \"def.h\"\n");

        ligne.append(entree.toDefine());

        ligne.append(entree.toSem());

        ligne.append("void simulation(int ids){\n");

        ligne.append(entree.toC());

        ligne.append("}");

        return String.valueOf(ligne);
    }

    @Override
    public Iterator<Etape> iterator() {
        return lesEtapes.iterator();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(this.entree + "\n" + this.sortie + "\n");

        for(Etape e : lesEtapes){
            res.append(e).append("\n");
        }
        return res.toString();
    }
}
