package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {
    private float pesMaxim;

    public CarreteraAsfalt(String nom, LlistaAllotjaments llistaAllotjaments, float metresQuadrats, float pesMaxim) {
        super(nom, true, llistaAllotjaments, metresQuadrats);
        this.pesMaxim = pesMaxim;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    public float getPesMaxim() {
        return pesMaxim;
    }

    @Override
    public String toString() {
        String info = super.toString();
        info += ", Pes màxim: " + pesMaxim + "kg";

        return info;
    }
}
