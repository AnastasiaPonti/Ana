import static java.lang.Math.signum;

import java.util.Objects;

public class Pianeta extends CorpoCeleste {

    // AF: Un pianeta è un corpo celeste con parametri posizione e
    // velocità (e nome ereditato dalla superclasse CorpoCeleste)

    // RI: I parametri posizione e velocità dell'oggetto Pianeta non sono mai null,
    // questo fatto è vero in costruzione e mai modificato da alcun metodo; sebbene
    // velocità e posizione siano sostituite dai metodi mutazionali, i campi possono
    // essere esposti senza rischio in quanto immutabili

    private Punto posizione, velocità;

    // COSTRUTTORI:
    public Pianeta(final String nome, int x, int y, int z) {
        super(nome);
        posizione = new Punto(x, y, z);
        velocità = new Punto(0, 0, 0);
    }
    @Override
    public Punto posizione() {
        return posizione;
    }

    @Override
    public Punto velocità() {
        return velocità;
    }

    @Override
    public void aggiornaPosizione() {
        posizione = posizione.somma(velocità);
    }

    @Override
    public void aggiornaVelocità(CorpoCeleste c) {
        // Marte cambierebbe di +1 (perché 3 marte < 5 giove)
        Objects.requireNonNull(c, "Il corpo celeste non può essere null!");
        Punto decideVelocità = posizione.sottrai(c.posizione()); // 3-5 = -2 (negativo)
        velocità = velocità.somma(new Punto(-(int)signum(decideVelocità.getX()), -(int)signum(decideVelocità.getY()), -(int)signum(decideVelocità.getZ())));
    }

    @Override
    public String toString() {
        return String.format("Pianeta, nome: %s, pos: %s, vel: %s", nome, posizione, velocità);
    }
}