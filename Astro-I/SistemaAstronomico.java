// OVERVIEW: Un sistema astronomico è una collezione di pianeti e stelle fisse.
// Esso è caratterizzato da uno stato che evolve a tempo discreto: al tempo 0 lo
// stato è dato dall'elenco di tutti i corpi celesti che lo compongono, con la
// posizione assegnata e la velocità nulla, quindi per ogni istante di tempo
// avvengono i due aggiornamenti descritti prima:
// ciascun pianeta (interagendo con tutti i corpi celesti del sistema) aggiorna la
// sua velocità, dopo che le nuove velocità sono state calcolate per tutti i pianeti,
// ciascun pianeta procede con l'aggiornare la sua posizione. Questo determina il nuovo
// stato, costituito dall'elenco di tutti i corpi celesti con le posizioni e velocità
// opportunamente aggiornate. L'energia totale di un sistema astronomico in un certo
// stato è data dalla somma dell'energia di tutti i corpi celesti di cui è costituito.

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class SistemaAstronomico {
  // AF: Un sistema astronomico è una insieme ordinato di corpi celesti;
  // questo è vero in costruzione e mai invalidato da alcun metodo.

  // RI: L'insieme non è mai null e l'ordine è dato dall'ordine naturale
  // nome del corpo celeste. Ciascun corpo celeste non è mai null.

  private final SortedSet<CorpoCeleste> corpiCelesti = new TreeSet<>(
    new Comparator<>() {
      @Override
      public int compare(CorpoCeleste o1, CorpoCeleste o2) {
        return o1.nome.compareTo(o2.nome);
      }
    }
  );

  // EFFECTS: proteggere per copia
  public void aggiungi(final CorpoCeleste c) {
    corpiCelesti.add(Objects.requireNonNull(c, "Il corpo celeste c non può essere null"));
  }

  // EFFECTS: esegue il dato numero di passi di evoluzione (se il numero di passi
  // è negativo solleva opportuna eccezione); la dinamica segue le specifiche, i
  // cicli che aggiornano velocità e posizione possono essere eseguiti in ordine
  // arbitrario date le garanzie sui metodi aggiornaVelocità e aggiornaPosizione
  public void simula(final int passi) {
    if (passi < 0) throw new IllegalArgumentException("Il numero di passi non può essere negativo");
    for (int i=0; i<passi; i++) {
      for (final CorpoCeleste p : corpiCelesti)
        for (final CorpoCeleste c : corpiCelesti) {
          if (p == c)
            continue;
          p.aggiornaVelocità(c);
        }
      for (final CorpoCeleste c : corpiCelesti)
        c.aggiornaPosizione();
    }
  }

  public long energia() {
    for (final CorpoCeleste c : corpiCelesti) {
      res += c.energia();
    }
    return res;
  }

  @Override
  public String toString() {
      Stringbuffer sb = new Stringbuffer();
      final Iterator<CorpoCeleste> it = corpiCelesti.iterator();
      while (it.hasNext()) {
        sb.append(it.next());
        if (it.hasNext()) sb.append('\n');
      }
      return sb.toString();
    }

}