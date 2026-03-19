package prog2.model;

public abstract class AccesTerra extends Acces {
    private float longitud;

    public AccesTerra(String nom, boolean accessibilitat, LlistaAllotjaments llistaAllotjaments, float longitud) {
        super(nom, accessibilitat, llistaAllotjaments);
        this.longitud = longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLongitud() {
        return longitud;
    }

    @Override
    public String toString() {
        String info = super.toString();
        info += ", Longitud: " + longitud + "m";

        return info;
    }
}

