/**
 * SAÉ 1.02, période 1 – Test de rewind() : replacer l'itérateur au début de la structure,
 * après une lecture au début, au milieu et à la fin d'une liste de cinq éléments.
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar TestRewind.java
 * Exécution   : java -cp .:../../lib/data.jar TestRewind
 */
class TestRewind extends Data {

    /** Lit trois fois l'élément à la position donnée, en appelant rewind() après chaque lecture. */
    private void mesurer(String libelle, int position) {
        long debut = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            System.out.println(get(position));
            rewind();
        }
        long fin = System.currentTimeMillis();
        System.out.println(libelle + " : " + (fin - debut) + " ms");
    }

    void run() {
        add(5);
        add(12);
        add(6);
        add(14);
        add(7);
        rewind();
        mesurer("Début de liste", 0);
        mesurer("Milieu de liste", 2);
        mesurer("Fin de liste", 4);
    }

    public static void main(String[] args) {
        new TestRewind().run();
    }
}
