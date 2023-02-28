import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        Punto p = new Punto(0, 0, 0);
        boolean dispari = true;
        while (s.hasNextInt()) {
            final Punto q = new Punto(s.nextInt(), s.nextInt(), s.nextInt());
            p = dispari ? p.somma(q) : p.sottrai(q);
            dispari = !dispari;
        }
        s.close();
        System.out.printf("|%s| = %d\n", p, p.norma());
    }
}