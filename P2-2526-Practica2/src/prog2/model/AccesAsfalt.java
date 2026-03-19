package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private float metresQuadrats;

    public AccesAsfalt(String nom,boolean estat, float metresQuadrats) {
        super(nom, estat);
        this.metresQuadrats = metresQuadrats;
    }

    public void setMetresQuadrats(float metres) {
        this.metresQuadrats = metres;
    }

    public float getMetresQuadrats() {
        return metresQuadrats;
    }

    @Override
    public String toString() {
        String info = super.toString();
        info += ", Metres quadrats: " + metresQuadrats + "m²";

        return info;
    }
}
