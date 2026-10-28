/**
 * SAÉ 1.02, période 2 – REML : supprimer un élément en fin de structure avec l'API ITER.
 * Démonstration sur une petite liste : affichage avant et après l'opération.
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar REML.java
 * Exécution   : java -cp .:../../lib/data.jar REML   (nécessite le fichier de clé ~/sae102.key)
 */
class REML extends Data {

    /** Supprime le dernier élément (API ITER) : on avance jusqu'au bout, puis removeIter(). */
    void supprimerDernier() {
        if (size() == 0) return;
        rewind();
        while (hasNext()) {
            next();
        }
        removeIter();
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
        supprimerDernier();
        afficher("Après :");
    }

    public static void main(String[] args) {
        new REML().run();
    }
}
