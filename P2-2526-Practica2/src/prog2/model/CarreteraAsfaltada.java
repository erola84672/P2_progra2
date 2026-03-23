package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt {
    private float pesMaxim;

    public CarreteraAsfaltada(String nom, boolean estat, float metresQuadrats, float pesMaxim) {
        super(nom, estat, metresQuadrats);
        this.pesMaxim = pesMaxim;
        this.accessibilitat = isAccessibilitat();
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
