# ADT – Abstrakte Datentypen

Implementierung grundlegender Datenstrukturen und Sortieralgorithmen in Java.

> **Hinweis:** Der Inhalt des Repos `Listen` (einfachere Basisversion) ist in diesem Repo aufgegangen – `ADT` enthält die vollständigere Variante.

## Projektstruktur

```
ADT/
├── Listen/src/
│   ├── Liste.java          ← Verkettete Liste (add, remove, find, firstLast)
│   ├── ListenElement.java  ← Einzelnes Knoten-Objekt
│   ├── MergeSort.java      ← MergeSort auf int-Arrays
│   ├── QuickSort.java      ← QuickSort mit Lomuto-Partitionierung
│   ├── SortAlgorithms.java ← BubbleSort + SelectionSort
│   └── Test.java           ← Laufzeitvergleich aller Sortierer
└── calculus/src/calculus/
    └── calc.java           ← Kleines Gleitkomma-Rechenbeispiel
```

## Enthaltene Algorithmen

### Verkettete Liste (`Liste` + `ListenElement`)

Eine **verkettete Liste** ist eine dynamische Datenstruktur, bei der jedes Element
einen Zeiger auf das nächste hält. Im Gegensatz zu Arrays kann sie beliebig wachsen
und schrumpfen – aber der wahlfreie Zugriff (Index) ist langsamer.

```
kopf → [3] → [5] → [43] → [9] → null
```

### Sortieralgorithmen

| Algorithmus | Klasse | Zeitkomplexität |
|-------------|--------|-----------------|
| MergeSort | `MergeSort` | O(n log n) |
| QuickSort | `QuickSort` | O(n log n) avg, O(n²) worst |
| BubbleSort | `SortAlgorithms` | O(n²) |
| SelectionSort | `SortAlgorithms` | O(n²) |

## Lernziele

- Verkettete Liste als Datenstruktur (vs. Array)
- Rekursive Sortieralgorithmen (Merge/Quick) vs. naive Varianten (Bubble/Selection)
- Laufzeitmessung und Vergleich
