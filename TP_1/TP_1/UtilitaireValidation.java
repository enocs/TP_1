package TP_1;

import java.util.Scanner;

/**
 * Classe qui permet de lire et valider des valeurs en provenance de la console.
 *
 * @author <a href = "mailto:Pierre.belisle@etsmtl.ca"> Pierre Bélisle</a>
 * @version Révisé H2020
 */
public class UtilitaireValidation {

   // Sert à retenir si l'utilisateur a annulé.
   private static boolean utilisateurAnnule = false;

   // Pour la lecture au clavier.
   private static Scanner clavier = new Scanner(System.in);


   //-----------------------------
   // LIRE INT
   //-----------------------------
   
   /**
    * Affiche le message reçu et attend l'entrée d'un nombre entier entre les
    * deux bornes (min et max). L'utilisateur annule s'il fait seulement
    * "entrée" Si l'utilisateur annule, la fonction retourne 0 et la fonction
    * utilisateurAnnule() retournera true.
    *
    * @param msg Le message de sollicitation
    * @param min limite inférieure acceptée
    * @param max limite supérieure acceptée
    * @return un entier entre min et max
    */
   public static int lireInt(String msg, int min, int max) {

      // Sert à la saisir.
      String valeurLue = null;

      // Sera mis à true lorsque valide.
      boolean valide = false;

      // Sert à valider le nombre.
      int valInt = 0;

      // Attribut gobal mis à faux.
      utilisateurAnnule = false;

      while (!valide && !utilisateurAnnule) {

         // Sollicitation de l'utilisateur pour la valeur.
         System.out.print(msg + " (<ENTRÉE> pour annuler) : ");

         // On lit toute la ligne.		        
         valeurLue = clavier.nextLine();

         // Si l'utilisateur annule, c'est valide quand même.
         if (valeurLue.equals("")) {
            utilisateurAnnule = true;  
            
         } else {  // Sinon on tente de convertir en entier.

            try {
               // Si on réussit la conversion sans exception.
               valInt = Integer.parseInt(valeurLue);

               // On évalue les bornes.
               if (valInt < min || valInt > max) {
                  System.out.println("\nLa valeur entrée doit être "
                          + "entre " + min + " et " + max + ".");
               } else { // Si on vient ici c'est que tout est beau.
                  valide = true;
               }
               
            // S'il y a une exception lors de la conversion 
            // on avise et valide reste faux.   
            } catch (Exception e) {
               System.out.println("\nLa valeur entrée doit être "
                          + "entre " + min + " et " + max + ".");
            }
         }
      }

      return valInt;
   }

   //-----------------------------
   // LIRE DOUBLE
   //-----------------------------

   /**
    * Affiche le message reçu et attend l'entrée d'un nombre réel entre les deux
    * bornes (min et max). Si l'utilisateur annule, la fonction retourne 0 et la
    * fonction utilisateurAnnule() retournera true.
    *
    * @param msg Le message de sollicitation
    * @param min limite inférieure acceptée
    * @param max limite supérieure acceptée
    * @return un réel entre min et max
    */
   public static double lireDouble(String msg, double min, double max) {

      // Sert à la saisir.
      String valeurLue = null;

      // Sera mis à true lorsque valide.
      boolean valide = false;

      // Sert à valider le nombre.
      double valDouble = 0;

      // Attribut gobal mis à faux.
      utilisateurAnnule = false;

      while (!valide && !utilisateurAnnule) {

         // Sollicitation de l'utilisateur pour la valeur.
         System.out.print(msg + " (<ENTRÉE> pour annuler) : ");

         // On lit toute la ligne.		        
         valeurLue = clavier.nextLine();

         // Si l'utilisateur annule, c'est valide.
         if (valeurLue.equals("")) {
            utilisateurAnnule = true;
            
         } else {  //S inon on tente de convertir en réel.
            try {
               // Si on réussit la conversion sans exception.
               valDouble = Double.parseDouble(valeurLue);

               // On évalue les bornes.
               if (valDouble < min || valDouble > max) {
                  System.out.println("\nLa valeur entrée doit être "
                          + "entre " + min + " et " + max + ".");
                  
               } else {  // Si on vient ici c'est que tout est beau.
                  valide = true;
               }
            // S'il y a une exception lors de la conversion 
            // on avise et valide reste faux.   
            } catch (Exception e) {
               System.out.println("\nLa valeur entrée doit être "
                          + "entre " + min + " et " + max + ".");
            }
         }
      }

      return valDouble;
   }

   //-----------------------------
   // LIRE STRING
   //-----------------------------
   
   /**
    * Affiche le message reçu et attend l'entrée d'une chaîne. L'utilisateur
    * annule en entrant une chaîne vide. Si l'utilisateur annule, la fonction
    * retourne null et la fonction utilisateurAnnule() retournera true.
    *
    * @param msg Le message de sollicitation.
    * @return la chaîne saisie.
    */
   public static String lireString(String msg) {

      // Sert à la saisir.
      String valeurLue = null;

      // Attribut gobal mis à faux.
      utilisateurAnnule = false;

      // Sollicitation de l'utilisateur pour la chaîne.
      System.out.print(msg + " (<ENTRÉE> pour annuler) : ");

      // On lit toute la ligne.		        
      valeurLue = clavier.nextLine();

		// Si l'utilisateur annule, c'est valide
      // et on retourne null.
      if (valeurLue.equals("")) {
         utilisateurAnnule = true;
         valeurLue = null;
      }

      return valeurLue;
   }

   //-----------------------------
   // UTILISATEUR ANNULE
   //-----------------------------
   
   /**
    * Retourne si l'utilisateur a annulé lors de la dernière lecture au clavier.
    * Cet attribut est remis à faux après consultation.
    *
    * @return Si l'utilisateur a annulé lors de sa dernière action.
    */
   public static boolean utilisateurAnnule() {
      return utilisateurAnnule;
   }

   /**
    * Réinitialise la dernière annulation de l'utilisateur. On ne considère plus
    * qu'il a annulé
    */
   public static void reinitialise() {
      utilisateurAnnule = false;
   }

   //-----------------------------
   // PAUSE
   //-----------------------------
   
   /**
    * Permet de demander a l'utilisateur d'appuyer sur une touche pour continuer
    * et d'attendre l'entrée de l'utilisateur.
    */
   public static void pause() {
      final int NB_CAR = 100;

      try {
         System.out.print("\nAppuyez sur <ENTRÉE> pour continuer... ");
         System.in.read();

         // Vide le tampon des caractères potentiellement entrés.
         System.in.skip(NB_CAR);
         
      } catch (Exception e) {
         //e.printStackTrace();
      }
   }

}
