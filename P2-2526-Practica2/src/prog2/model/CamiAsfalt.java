package prog2.model;

public class CamiAsfalt extends AccesAsfalt{
    public CamiAsfalt(String nom, LlistaAllotjaments llistaAllotjaments, float metresQuadrats) {
        super(nom, false, llistaAllotjaments, metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
