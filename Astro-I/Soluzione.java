import java.util.Scanner;

public class Soluzione {
  public static void main(String[] args) throws Exception {
    final SistemaAstronomico sa = new SistemaAstronomico();

    try (final Scanner s = new Scanner(System.in)) {
      while (s.hasNextLine()) {
        if (s.next().charAt(0) == 'P')
          sa.aggiungi(new Pianeta(s.next(), s.nextInt(), s.nextInt(), s.nextInt()));
        else
          sa.aggiungi(new StellaFissa(s.next(), s.nextInt(), s.nextInt(), s.nextInt()));
      }
    }

    sa.simula(Integer.parseInt(args[0]));
    System.out.println(sa);
    System.out.println("Energia totale: " + sa.energia());

  }
}
