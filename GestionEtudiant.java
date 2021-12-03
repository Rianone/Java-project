import javax.swing.*;
import java.util.Scanner;

public class GestionEtudiant {

    static void ordreMerite(Etudiant Tab[],int taille){
        if(Tab != null) {
            Etudiant tmp;
            for (int i = 0; i < taille - 1; i++) {
                for (int j = 1; j < taille; j++) {
                    if (Tab[i].moyenne < Tab[j].moyenne) {
                        tmp = Tab[i];
                        Tab[i] = Tab[j];
                        Tab[j] = tmp;
                    }
                }
            }

            for (int k = 0; k < taille; k++) {
                Tab[k].Affiche();
            }
        }
        else
        {
            System.out.println("Le tableau est vide!!!!!!");
        }
    }

    static void affichePremierEtDernier(Etudiant Tab[], float moy, int taille){
        if(Tab != null) {
            for (int i = 0; i < taille; i++) {
                if (Tab[i].moyenne == moy) {
                    Tab[i].Affiche();
                }
            }
        }
        else
        {
            System.out.println("Le tableau est vide!!!!!");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numEtu,date,choix=0;
        String nom,mat;
        float som=0,moy=0,der=0,prem=0,moyenneGenerale=0;
        String genre;

        System.out.println("Combien d'etudiants voulez vous?");
        numEtu= sc.nextInt();

        Etudiant [] Tab = new Etudiant[numEtu];

        System.out.println("Remplissez les informations des etudiants: ");

        for (int i=0; i<numEtu; i++){

                System.out.println("Entrer le matricule de l'etudiant Numero " + (i + 1));
                mat = sc.next();
                sc.reset();
                System.out.println("Entrer son nom");
                nom = sc.next();
                sc.reset();
                System.out.println("Entrer son genre");
                genre = sc.next();
                System.out.println("Entrer sa date de naissance");
                date = sc.nextInt();
                System.out.println("Entrer sa moyenne");
                moy = sc.nextFloat();
                Tab[i] = new Etudiant(mat, nom, genre, date, moy);
                som = som + moy;

                if (i == 0) {
                    der = moy;
                    prem = moy;
                }
                if (moy < der) {
                    der = moy;
                }
                if (moy > prem) {
                    prem = moy;
                }


        }
 for(;;) {
     do {
         System.out.println("\t==================--___ MENU ___-- ========================\t");
         System.out.println("[1]-Affiche Etudiants par ordre de merite \t [2]-Affiche info sur le premier");
         System.out.println("[3]-Affiche info sur le dernier           \t [4]-Reinitiliser la liste");
         System.out.println("[5]-Quitter le programme");
         choix = sc.nextInt();
     } while (choix < 1 && choix > 6);

     switch (choix) {
         case 1:
             System.out.println("Liste des etudiants par ordre de merite");
             ordreMerite(Tab, numEtu);
             break;
         case 2:
             System.out.println("Le premier etudiant est: ");
             affichePremierEtDernier(Tab, prem, numEtu);
             break;
         case 3:
             System.out.println("Le dernier etudiant est: ");
             affichePremierEtDernier(Tab, der, numEtu);
             break;
         case 4:
             Tab = null;
             System.out.println("Tableau reinitialiser avec success");
             break;
         case 5:
             System.out.println("Vous avez quitter le programme");
             System.exit(0);
             break;
     }
 }
    }
}

