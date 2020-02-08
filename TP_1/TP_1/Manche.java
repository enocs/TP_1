package TP_1;

import java.util.Arrays;

/**
 * Cette classe assurer toute les opérations (ou manoeuvres ) de l'on desire faire sur le manche telles que :
 *
 *      - initialisaser le manche avec la methode : initialiserManche();
 *      - placer une note sur le manche avec la méthode : placerNoteSurManche(boolean[][] manche, int note);
 *      - placerValeurDansTableau(int noCorde, int noFrette);
 *      - placerCaseVide(int noCorde, int noFrette);
 *      - afficherNoteSurManche(boolean[][] manche);
 *      - placerGammeSurManche(boolean[][] manche, int note, int sortGamme);
 *
 *      @autor : < Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
 *  *          < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
 *
 */
public class Manche {

    //Le tableau contenant les differents états des frettes
    public static boolean[][] manche = new boolean[Constante.NB_CORDE][Constante.NB_FRETTES];

    /**
     * Cette methode permet de réinitaliser le manche à "false" à chaque fois qu'elle est appelée.
     *
     * @autor : < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
     */
    public static void initialiserManche(){

        for (boolean[] corde : manche) {
            Arrays.fill(corde, false);
        }
    }

    /**
     * Cette méthode permet de placer les différents emplacements d'une note sur le manche.
     * l'utilisateur fait un choix de note et ensuite cette note est placée à ses differents emplacement du manche
     * @param manche : le manche à compléter
     * @param note : la note choisie par l'utilisateur
     *
     * @autor : < Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
     */
    public static void placerNoteSurManche(boolean[][] manche, int note){

        int tonique;
        for (int i = 0; i < Constante.NB_CORDE; i++){
            //On se place à l'indice de chaque tonique sur les différents octaves
            tonique = Constante.TAB_NOTES[note - 1][i];

            for (int j = tonique; j < Constante.NB_FRETTES; j += Constante.MAX_NOTE){
                    manche[i][j] = true;
            }
        }
    }

    /**
     * Cette methode permet d'afficher la valeur d'une case dans le tableau. Elle prend en paramètre le numéro de
     * corde et de la frette et place la valeur sous la forme " | x | "
     * @param noCorde : la corde sur laquelle on se trouve
     * @param noFrette : L'indice de la frette sur laquelle onse trouve
     *
     * @autor : < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
     */
    public static void placerValeurDansTableau(int noCorde, int noFrette){

        if (noFrette == 0){
            System.out.printf("%d%d", noFrette, noCorde + 1);
        }
        else if (noFrette == Constante.NB_FRETTES - 1){
            System.out.printf("| %2s", noFrette + " |");
        }
        else {
            System.out.printf("| %2s ", noFrette);
        }
    }

    /**
     * Cette methode permet d'afficher une case vide dans le tableau. Elle prend en paramètre le numéro de corde et de
     * la frette et place une case vide de la forme " |___| "
     * @param noCorde : la corde sur laquelle on se trouve
     * @param noFrette : L'indice de la frette sur laquelle onse trouve
     *
     * @autor :< Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
     */
    public static void placerCaseVide(int noCorde, int noFrette){
        if (noFrette == 0){
            System.out.printf("%2d", noCorde + 1);
        }
        else if (noFrette != Constante.NB_FRETTES - 1) {
            System.out.print("|____");
        }
        else {
            System.out.print("|____|");
        }
    }

    /**
     * Cette méthode affiche les indices des différents emplacements d'une note sur le manche. Elle affiche l'indice
     * si la note appartient à l'emplacement et laisse un vide si ce n'est pas le cas.
     * @param manche : le manche à afficher
     *
     * @autor : < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
     */
    public static void afficherNoteSurManche(boolean[][] manche) {
        //saut de ligne
        System.out.println("");

        for (int i = 0; i < Constante.NB_CORDE; i++) {

            for (int j = 0; j < Constante.NB_FRETTES; j++) {

                if (manche[i][j]) {
                    placerValeurDansTableau(i, j);

                } else {
                    placerCaseVide(i, j);

                }
            }
            //retour à la ligne
            System.out.println("\n");
        }
    }

    /**
     * Cette méthode affiche les indices des différents emplacements des notes appartenant à la même gamme.
     * Elle se fie au tableau des gamme et trace la gamme en fonction de la formule :
     *          {TON, TON, DEMI_TON, TON, TON, TON, DEMI_TON} -------> gamme majeure
     *          {TON, DEMI_TON, TON, TON, DEMI_TON, TON, TON} -------> gamme mineure
     * @param manche : le manche à afficher
     * @param note : la gamme à tracer
     * @param sortGamme : le type de gamme (majeure ou mineure)
     *
     * @autor : < Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
     */
    public static void placerGammeSurManche(boolean[][] manche, int note, int sortGamme){

        note = note - 1;

        for (int j = 0; j < Constante.NB_NOTE_GAMME; j++) {
            placerNoteSurManche(manche, note + 1);
            note = (note + Constante.TAB_GAMMES[sortGamme - 1][j]) % 12;
        }

    }

}
