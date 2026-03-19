package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.*;

public class LlistaAllotjaments implements InLlistaAllotjaments{
    private ArrayList<Allotjament> llistaAllotjaments;

    public LlistaAllotjaments() {
        this.llistaAllotjaments = new ArrayList<Allotjament>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        llistaAllotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();

        while (itr.hasNext()) {
            itr.remove();
        }
    }

    @Override
    public String llistarAllotjaments(String infoEstat) throws ExcepcioCamping {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        String info = "";
        boolean estat;

        if (infoEstat.equals("Obert")) {
            estat = true;
        } else if (infoEstat.equals("Tancat")) {
            estat = false;
        } else
            throw new ExcepcioCamping("L'estat és incorrecte");

        while (itr.hasNext()) {
            Allotjament a = itr.next();

            if (a.getEstatAllotjament() == estat) {
                info += a.toString();
            }
        }

        if (info.equals("")) {
            throw new ExcepcioCamping("No hi ha allotjaments en l'estat " + estat);
        }

        return info;
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        boolean estat = true;
        boolean trobat = false;

        while (itr.hasNext() && !trobat) {
            Allotjament a = itr.next();

            if (a.getEstatAllotjament() == estat) {
                trobat = true;
            }
        }

        return trobat;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        boolean trobat = false;

        while (itr.hasNext() && !trobat) {
            Allotjament a = itr.next();

            if (a.equals(allotjament)) {
                trobat = true;
            }
        }

        return trobat;
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        boolean trobat = false;
        Allotjament a = null;

        while (itr.hasNext() && !trobat) {
            a = itr.next();

            if (a.getId().equals(id)) {
                trobat = true;
            }
        }

        if (!trobat)
            throw new ExcepcioCamping("L'allotjament no existeix");
        return a;
    }
}
