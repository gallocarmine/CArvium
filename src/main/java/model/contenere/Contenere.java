package model.contenere;

public class Contenere {

    private int IDOrdine;
    private int IDRicambi;
    private int quantita;
    private double prezzoUnitario;

    public Contenere(int IDOrdine, int IDRicambi, int quantita, double prezzoUnitario) {
        this.IDOrdine = IDOrdine;
        this.IDRicambi = IDRicambi;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }


    public int getIDOrdine() {
        return IDOrdine;
    }

    public int getIDRicambi() {
        return IDRicambi;
    }

    public int getQuantita() {
        return quantita;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }


    public void setIDOrdine(int IDOrdine) {
        this.IDOrdine = IDOrdine;
    }

    public void setIDRicambi(int IDRicambi) {
        this.IDRicambi = IDRicambi;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }
}
