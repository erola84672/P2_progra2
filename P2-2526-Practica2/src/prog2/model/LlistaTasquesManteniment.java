package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable {
    private ArrayList<TascaManteniment> llistaTasques;

    public LlistaTasquesManteniment() {
        this.llistaTasques = new ArrayList<TascaManteniment>();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        if (allotjament.getEstatAllotjament() == false) {
            throw new ExcepcioCamping("L'allotjament ja té una tasca programada");
        }

        TascaManteniment novaTasca = new TascaManteniment(num, TascaManteniment.TipusTascaManteniment.valueOf(tipus), allotjament, data, dies);
        allotjament.tancarAllotjament(novaTasca);
        llistaTasques.add(novaTasca);

    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        Iterator<TascaManteniment> itr = llistaTasques.iterator();
        boolean trobat = false;

        while (itr.hasNext() && !trobat) {
            TascaManteniment t = itr.next();

            if (t.equals(tasca)) {
                trobat = true;
                itr.remove();
            }
        }

        if (!trobat) {
            throw new ExcepcioCamping("Aquesta tasca no existeix");
        }

        (tasca.getAllotjament()).obrirAllotjament();
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        Iterator<TascaManteniment> itr = llistaTasques.iterator();
        String info = "";

        if (llistaTasques.isEmpty()) {
            throw new ExcepcioCamping("No hi ha cap tasca");
        }

        while (itr.hasNext()) {
            TascaManteniment t = itr.next();
            info += t.toString() + "\n";
        }

        return info;
    }

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        Iterator<TascaManteniment> itr = llistaTasques.iterator();
        boolean trobat = false;
        TascaManteniment t = null;

        while (itr.hasNext() && !trobat) {
            t = itr.next();

            if (t.getNum() == num) {
                trobat = true;
            }
        }

        if (!trobat) {
            throw new ExcepcioCamping("Aquesta tasca no existeix");
        }
        return t;
    }
}
