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
    int a, b, c, ris;
    for (int i=1; i<number; i++) {
      for (int j=1; j<number; j++) {
        for (int k=1; k<number; k++) {
          a = Integer.parseInt(SommaCifre(Integer.parseInt(i)));
          b = Integer.parseInt(SommaCifre(Integer.parseInt(j)));
          c = Integer.parseInt(SommaCifre(Integer.parseInt(k)));
          ris = a*b;
          ris = Integer.parseInt(SommaCifre(Integer.parseInt(ris)));
          if (ris == c) {
            if (i*j != k) {
              System.out.println(i, j, k + "\n");
            }
          }
        }
      }
    }
  }
    public static String SommaCifre(String n) {
      int somma = 0;
      for (int i=0; i<n.length(); i++) {
        somma += Integer.parseInt(String.valueOf(n.charAt(i)));
      }
      if (somma > 9) {
        return SommaCifre(Integer.toString(somma));
      }
      return Integer.toString(somma);
    }
  }
