package TP_1;

/**
 * Cette classe permet de gérer l'affichage des menus et aussi de faire la gestion des procedures tel que demandé
 *
 * @autor : < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
 *          < Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
 */
public class Menu {

    /**
     * Cette methode affiche le menu principal de la manière suivante :
     *      • Menu principal :
     *          1. Afficher une note
     *          2. Afficher une gamme
     *          3. Quitter
     *
     * @autor : < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
     */
    public static String menuPrincipal() {

        return Constante.MENU_PRINCIPAL;

    }

    /**
     * Cette methode affiche le menu des 12 notes allant de DO à SI de la manière suivante :
     *      • Menu note
     *          1. Do                                   7.  Fa dièse
     *          2. Do dièse                             8.  Sol
     *          3. Ré                                   9.  Sol dièse
     *          4. Ré dièse                             10. La
     *          5. Mi                                   11. La dièse
     *          6. Fa                                   12. Si
     *                          13. Quitter
     *
     * @autor : < Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
     */
    public static String menuNote(){

        return Constante.MENU_NOTE;
    }

    /**
     * Cette methode affiche le menu principal de la manière suivante :
     *      • Menu Gamme :
     *          1. Majeure
     *          2. Mineure
     *          3. Quitter
     *
     * @autor : < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
     */
    public static String menuGamme(){

        return Constante.MENU_GAMME;
    }

    /**
     * Cette méthode presente une briève description du logiciel sous la forme suivante :
     *      ---------------------------------------------------------------
     *      | logiciel permettant à des apprentis guitaristes d’apprendre |
     *      | leurs gammes ainsi que la position des notes sur un  manche |
     *      |                        de guitare.                          |
     *      ---------------------------------------------------------------
     *
     * @autor : < Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
     */
    public static void presentationLogiciel(){
        System.out.println(Constante.MSG_PRESENTATION);
    }

    /**
     * Cette methode permet de faire la gestion de l'affichage d'une note sur le manche. Elle reçoit en paramètre le
     * choix de l'utilisateur et en fonction de ce choix elle affiche les différents emplacements de cette note sur le
     * manche.
     * @param choix : le choix de l'utilisateur
     *
     * @autor : < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
     */
    public static void gestionAffichageNote(int choix){

        while (choix != Constante.CHOIX_QUITTER_NOTE){

            //Affiche le menu de note, recupère le choix de l'utilisateur et s'assure qu'il est valide
            choix = verifierAnnulation(menuPrincipal() + Constante.MSG_SOL, Constante.MIN,
                    Constante.CHOIX_QUITTER_NOTE);

            if (choix != Constante.CHOIX_QUITTER_NOTE){
                Manche.placerNoteSurManche(Manche.manche, choix);
                Manche.afficherNoteSurManche(Manche.manche);
                UtilitaireValidation.pause();
            }
            Manche.initialiserManche();
        }
    }

    /**
     * Cette methode permet de faire la gestion de l'affichage des notes d'une gamme sur le manche. Elle reçoit en
     * paramètre le choix de l'utilisateur et en fonction de ce choix elle place et affiche les différents emplacements
     * des notes de cette gamme sur le manche.
     * NB : juste les gammes majeures et mineures sont prises en charge par cette méthode
     * @param choix : le choix de l'utilisateur
     *
     * @autor : < Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
     */
    public static void gestionAffichageGamme(int choix){

        while (choix != Constante.CHOIX_QUITTER_NOTE){

            int choixGamme;

            //Affiche le menu de note, recupère le choix de l'utilisateur et s'assure qu'il est valide
            choix = verifierAnnulation(menuNote() + Constante.MSG_SOL,
                    Constante.MIN, Constante.CHOIX_QUITTER_NOTE);

            if (choix != Constante.CHOIX_QUITTER_NOTE){

                //Affiche le menude gamme, recupère le choix de l'utilisateur et s'assure qu'il est valide
                choixGamme = verifierAnnulation(menuGamme() + Constante.MSG_SOL,
                             Constante.MIN, Constante.CHOIX_QUITTER_GAMME);

                if (choixGamme != Constante.CHOIX_QUITTER_GAMME){
                    Manche.placerGammeSurManche(Manche.manche, choix, choixGamme);
                    Manche.afficherNoteSurManche(Manche.manche);
                    UtilitaireValidation.pause();
                }
            }
            Manche.initialiserManche();
        }
    }

    /**
     * Cette méthode permet de faire un validation des saisie de l'utilisateur. Si l'utilisateur fait <Enter> sans
     * rien saisir au préalable, la méthode évite que le système plante et redemande à l'utilisateur de faire une
     * saisie
     *
     * @param msg : Le message de sollicitation
     * @param min : la valeur minimum des valeurs possibles
     * @param max : La valer max des valeurs possibles
     * @return : le choix valide de l'utilisateur.
     *
     * @autor : < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
     */
    public static int verifierAnnulation( String msg, int min, int max){

        int choix;

        do {
            UtilitaireValidation.reinitialise();
            choix = UtilitaireValidation.lireInt(msg, min, max);
        }

        while (UtilitaireValidation.utilisateurAnnule());

        return choix;
    }

    /**
     * Programme principal permettant d'exécuter le logitiel d'apprentissage selon les exigences demandées.
     * @param args
     *
     * @autor : < Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
     */
    public static void main(String[] args) {

        int choix = 0;

        //Afficher une briève présentation du logiciel
        presentationLogiciel();

        while (choix != Constante.CHOIX_QUITTER){

            //initialiser le manche
            Manche.initialiserManche();

            //afficher le menu principal
            //soliciter, recupérer et vérifier le choix de l'utilisateur
            choix = verifierAnnulation(menuPrincipal() + Constante.MSG_SOL, Constante.MIN, Constante.MAX);

            if (choix != Constante.CHOIX_QUITTER){

                if (choix == Constante.CHOIX_MENU_NOTE){
                    //gestion de la procedure d'affichage d'une note
                    gestionAffichageNote(choix);
                }
                else {
                    //gestion de la procedure d'affichage d'une gamme
                    gestionAffichageGamme(choix);
                }
            }
        }
        System.out.println(Constante.MSG_FIN);
    }

}
