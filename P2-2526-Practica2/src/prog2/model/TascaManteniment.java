package prog2.model;
import java.io.Serializable;
public class TascaManteniment implements InTascaManteniment, Serializable{
    private int numero;
    private Allotjament allotjament;
    private String data;
    private TascaManteniment.TipusTascaManteniment tipusTasca;
    private int nombreDies;
    public static enum TipusTascaManteniment{
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    }

    public TascaManteniment(int numero, TascaManteniment.TipusTascaManteniment tipus, Allotjament allotjament, String data, int dies){
        this.numero = numero;
        this.allotjament = allotjament;
        this.data = data;
        this.tipusTasca = tipus;
        this.nombreDies = dies;
    }
    @Override
    public int getNum() {
        return numero;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return tipusTasca;
    }

    @Override
    public Allotjament getAllotjament() {
        return allotjament;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public int getDies() {
        return nombreDies;
    }

    @Override
    public void setNum(int num_) {
        this.numero = num_;
    }

    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {
        this.tipusTasca = tipus_;
    }

    @Override
    public void setAllotjament(Allotjament allotjament_) {
        this.allotjament = allotjament_;
    }

    @Override
    public void setData(String data_) {
        this.data = data_;
    }

    @Override
    public void setDies(int dies_) {
        this.nombreDies = dies_;
    }

    @Override
    public String getIluminacioAllotjament() {
        return allotjament.getEstatIluminacio();
    }

    @Override
    public String toString() {
        String info = "Número de tasca: " + numero + ", Tipus de tasca: " + tipusTasca + ", Allotjament amb ID: " + allotjament.getId()
                + ", Data: " + data + ", Nombre de dies: " + nombreDies;

        return info;
    }
}
