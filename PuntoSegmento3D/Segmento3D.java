import java.util.ArrayList;
import java.util.Scanner;

public class Segmento3D implements Segmento {
    //OVERVIEW: modella un segmento immutabile sul piano cartesiano costituito da due Punti2D
    Punto3D a, b;

    //COSTRUTTORI:
    public Segmento3D (Punto3D a, Punto3D b) throws IllegalArgumentException {
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
    public Punto3D getA() {
        return this.a;
    }

    public Punto3D getB() {
        return this.b;
    }

    public double length() {
        //EFFECTS: restituisce la lunghezza del segmento
        double distanzaX = this.getA().getX() - this.getB().getX();
        double distanzaY = this.getA().getY() - this.getB().getY();
        double distanzaZ = this.getA().getZ() - this.getB().getZ();
        return Math.sqrt(distanzaX*distanzaX + distanzaY*distanzaY + distanzaZ*distanzaZ);
    }

    @Override
    public String toString () {
        return "Segmento3D - a: " + this.a + ", b: " + this.b + "; lunghezza = " + this.length();
    }

    public static void main(String[] args) {
        double minlen = Double.parseDouble(args[0]);
        ArrayList<Segmento3D> l = new ArrayList<Segmento3D>();
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci i segmenti nel formato ax ay bx by (temina con CTRL+D)");
        
        while(s.hasNext()) {
            double ax = Double.parseDouble(s.next());
            double ay = Double.parseDouble(s.next());
            double az = Double.parseDouble(s.next());
            double bx = Double.parseDouble(s.next());
            double by = Double.parseDouble(s.next());
            double bz = Double.parseDouble(s.next());

            Punto3D a = new Punto3D(ax, ay, az);
            Punto3D b = new Punto3D(bx, by, bz);

            try {
                Segmento3D seg = new Segmento3D(a, b);
                l.add(seg);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
            System.out.println("Segmenti di lunghezza superiore a " + minlen);

            for (Segmento3D ts : l) {
                if (ts.length() > minlen) System.out.println(ts);
            }
        s.close();
    }
}
