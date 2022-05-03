package twisk.mondeIG;

import twisk.outils.SujetObserve;
import twisk.exceptions.TwiskException;
import twisk.outils.FabriqueIdentifiant;
import twisk.outils.TailleComposants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG>{
    private HashMap<String,EtapeIG> etapes;

    private ArrayList<ArcIG> arc;
    private ArrayList<EtapeIG> etapeSelectionnes;
    private ArrayList<ArcIG> arcSelectionnes;

    private PointDeControleIG depart;
    private PointDeControleIG arrivee;

    public MondeIG(){
        etapes = new HashMap<>();

        arc = new ArrayList<>();
        etapeSelectionnes = new ArrayList<>();
        arcSelectionnes = new ArrayList<>();

        this.ajouter("Activité");
    }

    public PointDeControleIG getDepart() {
        return depart;
    }

    public PointDeControleIG getArrivee() {
        return arrivee;
    }

    public void setNomPremiereEtapeSelectionnee(String nom) {
        this.etapeSelectionnes.get(0).setNom(nom);
        this.notifierObservateur();
    }

    public String getNomPremiereEtapeSelectionnee() {
        return this.etapeSelectionnes.get(0).getNom();
    }

    public String getIdentifiantPremiereEtapeSelectionnee() {
        return this.etapeSelectionnes.get(0).getIdentifiant();
    }

    public void setDepart(PointDeControleIG depart) {
        this.depart = depart;
    }

    public void setArrivee(PointDeControleIG arrivee) {
        this.arrivee = arrivee;
    }

    public void ajouter(String type){
        if(type.equals("Activité")){
            FabriqueIdentifiant fabId = FabriqueIdentifiant.getInstance();
            String idAct = fabId.getIdentifiantEtape();

            TailleComposants tailleComposants = TailleComposants.getInstance();

            ActiviteIG activiteIG = new ActiviteIG("Activite " + idAct.substring(5) , idAct, tailleComposants.getTailleXAct(), tailleComposants.getTailleYAct());
            etapes.put(idAct, activiteIG);
        }
        this.notifierObservateur();
    }

    public void ajouter(PointDeControleIG pt1, PointDeControleIG pt2) throws TwiskException {
        this.depart = pt1;
        this.arrivee = pt2;

        boolean valide = true;

        Iterator<ArcIG> it = this.iteratorArc();
        while (it.hasNext()){
            ArcIG arcIG = it.next();

            if(pt1.getEtapeRattachee().getIdentifiant().equals(arcIG.getDepart().getEtapeRattachee().getIdentifiant()) && pt2.getEtapeRattachee().getIdentifiant().equals(arcIG.getArrivee().getEtapeRattachee().getIdentifiant())){
                valide = false;
            }else if(pt2.getEtapeRattachee().getIdentifiant().equals(arcIG.getDepart().getEtapeRattachee().getIdentifiant()) && pt1.getEtapeRattachee().getIdentifiant().equals(arcIG.getArrivee().getEtapeRattachee().getIdentifiant())){
                valide = false;
            }
        }

        if(pt1.getEtapeRattachee().getIdentifiant().equals(pt2.getEtapeRattachee().getIdentifiant())) {
            this.depart = null;
            throw new TwiskException("On ne peut pas rattaché un arc sur la même étape");
        }else if(!valide){
            this.depart = null;
            throw new TwiskException("Erreur : On ne peut pas rattaché 2 fois les meme étapes");
        }else{
            this.arc.add(new ArcIG(this.depart, this.arrivee));
        }

        this.depart = null;

        this.notifierObservateur();
    }

    public void setPosEtape(String id, int posX, int posY){
        this.etapes.get(id).setPos(posX, posY);
        this.notifierObservateur();
    }

    public void ajouterSelectionEtape(EtapeIG etapeIG){
        this.etapeSelectionnes.add(etapeIG);
        this.notifierObservateur();
    }

    public void enleverSelectionEtape(EtapeIG etapeIG){
        this.etapeSelectionnes.remove(etapeIG);
        this.notifierObservateur();
    }

    public void enleverTouteSelectionEtape(){
        this.etapeSelectionnes.clear();
        this.notifierObservateur();
    }

    public boolean estSelectionneeEtape(EtapeIG etapeIG){
        for (EtapeIG etapeSelectionne : this.etapeSelectionnes) {
            if (etapeSelectionne.getIdentifiant().equals(etapeIG.getIdentifiant())) {
                return true;
            }
        }
        return false;
    }

    public int nbSelectionEtape(){
        return this.etapeSelectionnes.size();
    }

    public void supprimerEtape(EtapeIG etapeIG){
        this.etapes.remove(etapeIG.getIdentifiant());
        this.notifierObservateur();
    }

    public ArrayList<ArcIG> arcRattachee(EtapeIG etape){
        ArrayList<ArcIG> listArc = new ArrayList<>();
        for (ArcIG arcIG : this.arc) {
            if (arcIG.getArrivee().getEtapeRattachee().getIdentifiant().equals(etape.getIdentifiant())) {
                listArc.add(arcIG);
            }
            if (arcIG.getDepart().getEtapeRattachee().getIdentifiant().equals(etape.getIdentifiant())) {
                listArc.add(arcIG);
            }
        }
        return  listArc;
    }

    public boolean estSelectionneeArc(ArcIG arc){
        for (int i = 0; i < this.arcSelectionnes.size(); i++) {
            if (arc.getDepart().getEtapeRattachee().getIdentifiant().equals(this.arcSelectionnes.get(i).getDepart().getEtapeRattachee().getIdentifiant()) &&
                    arc.getArrivee().getEtapeRattachee().getIdentifiant().equals(this.arcSelectionnes.get(i).getArrivee().getEtapeRattachee().getIdentifiant())){
                return true;
            }
        }
        return false;
    }

    public void ajouterSelectionArc(ArcIG arc){
        this.arcSelectionnes.add(arc);
        this.notifierObservateur();
    }

    public void enleverSelectionArc(ArcIG arc) {
        this.arcSelectionnes.remove(arc);
        this.notifierObservateur();
    }

    public void supprimerArc(ArcIG arc){
        this.arc.remove(arc);
        this.notifierObservateur();
    }

    public void enleverTouteSelectionArc(){
        this.arcSelectionnes.clear();
        this.notifierObservateur();
    }

    public void changementEntree(){
        for (int i = 0; i < this.etapeSelectionnes.size(); i++) {
            this.etapeSelectionnes.get(i).setEstEntree(!this.etapeSelectionnes.get(i).getEstEntree());
        }
        this.notifierObservateur();
    }

    public void changementSortie(){
        for (int i = 0; i < this.etapeSelectionnes.size(); i++) {
            this.etapeSelectionnes.get(i).setEstSortie(!this.etapeSelectionnes.get(i).getEstSortie());
        }
        this.notifierObservateur();
    }

    public void setDelaiEcartTemps(int delai, int ecartTemps, String id){
        this.etapes.get(id).setDelaiEcartTemps(delai, ecartTemps);

        this.notifierObservateur();
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return this.etapes.values().iterator();
    }

    public Iterator<ArcIG> iteratorArc() {
        return this.arc.iterator();
    }

    public Iterator<EtapeIG> iteratorEtapesSelectionnees() {
        return this.etapeSelectionnes.iterator();
    }

    public Iterator<ArcIG> iteratorArcSelectionnees(){
        return this.arcSelectionnes.iterator();
    }
}
