import java.util.Objects;

// Funzione d'astrazione (AF): Un Punto è un oggetto immutabile a tre
// coordinate intere, esse sono private ed immutabili; questo è vero
// in costruzione e resta tale per assenza di metodi mutazionali.

// Invariante di rappresentazione (RI): l'oggetto Punto non può essere null

public class Punto {

    private final int x, y, z;

    //COSTRUTTORI:

    public Punto (int x, int y, int z) {
        //MODIFIES: this
        //EFFECTS: inizializza this con ordinate x e y
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Punto () {
        //MODIFIES: this
        //EFFECTS: inizializza this con coordinate 0 e 0
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    //METODI osservazionali:

    // EFFECTS: restituisce la prima coordinata x del punto
    public int getX() {
        return this.x;
    }

    // EFFECTS: restituisce la seconda coordinata y del punto
    public int getY() {
        return this.y;
    }

    // EFFECTS: restituisce la terza coordinata z del punto
    public int getZ() {
        return this.z;
    }

    //METODI di produzione:

    // EFFECTS: restituisce un nuovo punto ottenuto sommando questo e il punto
    // dato come argomento, sollevando un'eccezione qualora quest'ultimo sia null
    public Punto somma(Punto q) {
        if (q == null) throw new NullPointerException("Il punto q non può essere null");
        return new Punto(this.x+q.x, this.y+q.y, this.z+q.z);
    }

    // EFFECTS: restituisce un nuovo punto ottenuto sottraendo il punto dato come
    // argomento a quello corrente, sollevando un'eccezione qualora quest'ultimo sia null
    public Punto sottrai(Punto q) {
        if (q == null) throw new NullPointerException("Il punto q non può essere null");
        return new Punto(this.x-q.x, this.y-q.y, this.z-q.z);
    }

    // EFFECTS: restituisce la somma dei valori assoluti delle coordinate
    public int norma() {
        return Math.abs(this.x) + Math.abs(this.y) + Math.abs(this.z);
        // return (x > 0 ? x : -x) + (y > 0 ? y : -y) + (z > 0 ? z : -z);
    }

    @Override
    public boolean equals(Object q) {
        if (q instanceof Punto) {
            final Punto p = (Punto)q;
            return x==p.x && y==p.y && z==p.z;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", x, y, z);
    }
    
}