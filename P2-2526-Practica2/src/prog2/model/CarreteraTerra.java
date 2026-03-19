package prog2.model;

public class CarreteraTerra extends AccesTerra {
    private float amplada;

    public CarreteraTerra(String nom, LlistaAllotjaments llistaAllotjaments, float longitud, float amplada) {
        super(nom, true, llistaAllotjaments, longitud);
        this.amplada = amplada;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

    public float getAmplada() {
        return amplada;
    }

    @Override
    public String toString() {
        String info = super.toString();
        info += ", Amplada: " + amplada + "m";

        return info;
    }
}
