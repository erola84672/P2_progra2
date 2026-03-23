package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos, Serializable {
    private ArrayList<Acces> llistaAccessos;

    public LlistaAccessos() {
        this.llistaAccessos = new ArrayList<Acces>();
    }

    @Override
    public void afegirAcces(Acces acc) {
        llistaAccessos.add(acc);
    }

    @Override
    public void buidar() {
        Iterator<Acces> itr = llistaAccessos.iterator();

        while (itr.hasNext()) {
            itr.remove();
        }
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        Iterator<Acces> itr = llistaAccessos.iterator();
        String info = "";

        while (itr.hasNext()) {
            Acces a = itr.next();

            if (a.getEstat() == estat) {
                info += a.toString() + "\n";
            }

        }

        if (info.equals("")) {
            throw new ExcepcioCamping("No hi ha accessos en aquest estat");
        }

        return info;
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        Iterator<Acces> itr = llistaAccessos.iterator();
        boolean jovull = false;

        while (itr.hasNext()) {
            Acces a = itr.next();

            if (a.getAAllotjaments().containsAllotjamentOperatiu())
                a.setEstat(true);
            else
                a.setEstat(false);
        }

        //excpetion
    }

    @Override
    public int calculaAccessosNoAccessibles() {
        int comptador = 0;
        Iterator<Acces> itr = llistaAccessos.iterator();

        while (itr.hasNext()) {
            Acces a = itr.next();

            if (!a.isAccessibilitat())
                comptador++;
        }
        return comptador;
    }

    @Override
    public float calculaMetresTerra() {
        float metresTotals = 0;
        Iterator<Acces> itr = llistaAccessos.iterator();

        while (itr.hasNext()) {
            Acces a = itr.next();

            if (a instanceof AccesTerra)
                metresTotals += ((AccesTerra) a).getLongitud();
        }

        return metresTotals;
    }
}
