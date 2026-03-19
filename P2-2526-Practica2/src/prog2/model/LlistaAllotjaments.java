package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.*;

public class LlistaAllotjaments implements InLlistaAllotjaments{
    private ArrayList<Allotjament> llistaAllotjaments;

    public LlistaAllotjaments() {
        this.llistaAllotjaments = new ArrayList<Allotjament>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        //exception
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
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        String info = "";

        while (itr.hasNext()) {
            Allotjament a = itr.next();

            if (a.getEstatAllotjament().equals(estat)) {
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
        String estat = "Operatiu";
        boolean trobat = false;

        while (itr.hasNext() && !trobat) {
            Allotjament a = itr.next();

            if (a.getEstatAllotjament().equals(estat)) {
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
