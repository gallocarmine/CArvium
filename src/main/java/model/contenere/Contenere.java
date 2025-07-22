package model.contenere;

public class Contenere {

    private int IDOrdine;
    private String IDRicambi;
    private int quantita;
    private double prezzoUnitario;

    public Contenere(int IDOrdine, String IDRicambi, int quantita, double prezzoUnitario) {
        this.IDOrdine = IDOrdine;
        this.IDRicambi = IDRicambi;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }


    public int getIDOrdine() {
        return IDOrdine;
    }

    public String getIDRicambi() {
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

    public void setIDRicambi(String IDRicambi) {
        this.IDRicambi = IDRicambi;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }
}
