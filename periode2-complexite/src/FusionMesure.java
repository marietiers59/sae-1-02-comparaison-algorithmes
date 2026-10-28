import java.io.IOException;
import java.io.PrintWriter;

/**
 * SAÉ 1.02, période 2 – Mesure du temps du tri fusion (API TAB) pour différentes tailles.
 * Résultats dans gp20-Fusion-TAB.csv, colonne TEMPS en NANOSECONDES (System.nanoTime()).
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar Fusion.java FusionMesure.java
 * Exécution   : java -cp .:../../lib/data.jar FusionMesure   (nécessite le fichier de clé ~/sae102.key)
 */
class FusionMesure {

    private static final int[] TAILLES = {1024, 8192, 65536, 524288}; // 2^10, 2^13, 2^16, 2^19

    void run() {
        try (PrintWriter csv = new PrintWriter("gp20-Fusion-TAB.csv")) {
            csv.println("NBELEM;TEMPS");
            for (int taille : TAILLES) {
                Fusion structure = new Fusion(taille);
                structure.ajouterValeursAleatoires(taille);
                long debut = System.nanoTime();
                structure.triFusion(0, taille - 1);
                long duree = System.nanoTime() - debut;
                csv.println(taille + ";" + duree);
                System.out.println("NBELEM=" + taille + ", TEMPS=" + duree + " ns");
            }
        } catch (IOException e) {
            System.err.println("Écriture du fichier impossible : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new FusionMesure().run();
    }
}
