package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.Iterator;

public abstract class Acces implements InAcces{
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nom, boolean accessibilitat, LlistaAllotjaments llistaAllotjaments) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.llistaAllotjaments = llistaAllotjaments;
        this.estat = true;
    }

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
        String info = "Nom: " + nom + ", Accessibilitat: " + accessibilitat + ", Estat: " + estat + ", Allotjaments: "
                + llistaAllotjaments.llistarAllotjaments("Operatiu");

        return info;
    }
}
