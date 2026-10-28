# SAÉ 1.02 — comparaison d'approches algorithmiques

BUT informatique S1 · deux périodes (fin 2025, puis janvier 2026)
Équipe : Benjamin BOUTOUT, Louis CARON, Marie TIERS (groupe 20).

## le principe

L'IUT fournit une **structure de données cachée** (`lib/data.jar`, classe `Data`) dont on ne connaît que l'API :
accès par indice (`get`, `set`, `size`, `add`, `remove`) et accès par **itérateurs** (`rewind`, `hasNext`, `next`,
`previous`, `addIter`, `removeIter`…). Il faut en découvrir le fonctionnement et les performances par l'expérience.

## période 1 — tests unitaires de l'API

Chaque fonction ou procédure a été testée puis chronométrée : `rewind`, `add`, `remove`, `hasNext` / `next`,
`size`, `get`, `set`, `hasPrevious` / `previous`, `addIter` (11 sur 13).
Deux membres testaient, le troisième rédigeait le compte rendu sous leur supervision.

- `periode1-tests-api/src/` : `DecouverteApi.java`, `TestRewind.java`, `TestHasNext.java`
- `periode1-tests-api/docs/compte-rendu-tests-api.pdf` : compte rendu complet (avec captures du code des autres tests)

## période 2 — algorithmes, mesures et complexité

| algorithme | rôle | API |
| --- | --- | --- |
| ADDF / ADDL | ajout au **début** / à la **fin** | ITER |
| REMF / REML | suppression du **premier** / du **dernier** | ITER |
| FUS | **tri fusion** récursif | TAB (`get` / `set`) |

Combinés deux à deux, ces ajouts et suppressions donnent des **piles** (LIFO) et des **files** (FIFO).
Les classes `*_mesure` et `FusionMesure` chronomètrent chaque algorithme pour des structures de 2^10 à 2^19 éléments
et 2, 8 ou 64 opérations, puis écrivent les résultats dans `mesures/*.csv`.
Le *notebook* `mesures/analyse-complexite.ipynb` (partie mathématique) trace les courbes avec matplotlib
et les compare aux classes de complexité de référence.

**Constat principal** : opérer en début de structure est bien plus rapide qu'en fin
(524 288 éléments, 64 opérations : ADDF 40 ms contre ADDL 153 ms ; REMF 36 ms contre REML 157 ms),
car atteindre la fin impose un parcours complet par l'itérateur.

```
periode2-complexite/src/      ADDF, ADDL, REMF, REML (démonstrations) et leurs classes *_mesure, Fusion, FusionMesure
periode2-complexite/mesures/  fichiers CSV produits + notebook d'analyse
periode2-complexite/docs/     rapport rendu (PDF)
```

## lancer les programmes

```bash
cd periode2-complexite/src
javac -cp ../../lib/data.jar *.java
java -cp .:../../lib/data.jar ADDL_mesure
```

La bibliothèque vérifie la présence d'un fichier de clé personnel (`~/sae102.key`) remis par l'IUT à chaque groupe :
sans lui, le code se compile mais ne s'exécute pas. Les CSV fournis sont ceux produits pendant la SAÉ.

## retouches d'octobre 2026 (nettoyage pour le portfolio)

- code reformaté, commentaires de travail retirés, imports inutiles supprimés, noms harmonisés (`TestHasNext`, `ajouterFin`…) ;
- démonstrations ADDF et ADDL corrigées : l'ajout se faisait au mauvais endroit (itérateur mal positionné). Les classes de mesure, elles, étaient justes et n'ont pas changé de logique ;
- limite connue laissée telle quelle et signalée en commentaire : les programmes de mesure ne vident pas la structure entre deux séries ;
- le tri fusion mesure en **nanosecondes** (`System.nanoTime()`) : le rapport indique « ms » par erreur pour ces deux valeurs ;
- *notebook* : la sortie d'erreur de la cellule « squelette » de l'énoncé a été retirée.

Fichiers non repris : les `.class`, une seconde implémentation du tri fusion non rendue (`FUS.java`, `FUS_mesure.java`),
les brouillons Word du rapport, le squelette `test.txt` de l'énoncé, les captures d'écran (déjà présentes dans le compte rendu)
et l'archive `.zip` de rendu (son contenu est ce dossier).
