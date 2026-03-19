package prog2.model;

public class CamiAsfaltat extends AccesAsfalt{
    public CamiAsfaltat(String nom, LlistaAllotjaments llistaAllotjaments, float metresQuadrats) {
        super(nom, false, llistaAllotjaments, metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
