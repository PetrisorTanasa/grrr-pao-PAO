package main.java.laborator3;
/*
﻿Exercitiul 1:
a.
Creati o clasa CandyBox, care va conține câmpurile private flavor (String) și origin (String). Clasa va avea, de asemenea:
- un constructor fără parametri;
- un constructor ce va inițializa toate campurile;
- o metoda de tip float getVolume(), care va intoarce valoarea 0.
Adaugati o metoda toString(), care va returna flavor-ul si regiunea de proveniență a cutiei de bomboane.


c.
Adăugați o metodă equals() în clasa CandyBox. Justificați criteriul de echivalentă ales.
Hint: Puteti genera automat metoda, cu ajutorul IDE. Selectați câmpurile considerate și analizați în ce fel va fi suprascrisă metoda equals().

d.
Creati o clasă CandyBag, care va conține un array cu mai multe cutii din fiecare tip. Pentru obiectele de tip Lindt testați egalitatea lor.

e.
Adaugati clasei Milka metoda printMilkaDim(), care va afișa dimensiunile razei și inaltimii. Procedati in mod analog cu celelalte tipuri de cutii, adaugand metodele
printHeidiDim() si printLindtDim(), în care să afișați dimensiunile fiecarei cutii.



Exercitiu bonus:
a. Implementaţi o clasă MyArrayList, care va reprezenta un vector de numere reale, cu posibilitatea redimensionării automate. Ea va fi definită în pachetul arrays.
Clasa va conţine următoarele metode:
- un constructor fără parametri, care creează intern un vector cu 10 elemente;
- un constructor cu un parametru de tipul întreg, care creează un vector de dimensiune egală cu parametrul primit;
- o metodă numită add(float value), care adaugă valoarea value la primul index disponibil al vectorului. Dacă se depăşeşte capacitatea vectorului, acesta se va redimensiona
 la o capacitate dublă;
Atenţie! Există o diferenţă între capacitatea vectorului (dimensiunea cu care a fost iniţializat) şi numărul de elemente memorate efectiv în el (care este cel mult capacitatea).
- o metodă numită contains(float value) care returnează true dacă value există în cadrul vectorului;
- o metodă numită remove(int index) care elimină valoarea aflată în vector la poziţia specificată de index (numerotarea incepând de la 0); se va da un mesaj dacă indexul
 este invalid;
- o metodă numită get(int index) care va returna elementul aflat în poziţia index;
- o metodă numită size() care returnează numarul de elemente memorate in vector;
- o metodă declarată public String toString() care va returna o reprezentare a tuturor valorilor vectorului ca un şir de caractere.

b. Scrieţi o clasă de test separată pentru clasa MyArrayList, populând lista cu 3 elemente şi verificând că valorile întoarse de metoda get corespund, într-adevăr,
poziţiilor aferente din vectorul intern clasei.

c. Scrieţi un scenariu de utilizare a clasei MyArrayList, astfel:
- iniţializând-o cu o capacitate de 5 de elemente iar apoi inserând 10 elemente aleatoare utilizând doar metoda add;
- cautând 5 valori aleatoare în vector;
- eliminând 5 valori aleatoare din vector.
 */
public class CandyBox {
    private String flavor;
    private String origin;
    public static void main(String[] args) {

    }
    public String getFlavor() {
        return flavor;
    }
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public CandyBox() {
        this.flavor = "";
        this.origin = "";
    }
    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }
    public float getVolume() {
        return 0;
    }
    @Override
    public String toString() {
        return "CandyBox{" +
                "flavor='" + flavor + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CandyBox candyBox = (CandyBox) obj;
        return flavor.equals(candyBox.flavor) &&
                origin.equals(candyBox.origin);
    }

}
