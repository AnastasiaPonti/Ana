// Una piastrella è un elemento architettonico usato per rivestire la superficie dei
// pavimenti; ne esistono di diversi tipi, ciascuno dei quali è caratterizzato da una
// serie di caratteristiche, tra le quali almeno la superficie e il costo unitario
// (che per semplicità assumeremo rappresentati da numeri interi).

// Esempi di piastrelle possono essere: triangolari (caratterizzate da base e altezza),
// quadrate (caratterizzate dalla lunghezza del lato), romboidali (caratterizzate dalla
// lunghezza delle due diagonali) e così via…

public abstract class Piastrella implements Rivestimento {

    final private int superficie, costo; 

    // COSTRUTTORI:
    public Piastrella {
        this.superficie = Objects.requireNonNull(nome, "Il nome non può essere null");
    }
}