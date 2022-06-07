package twisk.mondeIG;

import twisk.exceptions.MondeException;
import twisk.exceptions.TwiskException;
import twisk.monde.*;
import twisk.outils.*;
import twisk.simulation.Client;
import twisk.simulation.GestionnaireClients;
import twisk.vues.Observateur;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Monde ig.
 */
public class MondeIG extends SujetObserve implements Observateur,Iterable<EtapeIG>{

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

    private boolean simLance;


    /**
     * Instantiates a new Monde ig.
     */
    public MondeIG(){
        etapes = new HashMap<>();

        arc = new ArrayList<>();
        etapeSelectionnes = new ArrayList<>();
        arcSelectionnes = new ArrayList<>();

        simLance = false;

        this.ajouter("Activité");
    }

    /**
     * Gets depart.
     *
     * @return the depart
     */
    public PointDeControleIG getDepart() {
        return depart;
    }

    /**
     * Gets arrivee.
     *
     * @return the arrivee
     */
    public PointDeControleIG getArrivee() {
        return arrivee;
    }

    /**
     * Sets nom premiere etape selectionnee.
     *
     * @param nom the nom
     */
    public void setNomPremiereEtapeSelectionnee(String nom) {
        this.etapeSelectionnes.get(0).setNom(nom);
        this.notifierObservateur();
    }

    /**
     * Get premiere etape etape ig.
     *
     * @return the etape ig
     */
    public EtapeIG getPremiereEtape(){
        return this.etapeSelectionnes.get(0);
    }

    /**
     * Gets nom premiere etape selectionnee.
     *
     * @return the nom premiere etape selectionnee
     */
    public String getNomPremiereEtapeSelectionnee() {
        return this.getPremiereEtape().getNom();
    }

    /**
     * Gets identifiant premiere etape selectionnee.
     *
     * @return the identifiant premiere etape selectionnee
     */
    public String getIdentifiantPremiereEtapeSelectionnee() {
        return this.etapeSelectionnes.get(0).getIdentifiant();
    }

    /**
     * Sets depart.
     *
     * @param depart the depart
     */
    public void setDepart(PointDeControleIG depart) {
        this.depart = depart;
    }

    /**
     * Sets arrivee.
     *
     * @param arrivee the arrivee
     */
    public void setArrivee(PointDeControleIG arrivee) {
        this.arrivee = arrivee;
    }

    /**
     * Ajouter.
     *
     * @param type the type
     */
    public void ajouter(String type) {
        if(type.equals("Activité")){
            FabriqueIdentifiant fabId = FabriqueIdentifiant.getInstance();
            String idAct = fabId.getIdentifiantEtape();

            TailleComposants tailleComposants = TailleComposants.getInstance();

            ActiviteIG activiteIG = new ActiviteIG("Activite " + idAct.substring(5) , idAct, tailleComposants.getTailleXAct(), tailleComposants.getTailleYAct());
            activiteIG.setDelaiEcartTemps(5, 2);
            etapes.put(idAct, activiteIG);
        }
        else if (type.equals("Guichet")) {
            FabriqueIdentifiant fabId = FabriqueIdentifiant.getInstance();
            String idGui = fabId.getIdentifiantGuichet();

            TailleComposants tailleComposants = TailleComposants.getInstance();

            GuichetIG guichetIG = new GuichetIG("Guichet " + idGui.substring(7) , idGui, tailleComposants.getTailleXGui(), tailleComposants.getTailleYGui());
            guichetIG.setJeton(2);
            etapes.put(idGui, guichetIG);
        }

        this.notifierObservateur();
    }

    /**
     * Ajouter.
     *
     * @param pt1 the pt 1
     * @param pt2 the pt 2
     * @throws TwiskException the twisk exception
     */
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

    /**
     * Set pos etape.
     *
     * @param id   the id
     * @param posX the pos x
     * @param posY the pos y
     */
    public void setPosEtape(String id, int posX, int posY){
        this.etapes.get(id).setPos(posX, posY);
        this.notifierObservateur();
    }

