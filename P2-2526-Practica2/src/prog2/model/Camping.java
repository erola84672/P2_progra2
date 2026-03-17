package prog2.model;
import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class Camping implements InCamping{
    private String nom;
    private ArrayList<Allotjament> llistaAllotjaments;

    /**
     * Constructor d'objectes de la classe Camping. Crea, a més a més, dos objectes d'ArrayList i un de LlistaReserves
     * @param nom nom del càmping.
     */
    public Camping(String nom){
        this.nom = nom;
    }
    @Override
    public String getNomCamping() {
        return nom;
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return "";
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {

    }

    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {

    }

    @Override
    public int calculaAccessosNoAccessibles() {
        return 0;
    }

    @Override
    public float calculaMetresTerra() {
        return 0;
    }

    @Override
    public void save(String camiDesti) throws ExcepcioCamping {

    }

    @Override
    public void inicialitzaDadesCamping() {

    }
}
