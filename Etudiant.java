public class Etudiant{
    String matricule;
    String nom;
    String genre;
    int date_naissance;
    float moyenne;

    public Etudiant(String matricule,String nom, String genre, int date, float moy)
    {
        this.matricule = matricule;
        this.nom = nom;
        this.genre = genre;
        this.date_naissance = date;
        this.moyenne = moy;
        System.out.println("Etudiant cree avec succes");
    }

    public void Affiche(){
        System.out.println("=========================================================");
        System.out.println("Matricule: "+this.matricule);
        System.out.println("Nom: "+this.nom);
        System.out.println("Genre: "+this.genre);
        System.out.println("Date de naissance: "+this.date_naissance);
        calculeAge();
        System.out.println("Moyenne: "+this.moyenne);
    }

    public void calculeAge(){
        int age;

        if(date_naissance<=21){
            age = 2021 -(2000+date_naissance);
        }
        else if(date_naissance<100){
            age = 2021 - (1900+date_naissance);
        }
        else {
            age = 2021 - date_naissance;
        }
        System.out.println("Age: "+age);

    }

    public void Bonifier(float bonus){
        this.moyenne += bonus;
        System.out.println("Vous avez donner un bonus de: "+bonus+" a l'etudiant nomme "+this.nom);
    }
}
