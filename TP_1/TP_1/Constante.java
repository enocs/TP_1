package TP_1;

/**
 * Cette classe contient toutes les constantes necéssaires pour faire pour:
 *
 *      - l'affichage des différents menus,
 *      - l'affichage des différents messages,
 *      - les constantes concertant la musique telles que le tableau des accords et celui des gammes.
 *
 * Par souci de clarté du code nous avons décidé de réunir toutes les constantes dans une seule classe
 * afin de faciliter la gestion et l'organisation du code.
 *
 * @autor : < Enoc Soulama > < madahaye-enoc.soulama.1@ens.etsmtl.ca >
 *          < Garik Batista > < garik.batista.1@ens.etsmtl.ca >
 */
public class Constante {

    //Les informations fixes sur la guitare
    public static final int NB_CORDE = 6;
    public static final int MAX_NOTE = 12;
    public static final int NB_NOTE_GAMME = 7;
    public static final int NB_FRETTES = 25;
    public static final int TON = 2;
    public static final int DEMI_TON = 1;

    //Les choix menu
    public static final int CHOIX_MENU_NOTE  = 1;
    public static final int CHOIX_QUITTER_NOTE  = 13;
    public static final int CHOIX_QUITTER       = 3;
    public static final int CHOIX_QUITTER_GAMME = 3;
    public static final int MIN = 1;
    public static final int MAX = 3;

    //Message d'affichage du menu
    public static final String MENU_PRINCIPAL = "\n• Menu principal : " +
                                                "\n\t1. Afficher une note	" +
                                                "\n\t2. Afficher une gamme	" +
                                                "\n\t3. Quitter			\n";

    public static final String MENU_NOTE      = "\n• Menu note :" +
                                                "\n\t1.  Do                               	7.  Fa#	 " +
                                                "\n\t2.  Do#                               	8.  Sol	 " +
                                                "\n\t3.  Re                               	9.  Sol# " +
                                                "\n\t4.  Re#                               	10. La	 " +
                                                "\n\t5.  Mi                               	11. La#	 " +
                                                "\n\t6.  Fa                               	12. Si	 " +
                                                "\n\t                 13. Quitter			 \n";

    public static final String MENU_GAMME     = "\n• Menu Gamme :" +
                                                "\n\t1. Majeur	  " +
                                                "\n\t2. Mineur	  " +
                                                "\n\t3. Quitter	  \n";

    //Les messages
    public static final String MSG_SOL = "Entrez votre choix svp ";

    public static final String MSG_FIN  = "\n+-------------------------------------------------------------+\n" +
                                          "\n+                  Merci et à la prochaine                    +\n" +
                                          "\n+-------------------------------------------------------------+\n";

    public static final String MSG_PRESENTATION ="\n---------------------------------------------------------------\n" +
                                                   "| logiciel permettant à des apprentis guitaristes d’apprendre |\n" +
                                                   "| leurs gammes ainsi que la position des notes sur un  manche |\n" +
                                                   "|                        de guitare.                          |\n" +
                                                   "---------------------------------------------------------------\n";



    //GAMME[0][] indice 0; GAMME[1][] indice 1;
    public static final int[][] TAB_GAMMES = {{TON, TON, DEMI_TON, TON, TON, TON, DEMI_TON},
                                              {TON, DEMI_TON, TON, TON, DEMI_TON, TON, TON}};

    //Les colonnes representent les cordes et les lignes representent les notes
    //Ainsi le chiffre represente la position de la note sur la corde
    public static final int[][] TAB_NOTES  = {    {   8  , 1 , 5 , 10, 3 , 8  },
                                                  {   9  , 2 , 6 , 11, 4 , 9  },
                                                  {   10 , 3 , 7 , 0 , 5 , 10 },
                                                  {   11 , 4 , 8 , 1 , 6 , 11 },
                                                  {   0  , 5 , 9 , 2 , 7 , 0  },
                                                  {   1  , 6 , 10, 3 , 8 , 1  },
                                                  {   2  , 7 , 11, 4 , 9 , 2  },
                                                  {   3  , 8 , 0 , 5 , 10, 3  },
                                                  {   4  , 9 , 1 , 6 , 11, 4  },
                                                  {   5  , 10, 2 , 7 , 0 , 5  },
                                                  {   6  , 11, 3 , 8 , 1 , 6  },
                                                  {   7  , 0 , 4 , 9 , 2 , 7  }      };

}
