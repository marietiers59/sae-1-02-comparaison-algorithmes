import java.util.Scanner;

/**
 * SAÉ 1.02, période 2 – ADDL : insérer un élément en fin de structure avec l'API ITER.
 * Démonstration sur une petite liste : affichage avant et après l'opération.
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar ADDL.java
 * Exécution   : java -cp .:../../lib/data.jar ADDL   (nécessite le fichier de clé ~/sae102.key)
 */
class ADDL extends Data {

    private final Scanner clavier = new Scanner(System.in);

    /** Ajoute un entier à la fin de la structure (API ITER) : on avance jusqu'au dernier élément. */
    void ajouterFin(int valeur) {
        rewind();
        while (hasNext()) {
            next();
        }
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
        System.out.print("Entier à ajouter en fin : ");
        ajouterFin(clavier.nextInt());
        afficher("Après :");
    }

    public static void main(String[] args) {
        new ADDL().run();
    }
}
