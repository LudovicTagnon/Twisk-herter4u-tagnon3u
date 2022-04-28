package twisk.monde;

public class Activite extends Etape{

    protected int temps;
    protected int ecartTemps;

    public Activite(String nom) {
        super(nom);
        this.temps = 5;
        this.ecartTemps = 3;
    }


    public Activite(String nom, int temps, int ecartTemps) {
        super(nom);
        this.temps = temps;
        this.ecartTemps = ecartTemps;
    }

    public boolean estUneActivite(){
        return true;
    }

    @Override
    public String toDefine() {
        for(Etape suivant : gestSucc){
            ligneDefine.append("#define " + this.changementNom() + " " + this.cptEtape + "\n" );
            ligneDefine.append(suivant.toDefine());
        }
        return String.valueOf(ligneDefine);
    }

    @Override
    public String toC(){
        for(Etape suivant : gestSucc){
            ligne.append( "\ttransfert(" + this.changementNom() + ", " + suivant.changementNom() + ");\n" );
            if(!suivant.estUnGuichet() && !suivant.estUneSortie()){
                ligne.append("\tdelai(" + suivant.getTemps() + ", " + suivant.getEcartTemps() + ");\n");
            }
            ligne.append(suivant.toC());
        }
        return String.valueOf(ligne);
    }

    @Override
    public String toSem(){

        for(Etape suivant: gestSucc){
            ligneSem.append(suivant.toSem());
        }
        return String.valueOf(ligneSem);
    }

    @Override
    public int getTemps() {
        return temps;
    }

    @Override
    public int getEcartTemps() {
        return ecartTemps;
    }


}
