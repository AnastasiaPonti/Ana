import java.util.Objects;

public class StellaFissa extends CorpoCeleste {

    // AF: Una stella fissa è un corpo celeste con posizione e velocità
    // immutabili; questo fatto è vero in costruzione e mai modificato
    // da alcun metodo; inoltre posizione e velocità possono essere
    // esposti senza rischio in quanto immutabili

    // RI: Il parametro posizione non è mai null, mentre il parametro
    // velocità pure non può mai essere null e deve essere pari a zero 

    public final Punto posizione, velocità;

    // COSTRUTTORI:
    public StellaFissa(final String nome, final int x, final int y, final int z) {
        super(nome);
        posizione = new Punto(x, y, z);
        velocità = new Punto(0, 0, 0);
    }

    // METODI:

    @Override
    public Punto velocità() {
        return velocità;
    }

    @Override
    public Punto posizione() {
        return posizione;
    }

    @Override
    public void aggiornaVelocità(CorpoCeleste c) {
    }

    @Override
    public void aggiornaPosizione() {
    }

    @Override
    public String toString() {
        return "Stella fissa, nome: " + nome + ", pos: " + posizione;
        //return String.format("Stella fissa, nome: %s, pos: %s", nome, posizione);
    }

}