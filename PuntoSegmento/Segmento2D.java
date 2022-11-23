import java.util.ArrayList;
import java.util.Scanner;

public class Segmento2D implements Segmento {
    //OVERVIEW: modella un segmento immutabile sul piano cartesiano costituito da due Punti2D
    final Punto2D a, b;

    //COSTRUTTORI:
    public Segmento2D (Punto2D a, Punto2D b) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this con a e b, se a e b sono null o sono uguali lancia IllegalArgumentException

        if (a==null) {
            throw new IllegalArgumentException("a non può essere null");
        }
        if (b==null) {
            throw new IllegalArgumentException("b non può essere null");
        }
        if (a.equals(b)) {
            throw new IllegalArgumentException("a e b non possono essere uguali");
        }
        this.a = a;
        this.b = b;
    }

    public Punto2D getA() {
        return this.a;
    }

    public Punto2D getB() {
        return this.b;
    }

    public double length() {
        //EFFECTS: restituisce la lunghezza del segmento
        double distanzaX = Math.abs(this.getA().getX() - this.getB().getX());
        double distanzaY = Math.abs(this.getA().getY() - this.getB().getY());
        return Math.sqrt(distanzaX*distanzaX + distanzaY*distanzaY);
    }

    @Override
    public String toString () {
        return "Segmento2D - a: " + this.a + ", b: " + this.b + "; lunghezza = " + this.length();
    }

    public static void main(String[] args) {
        double minlen = Double.parseDouble(args[0]);
        ArrayList<Segmento2D> l = new ArrayList<Segmento2D>();
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci i segmenti nel formato ax ay bx by (temina con CTRL+D)");

        while(s.hasNext()) {
            double ax = Double.parseDouble(s.next());
            double ay = Double.parseDouble(s.next());
            double bx = Double.parseDouble(s.next());
            double by = Double.parseDouble(s.next());

            Punto2D a = new Punto2D(ax, ay);
            Punto2D b = new Punto2D(bx, by);

            try {
                Segmento2D seg = new Segmento2D(a, b);
                l.add(seg);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
            System.out.println("Segmenti di lunghezza superiore a " + minlen);

            for (Segmento2D ts : l) {
                if (ts.length() > minlen)
                    System.out.println(ts);
            }
            
        s.close();
    }
}