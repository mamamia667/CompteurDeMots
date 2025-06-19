import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in); // Scanner pour lire l'entrée utilisateur

        System.out.print("Entrez le nom du fichier à analyser (avec l'extension) : ");
        String nomFichier = inputScanner.nextLine();

        int totalMots = compterMots(nomFichier);

        if (totalMots >= 0) {
            System.out.println("Nombre total de mots dans le fichier : " + totalMots);
        }

        inputScanner.close();
    }

    public static int compterMots(String nomFichier) {
        int totalMots = 0;
        Scanner scanner = null;

        try {
            File fichier = new File(nomFichier);
            scanner = new Scanner(fichier);
            System.out.println("Lecture du fichier : " + nomFichier);
            System.out.println("----------------------------------------");

            int numeroLigne = 1;

            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                String[] mots = ligne.split(" ");
                int motsLigne = 0;

                for (String mot : mots) {
                    if (!mot.trim().isEmpty()) {
                        motsLigne++;
                    }
                }

                System.out.println("Ligne " + numeroLigne + " : " + motsLigne + " mots");
                totalMots += motsLigne;
                numeroLigne++;
            }

            System.out.println("----------------------------------------");

        } catch (FileNotFoundException e) {
            System.err.println("Erreur : Le fichier '" + nomFichier + "' n'a pas été trouvé.");
            System.err.println("Assurez-vous que le fichier existe dans le répertoire du projet.");
            return -1;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return totalMots;
    }
}
