import java.util.Scanner;

//Scrivete un programma che, dato un numero positivo N nel flusso di ingresso,
//emetta nel flusso di uscita un rombo di asterischi di diagonale 2N+1.

public class Rombo {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int N = s.nextInt();
    s.close();
    StampaRombo(N);
  }

  public static void StampaRombo(int N) {
    int i;
    for (i=0; i<N+1; i++) {
      StampaAsterischi(i, N);
    }
    for (i=N-1; i>=0; i--) {
      StampaAsterischi(i, N);
    }
  }

  public static void StampaAsterischi(int i, int N) {
    int count = 0;
        do  {
            System.out.print(" ");
            count++;
        } while (count <= N-i);
        count = 0;
        do  {
            System.out.print("*");
            count++;
        } while (count < i*2+1);
        System.out.println();
  }

}
