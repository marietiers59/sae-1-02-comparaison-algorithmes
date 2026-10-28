import java.util.Scanner;

/**
 * SAÉ 1.02, période 2 – ADDF : insérer un élément en début de structure avec l'API ITER.
 * Démonstration sur une petite liste : affichage avant et après l'opération.
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar ADDF.java
 * Exécution   : java -cp .:../../lib/data.jar ADDF   (nécessite le fichier de clé ~/sae102.key)
 */
class ADDF extends Data {

    private final Scanner clavier = new Scanner(System.in);

    /** Ajoute un entier au début de la structure (API ITER). */
    void ajouterDebut(int valeur) {
        rewind();
        addIter(valeur);
    }

    private void afficher(String titre) {
        System.out.println(titre);
        rewind();
        while (hasNext()) {
            System.out.println(next());
        }
    }

    void run() {
        add(5);
        add(6);
        add(7);
        afficher("Avant :");
        System.out.print("Entier à ajouter en début : ");
        ajouterDebut(clavier.nextInt());
        afficher("Après :");
    }

    public static void main(String[] args) {
        new ADDF().run();
    }
}
