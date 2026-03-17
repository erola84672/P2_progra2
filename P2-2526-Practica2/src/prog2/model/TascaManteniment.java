package prog2.model;

public class TascaManteniment implements InTascaManteniment{
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

    public TascaManteniment(int numero, Allotjament allotjament, String data, TascaManteniment.TipusTascaManteniment tipusTasca, int nombreDies){
        this.numero = numero;
        this.allotjament = allotjament;
        this.data = data;
        this.tipusTasca = tipusTasca;
        this.nombreDies = nombreDies;
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
}
