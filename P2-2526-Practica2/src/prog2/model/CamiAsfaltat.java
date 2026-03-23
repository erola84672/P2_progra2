package prog2.model;

public class CamiAsfaltat extends AccesAsfalt{
    public CamiAsfaltat(String nom, boolean estat, float metresQuadrats) {
        super(nom, estat, metresQuadrats);
        this.accessibilitat = isAccessibilitat();
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
