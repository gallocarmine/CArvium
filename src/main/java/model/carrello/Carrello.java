package model.carrello;

public class Carrello {

    private int ID;
    private double costoTotale;
    private int quantita;

    public Carrello() { }

    public Carrello(int ID, double costoTotale, int quantita) {

        this.ID = ID;
        this.costoTotale = costoTotale;
        this.quantita = quantita;
    }

    public int getID() {
        return ID;
    }

    public double getCostoTotale() {
        return costoTotale;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCostoTotale(double costoTotale) {
        this.costoTotale = costoTotale;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
