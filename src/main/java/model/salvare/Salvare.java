package model.salvare;

public class Salvare {

    private String IDModelloAuto;
    private String IDMarcaAuto;
    private int IDUtente;

    public Salvare() {}

    public Salvare(String IDModelloAuto, String IDMarcaAuto, int IDUtente) {
        this.IDModelloAuto = IDModelloAuto;
        this.IDMarcaAuto = IDMarcaAuto;
        this.IDUtente = IDUtente;
    }

    public String getIDModelloAuto() {
        return IDModelloAuto;
    }

    public String getIDMarcaAuto() {
        return IDMarcaAuto;
    }

    public int getIDUtente() {
        return IDUtente;
    }

    public void setIDModelloAuto(String IDModelloAuto) {
        this.IDModelloAuto = IDModelloAuto;
    }

    public void setIDMarcaAuto(String IDMarcaAuto) {
        this.IDMarcaAuto = IDMarcaAuto;
    }

    public void setIDUtente(int  IDUtente) {
        this.IDUtente = IDUtente;
    }
}
