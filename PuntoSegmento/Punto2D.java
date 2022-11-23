public class Punto2D {
    //OVERVIEW: modella un punto IMMUTABILE sul piano cartesiano
    final double x, y;

    //COSTRUTTORI:
        public Punto2D (double x, double y) {
            //MODIFIES: this
            //EFFECTS: inizializza this con ordinate x e y
            this.x = x;
            this.y = y;
        }

        public Punto2D () {
            //MODIFIES: this
            //EFFECTS: inizializza this con coordinate 0 e 0
            this.x = 0;
            this.y = 0;
        }

        public double getX () {
            return this.x;
        }

        public double getY () {
            return this.y;
        }

        @Override
        public String toString () {
            return "Punto2D - (x: " + this.getX() + ", y: " + this.getY() + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Punto2D) {
                Punto2D p = (Punto2D) obj;
                if ((p.x == this.x) && (p.y == this.y)) {
                    return true;
                }
            }
            return false;
        }
}
