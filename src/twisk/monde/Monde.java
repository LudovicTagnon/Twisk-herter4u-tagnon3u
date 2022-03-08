package twisk.monde;

import java.util.Iterator;

public class Monde implements Iterable<Etape>{

    private GestionnaireEtapes lesEtapes;
    private SasEntree entree;
    private SasSortie sortie;

    public Monde(){
        this.lesEtapes = new GestionnaireEtapes();
        this.entree = new SasEntree();
        this.sortie = new SasSortie();
    }

    public SasEntree getEntree() {
        return entree;
    }

    public void aCommeEntree(Etape ... etapes){
        this.entree.ajouterSuccesseur(etapes);
    }

    public void aCommeSortie(Etape ... etapes){
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
