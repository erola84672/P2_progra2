package prog2.model;

import prog2.vista.ExcepcioCamping;

public abstract class Acces implements InAcces{
    private String nom;
    protected boolean accessibilitat;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.estat = estat;
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        llistaAllotjaments.afegirAllotjament(allotjament);
    }

    @Override
    public void tancarAcces() {
        this.estat = false;
    }

    @Override
    public void obrirAcces() {
        this.estat = true;
    }

    @Override
    public boolean isAccessibilitat() {
        return accessibilitat;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public boolean getEstat() {
        return estat;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return llistaAllotjaments;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public void setLlistaAllotjaments(LlistaAllotjaments llistaAllotjaments) {
        this.llistaAllotjaments = llistaAllotjaments;
    }

    @Override
    public String toString() {
        String info = "Nom: " + nom + ", Accessibilitat: " + accessibilitat + ", Estat: " + estat + ", Allotjaments: ";

        try {
            info += llistaAllotjaments.llistarAllotjaments("Obert");
        } catch (ExcepcioCamping e){}

        try {
            info += llistaAllotjaments.llistarAllotjaments("Tancat");
        } catch (ExcepcioCamping e) {}

        return info;
    }
}
