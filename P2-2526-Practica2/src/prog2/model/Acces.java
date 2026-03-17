package prog2.model;

public class Acces implements InAcces{
    @Override
    public void afegirAllotjament(Allotjament allotjament) {

    }

    @Override
    public void tancarAcces() {

    }

    @Override
    public void obrirAcces() {

    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String getNom() {
        return "";
    }

    @Override
    public boolean getEstat() {
        return false;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return null;
    }
}
