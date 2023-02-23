package Lychrel;

import java.util.Scanner;

public class Lychrel {
    Scanner N = new Scanner(System.in);
    System.out.println("Inserisci il numero: ");
    int number = N.nextInt();
    N.close();
    System.out.println("");

    public static int Trasforma(String numero) {
        int somma = 0;
        for (int i=0; i<numero.length(); i++) {
          somma += Integer.parseInt(String.valueOf(numero.charAt(i)));
        }
        for (int i=numero.length()-1; i>=0; i--) {
            somma += Integer.parseInt(String.valueOf(numero.charAt(i)));
          }
        return somma;
      }
}