    /**
     * Ajouter selection etape.
     *
     * @param etapeIG the etape ig
     */
    public void ajouterSelectionEtape(EtapeIG etapeIG){
        this.etapeSelectionnes.add(etapeIG);
        this.notifierObservateur();
    }

    /**
     * Enlever selection etape.
     *
     * @param etapeIG the etape ig
     */
    public void enleverSelectionEtape(EtapeIG etapeIG){
        this.etapeSelectionnes.remove(etapeIG);
        this.notifierObservateur();
    }

    /**
     * Enlever toute selection etape.
     */
    public void enleverTouteSelectionEtape(){
        this.etapeSelectionnes.clear();
        this.notifierObservateur();
    }

    /**
     * Est selectionnee etape boolean.
     *
     * @param etapeIG the etape ig
     * @return the boolean
     */
    public boolean estSelectionneeEtape(EtapeIG etapeIG){
        for (EtapeIG etapeSelectionne : this.etapeSelectionnes) {
            if (etapeSelectionne.getIdentifiant().equals(etapeIG.getIdentifiant())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Nb selection etape int.
     *
     * @return the int
     */
    public int nbSelectionEtape(){
        return this.etapeSelectionnes.size();
    }

    /**
     * Supprimer etape.
     *
     * @param etapeIG the etape ig
     */
    public void supprimerEtape(EtapeIG etapeIG){
        this.etapes.remove(etapeIG.getIdentifiant());
        this.notifierObservateur();
    }

    /**
     * Arc rattachee array list.
     *
     * @param etape the etape
     * @return the array list
     */
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

    /**
     * Est selectionnee arc boolean.
     *
     * @param arc the arc
     * @return the boolean
     */
    public boolean estSelectionneeArc(ArcIG arc){
        for (ArcIG arcSelectionne : this.arcSelectionnes) {
            if (arc.getDepart().getEtapeRattachee().getIdentifiant().equals(arcSelectionne.getDepart().getEtapeRattachee().getIdentifiant()) &&
                    arc.getArrivee().getEtapeRattachee().getIdentifiant().equals(arcSelectionne.getArrivee().getEtapeRattachee().getIdentifiant())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ajouter selection arc.
     *
     * @param arc the arc
     */
    public void ajouterSelectionArc(ArcIG arc){
        this.arcSelectionnes.add(arc);
        this.notifierObservateur();
    }

    /**
     * Enlever selection arc.
     *
     * @param arc the arc
     */
    public void enleverSelectionArc(ArcIG arc) {
        this.arcSelectionnes.remove(arc);
        this.notifierObservateur();
    }

    /**
     * Supprimer arc.
     *
     * @param arc the arc
     */
    public void supprimerArc(ArcIG arc){
        arc.getDepart().getEtapeRattachee().enleverSuc(arc.getArrivee().getEtapeRattachee());
        this.arc.remove(arc);
        this.notifierObservateur();
    }

    /**
     * Enlever toute selection arc.
     */
    public void enleverTouteSelectionArc(){
        this.arcSelectionnes.clear();
        this.notifierObservateur();
    }

    /**
     * Changement entree.
     */
    public void changementEntree(){
        for (EtapeIG etapeSelectionne : this.etapeSelectionnes) {
            etapeSelectionne.setEstEntree();
        }

        this.notifierObservateur();
    }

    /**
     * Changement sortie.
     */
    public void changementSortie(){
        for (EtapeIG etapeSelectionne : this.etapeSelectionnes) {
            etapeSelectionne.setEstSortie();
        }
        this.notifierObservateur();
    }

    /**
     * Set delai ecart temps.
     *
     * @param delai      the delai
     * @param ecartTemps the ecart temps
     * @param id         the id
     */
    public void setDelaiEcartTemps(int delai, int ecartTemps, String id){
        this.etapes.get(id).setDelaiEcartTemps(delai, ecartTemps);

        this.notifierObservateur();
    }

    /**
     * Set jetons.
     *
     * @param nbJetons the nb jetons
     * @param id       the id
     */
    public void setJetons(int nbJetons, String id){
        this.etapes.get(id).setJeton(nbJetons);

        this.notifierObservateur();
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return this.etapes.values().iterator();
    }

    /**
     * Iterator arc iterator.
     *
     * @return the iterator
     */
    public Iterator<ArcIG> iteratorArc() {
        return this.arc.iterator();
    }

    /**
     * Iterator etapes selectionnees iterator.
     *
     * @return the iterator
     */
    public Iterator<EtapeIG> iteratorEtapesSelectionnees() {
        return this.etapeSelectionnes.iterator();
    }

    /**
     * Iterator arc selectionnees iterator.
     *
     * @return the iterator
     */
    public Iterator<ArcIG> iteratorArcSelectionnees(){
        return this.arcSelectionnes.iterator();
    }

    /**
     * Iterator client iterator.
     *
     * @return the iterator
     */
    public Iterator<Client> iteratorClient(){
        GestionnaireClients ge = null;
        try{
            Method methode = classeSimulation.getMethod("getGestClients()");
            ge = (GestionnaireClients) methode.invoke(simulation);
        }
        catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return ge.iterator();
    }

    /**
     * Simuler.
     *
     * @throws MondeException the monde exception
     */
    public void simuler() throws MondeException {
        if(this.verifierMondeIG()){
            this.simLance = true;
            Monde monde = this.creerMonde();

            try {
                clPerso = new ClassLoaderPerso(this.getClass().getClassLoader());

                classeSimulation = clPerso.loadClass("twisk.simulation.Simulation");
                simulation = classeSimulation.newInstance();

                Method setNbClients = classeSimulation.getMethod("setNbClients", int.class);
                setNbClients.invoke(simulation, 5);

                Method methode = classeSimulation.getMethod("simuler", Monde.class);
                methode.invoke(simulation, monde);

                FabriqueNumero.getInstance().setNbMonde();
                this.simLance = false;

            } catch (ClassNotFoundException | InstantiationException | InvocationTargetException |
                     NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    private boolean verifierMondeIG() throws MondeException{
        // vérifie 3 conditions: 1) existe une seule entrée
        // 2) il existe au moins 1 chemin entre l'entrée et la sortie
        // 3) rendre restreintes les activités après les guichets

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

        for (EtapeIG etapeIG : this){
            Etape etape;

            if (etapeIG.estUneActiviteRestreinte()){
                etape = new ActiviteRestreinte(etapeIG.getIdentifiant(), etapeIG.getDelai(), etapeIG.getEcartTemps());
            } else if (etapeIG.estUneActivite()) {
                etape = new Activite(etapeIG.getIdentifiant(), etapeIG.getDelai(), etapeIG.getEcartTemps());
            }else{      //Guichet
                etape = new Guichet(etapeIG.getIdentifiant(), etapeIG.getNbJetons());
            }
            monde.ajouter(etape);

            if(etapeIG.estEntree){
                monde.aCommeEntree(etape);
            }else if(etapeIG.estSortie){
                monde.aCommeSortie(etape);
            }

            correspondance.ajouter(etapeIG, etape);
        }

        for(EtapeIG etapeIG : this){
            if(etapeIG.aUnSucc()){
                for(EtapeIG succ : etapeIG.successeurs){
                    this.correspondance.getEtape(etapeIG).ajouterSuccesseur(this.correspondance.getEtape(succ));
                }
            }
        }

        return monde;
    }

    @Override
    public void reagir() {
        this.notifierObservateur();
    }

    /**
     * Gets classe simulation.
     *
     * @return the classe simulation
     */
    public Class<?> getClasseSimulation() {
        return classeSimulation;
    }

    /**
     * Is sim lance boolean.
     *
     * @return the boolean
     */
    public boolean isSimLance() {
        return simLance;
    }

    /**
     * Gets etapes.
     *
     * @return the etapes
     */
    public HashMap<String, EtapeIG> getEtapes() {
        return etapes;
    }

    /**
     * Gets correspondance.
     *
     * @return the correspondance
     */
    public CorrespondanceEtapes getCorrespondance() {
        return correspondance;
    }
}
