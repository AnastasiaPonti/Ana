import java.util.Objects;

// Questa classe astratta rappresenta un corpo celeste, ovvero un oggetto che può
// essere mutabile (pianeta) o immutabile (stella fissa) in base all'implementazione.
// È caratterizzato da un nome (pubblico e immutabile) che non può essere null e da una
// posizione e velocità dipendenti dall'implementazione (gli unici metodi mutazionali
// sono aggiornaPosizione e aggiornaVelocità), l'energia è calcolata come da definizione.


public abstract class CorpoCeleste {
  
  public final String nome;
  
  //COSTRUTTORI:
  public CorpoCeleste(final String nome) {
    this.nome = Objects.requireNonNull(nome, "Il nome non può essere null");
  }

  // METODI:

  // EFFECTS: Le implementazioni restituiscono la posizione (non null)
  public abstract Punto velocità();

  // EFFECTS: Le implementazioni restituiscono la velocità (non null)
  public abstract Punto posizione();

  // EFFECTS: Le implementazioni devono garantire che questo metodo
  // modifichi esclusivamente la posizione di questo corpo celeste
  public abstract void aggiornaPosizione();
  
  // EFFECTS: Le implementazioni devono garantire che questo metodo modifichi
  // esclusivamente la velocità di questo corpo celeste a partire dalle
  // informazioni riguardo al corpo celeste dato come argomento; si assume
  // che c non sia null, altrimenti sarà sollevata opportuna eccezione e
  // che questo metodo non invochi alcun metodo mutazionale su c
  public abstract void aggiornaVelocità(final CorpoCeleste c);

  // EFFECTS: restituisce l'energia data dal prodotto dell'energia
  // potenziale, corrispondente alla norma della sua posizione, per
  // l'energia cinetica, corrispondente dalla norma della sua velocità
  public long energia() {
    return posizione().norma() * velocità().norma();
  }

}