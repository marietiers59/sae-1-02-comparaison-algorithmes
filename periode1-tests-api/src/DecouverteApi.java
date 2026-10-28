import java.util.Random;

/**
 * SAÉ 1.02, période 1 – Découverte de l'API de la structure de données cachée (classe Data).
 * Ajouts, parcours par itérateur, parcours imbriqués avec deux itérateurs numérotés, chronométrage.
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar DecouverteApi.java
 * Exécution   : java -cp .:../../lib/data.jar DecouverteApi
 */
class DecouverteApi extends Data {

    private final Random hasard = new Random();

    void run() {
        int aleatoire = hasard.nextInt(100); // entier dans [0 ; 100[
        System.out.println("Tirage aléatoire : " + aleatoire);

        long debut = System.currentTimeMillis();
        add(5);
        add(6);
        add(7);
        long fin = System.currentTimeMillis();
        System.out.println("Temps de 3 ajouts : " + (fin - debut) + " ms");

        // Toutes les paires d'éléments, avec deux itérateurs indépendants (0 et 1)
        rewind(0);
        while (hasNext(0)) {
            int n = next(0);
            rewind(1);
            while (hasNext(1)) {
                System.out.println(n + " " + next(1));
            }
        }

        // Parcours simple avec l'itérateur par défaut
        rewind();
        while (hasNext()) {
            System.out.println(next());
        }
    }

    public static void main(String[] args) {
        new DecouverteApi().run();
    }
}
