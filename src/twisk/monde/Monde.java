package twisk.monde;

import java.util.Iterator;

public class Monde implements Iterable<Etape>{

    private SasEntree sasEntree;
    private GestionnaireEtapes lesEtapes;
    private SasSortie sasSortie;

    public Monde(){
        this.sasEntree = new SasEntree();
        this.lesEtapes = new GestionnaireEtapes();
    }

    public String getNomEtape(int i){
        return lesEtapes.getNomEtape(i);
    }

    public Etape getEtape(int i){
        return lesEtapes.getEtape(i);
    }

    public SasEntree getSasEntree() {
        return sasEntree;
    }

    public void aCommeEntree(Etape ... etapes){
        this.sasEntree.ajouterSuccesseur(etapes);
    }

    public void aCommeSortie(Etape ... etapes){
        this.sasSortie = new SasSortie();
        for(Etape e : etapes) {
            e.ajouterSuccesseur(this.sasSortie);
        }
    }

    public void ajouter(Etape ... etapes){
        this.lesEtapes.ajouter(etapes);
    }

    public int nbEtapes(){
        return this.lesEtapes.nbEtapes()+2;
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

        ligne.append(sasEntree.toDefine());
        ligne.append(sasSortie.toDefine());

        ligne.append(sasEntree.toSem());

        ligne.append("void simulation(int ids){\n");

        ligne.append(sasEntree.toC());

        ligne.append("}");

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
