package laprovadelnove;

import java.util.ArrayList;
import java.util.Scanner;

//Scrivete un programma che, dato un numero naturale N nel flusso di ingresso, emetta tutte e sole le possibili terne
//di interi positivi A, B e C ciascuno minore di N per cui A x B è diverso da C, ma la prova del nove funziona.

public class Laprovadelnove {
  public static void main() {
    Scanner N = new Scanner(System.in);
    System.out.println("Inserisci il numero: ");
    int number = N.nextInt();
    N.close();
    System.out.println("");
    ProvaNove(Integer.toString(number));
  }
    public static String ProvaNove(String n) {
      int somma = 0;
      for (int i=0; i<n.length(); i++) {
        somma += Integer.parseInt(String.valueOf(n.charAt(i)));
      }
      if (somma > 9) {
        return ProvaNove(Integer.toString(somma));
      }
      return Integer.toString(somma);
    }
  }
