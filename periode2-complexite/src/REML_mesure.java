import java.io.IOException;
import java.io.PrintWriter;

/**
 * SAÉ 1.02, période 2 – REML : supprimer un élément en fin de structure avec l'API ITER.
 * Mesure du temps de NBINS opérations pour des structures de NBELEM éléments ; résultats dans gp20-REML-ITER.csv.
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar REML_mesure.java
 * Exécution   : java -cp .:../../lib/data.jar REML_mesure   (nécessite le fichier de clé ~/sae102.key)
 */
class REML_mesure extends Data {

    private static final int[] TAILLES = {1024, 8192, 65536, 524288}; // 2^10, 2^13, 2^16, 2^19
    private static final int[] NB_OPERATIONS = {2, 8, 64};            // 2^1, 2^3, 2^6

    /** Supprime le dernier élément (API ITER) : on avance jusqu'au bout, puis removeIter(). */
    void supprimerDernier() {
        if (size() == 0) return;
        rewind();
        while (hasNext()) {
            next();
        }
        removeIter();
    }

    void run() {
        try (PrintWriter csv = new PrintWriter("gp20-REML-ITER.csv")) {
            csv.println("NBELEM;NBINS;TEMPS");
            for (int nbElem : TAILLES) {
                for (int nbOperations : NB_OPERATIONS) {
                    // Remplissage avec nbElem éléments.
                    // Limite connue : la structure n'est pas vidée entre deux mesures,
                    // elle grossit donc d'une mesure à l'autre (logique conservée telle que rendue).
                    for (int i = 0; i < nbElem; i++) {
                        add(i);
                    }
                    long debut = System.currentTimeMillis();
                    for (int i = 0; i < nbOperations; i++) {
                        supprimerDernier();
                    }
                    long temps = System.currentTimeMillis() - debut;
                    csv.println(nbElem + ";" + nbOperations + ";" + temps);
                    System.out.println("NBELEM=" + nbElem + ", NBINS=" + nbOperations + ", TEMPS=" + temps + " ms");
                }
            }
            System.out.println("Fichier gp20-REML-ITER.csv généré.");
        } catch (IOException e) {
            System.err.println("Écriture du fichier impossible : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new REML_mesure().run();
    }
}
