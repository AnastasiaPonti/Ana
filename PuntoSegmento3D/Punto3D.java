public class Punto3D {
    //OVERVIEW: modella un punto 3D immutabile nello spazio
    private Punto2D p;
    private double x, y, z;
    private Object o;

    public Punto3D(double x, double y, double z) {
        p = new Punto2D(x, y);
        this.z = z;
    }

    public double getX() {
        return this.p.getX();
    }

    public double getY() {
        return this.p.getY();
    }

    public double getZ() {
        return this.z;
    }

    @Override
    public String toString () {
        return "Punto3D - (x: " + this.getX() + this.getY() + this.getZ() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (o instanceof Punto3D) {
            Punto3D p = (Punto3D) o;
            if ((this.x == p.x) && (this.y == p.y) && (this.z == p.z)) {
                return true;
            } else if (o instanceof Punto2D) {
                Punto2D q = (Punto2D) o;
                if ((this.x == q.x) && (this.y == q.y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Punto3D p = new Punto3D(1, 3, 5);
        //Punto3D q = new Punto3D(1, 3);
        //Punto3D pr = new Punto3D(1, 3, 7);
    }
}
