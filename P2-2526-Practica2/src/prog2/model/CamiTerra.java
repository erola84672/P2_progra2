package prog2.model;

public class CamiTerra extends AccesTerra {
    public CamiTerra(String nom, LlistaAllotjaments llistaAllotjaments, float longitud) {
        super(nom, false, llistaAllotjaments, longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
