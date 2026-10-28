/**
 * SAÉ 1.02, période 2 – REMF : supprimer un élément en début de structure avec l'API ITER.
 * Démonstration sur une petite liste : affichage avant et après l'opération.
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar REMF.java
 * Exécution   : java -cp .:../../lib/data.jar REMF   (nécessite le fichier de clé ~/sae102.key)
 */
class REMF extends Data {

    /** Supprime le premier élément (API ITER) : un seul next(), puis removeIter(). */
    void supprimerPremier() {
        if (size() == 0) return;
        rewind();
        if (hasNext()) {
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
        supprimerPremier();
        afficher("Après :");
    }

    public static void main(String[] args) {
        new REMF().run();
    }
}
