package twisk.mondeIG;

import twisk.exceptions.MondeException;
import twisk.monde.*;
import twisk.outils.*;
import twisk.exceptions.TwiskException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    private Object simulation;
    private Class<?> classeSimulation;
    private ClassLoaderPerso clPerso;

    private CorrespondanceEtapes correspondance;

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

    public EtapeIG getPremiereEtape(){
        return this.etapeSelectionnes.get(0);
    }

    public String getNomPremiereEtapeSelectionnee() {
        return this.getPremiereEtape().getNom();
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

    public void ajouter(String type) {
        if(type.equals("Activité")){
            FabriqueIdentifiant fabId = FabriqueIdentifiant.getInstance();
            String idAct = fabId.getIdentifiantEtape();

            TailleComposants tailleComposants = TailleComposants.getInstance();

            ActiviteIG activiteIG = new ActiviteIG("Activite " + idAct.substring(5) , idAct, tailleComposants.getTailleXAct(), tailleComposants.getTailleYAct());
            etapes.put(idAct, activiteIG);
        }
        else if (type.equals("Guichet")) {
            FabriqueIdentifiant fabId = FabriqueIdentifiant.getInstance();
            String idGui = fabId.getIdentifiantGuichet();

            TailleComposants tailleComposants = TailleComposants.getInstance();

            GuichetIG guichetIG = new GuichetIG("Guichet " + idGui.substring(7) , idGui, tailleComposants.getTailleXGui(), tailleComposants.getTailleYGui());
            etapes.put(idGui, guichetIG);
        }

        System.out.println(etapes);
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

        pt1.getEtapeRattachee().ajouterSuc(pt2.getEtapeRattachee());

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
        for (ArcIG arcSelectionne : this.arcSelectionnes) {
            if (arc.getDepart().getEtapeRattachee().getIdentifiant().equals(arcSelectionne.getDepart().getEtapeRattachee().getIdentifiant()) &&
                    arc.getArrivee().getEtapeRattachee().getIdentifiant().equals(arcSelectionne.getArrivee().getEtapeRattachee().getIdentifiant())) {
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
        arc.getDepart().getEtapeRattachee().enleverSuc(arc.getArrivee().getEtapeRattachee());
        this.arc.remove(arc);
        this.notifierObservateur();
    }

    public void enleverTouteSelectionArc(){
        this.arcSelectionnes.clear();
        this.notifierObservateur();
    }

    public void changementEntree(){
        for (EtapeIG etapeSelectionne : this.etapeSelectionnes) {
            etapeSelectionne.setEstEntree();
        }

        this.notifierObservateur();
    }

    public void changementSortie(){
        for (EtapeIG etapeSelectionne : this.etapeSelectionnes) {
            etapeSelectionne.setEstSortie();
        }
        this.notifierObservateur();
    }

    public void setDelaiEcartTemps(int delai, int ecartTemps, String id){
        this.etapes.get(id).setDelaiEcartTemps(delai, ecartTemps);

        this.notifierObservateur();
    }

    public void setJetons(int nbJetons, String id){
        this.etapes.get(id).setJeton(nbJetons);

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

    public void simuler() throws MondeException {
        if(this.verifierMondeIG()==true){
            Monde monde = this.creerMonde();

            clPerso = new ClassLoaderPerso(this.getClass().getClassLoader());

            try {
                classeSimulation = clPerso.loadClass("twisk.simulation.Simulation");
                simulation = classeSimulation.getDeclaredConstructor().newInstance();
                Method methode = classeSimulation.getMethod("simuler", Monde.class);
                Method setNbClients = classeSimulation.getMethod("setNbClients", int.class);

                setNbClients.invoke(simulation, 5);
                methode.invoke(simulation, monde);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }



    }

    private boolean verifierMondeIG() throws MondeException{
        // vérifie 3 conditions: 1) existe une seule entrée
        // 2) il existe au moins 1 chemin entre l'entrée et la sortie
        // 3) rendre restraintes les activités après les guichets

        boolean flagEntree = false;
        boolean flagSortie = false;


        for (EtapeIG e: etapes.values()) {
            if (e.estEntree){
                if(flagEntree){
                    throw new MondeException("Il ne doit y avoir qu'une seule entrée.");
                }else{
                    flagEntree = true;

                    if(!e.aUneSortie()){
                        throw new MondeException("L'entrée doit être connecté à une sortie");
                    }

                    e.ajoutActRestreinte(); //vérifie et transforme vers restreint
                }
            }
            if (e.estSortie){
                flagSortie = true;
            }
        }
        if(!flagEntree || !flagSortie){
            throw new MondeException("Il doit y avoir 1 seule entrée et au moins 1 sortie.");

        }
        return flagEntree && flagSortie;
    }

    private Monde creerMonde() throws MondeException{
        Monde monde = new Monde();
        correspondance = new CorrespondanceEtapes();

        for (EtapeIG eg: this){
            Etape e = null;
            if(eg.estUnGuichet()){
                e = new Guichet(eg.identifiant);
            }else if(eg.estUneActiviteRestreinte()){
                e = new ActiviteRestreinte(eg.identifiant);
            }else if(eg.estUneActivite()){
                e = new Activite(eg.identifiant);
            }

            if(eg.estEntree){
                monde.aCommeEntree(e);
            }
            else if(eg.estSortie){
                monde.aCommeSortie(e);
            }

            monde.ajouter(e);
            correspondance.ajouter(eg, e);

        }

        return monde;
    }
}