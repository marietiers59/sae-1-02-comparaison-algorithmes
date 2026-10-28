import java.util.Random;

/**
 * SAÉ 1.02, période 2 – FUS : tri fusion récursif avec l'API TAB (get / set).
 * La structure est découpée en deux moitiés, chacune triée récursivement,
 * puis les deux moitiés sont recopiées dans deux structures temporaires et fusionnées.
 * Groupe 20 : Benjamin BOUTOUT, Louis CARON, Marie TIERS.
 *
 * Compilation : javac -cp ../../lib/data.jar Fusion.java
 * Exécution   : java -cp .:../../lib/data.jar Fusion   (nécessite le fichier de clé ~/sae102.key)
 */
class Fusion extends Data {

    private final int nbElements;
    private final Random hasard = new Random();

    Fusion(int nbElements) {
        this.nbElements = nbElements;
    }

    /** Trie la portion [debut ; fin] de la structure. */
    void triFusion(int debut, int fin) {
        if (debut >= fin) {
            return;
        }
        int milieu = (debut + fin) / 2;
        triFusion(debut, milieu);
        triFusion(milieu + 1, fin);

        Fusion gauche = new Fusion(0);
        Fusion droite = new Fusion(0);
        for (int i = debut; i <= milieu; i++) {
            gauche.add(get(i));
        }
        for (int i = milieu + 1; i <= fin; i++) {
            droite.add(get(i));
        }
        fusionner(gauche, droite, debut);
    }

    /** Fusionne deux structures triées dans la structure principale, à partir de l'indice debut. */
    void fusionner(Fusion gauche, Fusion droite, int debut) {
        int i = 0;
        int j = 0;
        int k = debut;
        while (i < gauche.size() && j < droite.size()) {
            if (gauche.get(i) <= droite.get(j)) {
                set(k++, gauche.get(i++));
            } else {
                set(k++, droite.get(j++));
            }
        }
        while (i < gauche.size()) {
            set(k++, gauche.get(i++));
        }
        while (j < droite.size()) {
            set(k++, droite.get(j++));
        }
    }

    /** Ajoute n valeurs aléatoires comprises entre 0 et 99. */
    void ajouterValeursAleatoires(int n) {
        for (int i = 0; i < n; i++) {
            add(hasard.nextInt(100));
        }
    }

    void run() {
        ajouterValeursAleatoires(nbElements);
        triFusion(0, size() - 1);
        for (int i = 0; i < size(); i++) {
            System.out.println(get(i));
        }
    }

    public static void main(String[] args) {
        new Fusion(10).run();
    }
}
