package model.salvare;

public class Salvare {

    private int IDModelloAuto;
    private int IDMarcaAuto;
    private int IDUtente;

    public Salvare(int IDModelloAuto, int IDMarcaAuto, int IDUtente) {
        this.IDModelloAuto = IDModelloAuto;
        this.IDMarcaAuto = IDMarcaAuto;
        this.IDUtente = IDUtente;
    }

    public int getIDModelloAuto() {
        return IDModelloAuto;
    }

    public int getIDMarcaAuto() {
        return IDMarcaAuto;
    }

    public int getIDUtente() {
        return IDUtente;
    }

    public void setIDModelloAuto(int IDModelloAuto) {
        this.IDModelloAuto = IDModelloAuto;
    }

    public void setIDMarcaAuto(int IDMarcaAuto) {
        this.IDMarcaAuto = IDMarcaAuto;
    }

    public void setIDUtente(int IDUtente) {
        this.IDUtente = IDUtente;
    }
}
