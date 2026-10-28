/**
 * SAÉ 1.02, période 1 – Test de hasNext() et next() : parcours imbriqués avec deux itérateurs,
 * qui affichent toutes les paires d'éléments d'une liste de cinq valeurs.
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar TestHasNext.java
 * Exécution   : java -cp .:../../lib/data.jar TestHasNext
 */
class TestHasNext extends Data {

    void run() {
        add(5);
        add(12);
        add(6);
        add(14);
        add(7);

        long debut = System.currentTimeMillis();
        rewind(0);
        while (hasNext(0)) {
            int n = next(0);
            rewind(1);
            while (hasNext(1)) {
                System.out.println(n + " " + next(1));
            }
        }
        long fin = System.currentTimeMillis();
        System.out.println("Temps passé : " + (fin - debut) + " ms");
    }

    public static void main(String[] args) {
        new TestHasNext().run();
    }
}
