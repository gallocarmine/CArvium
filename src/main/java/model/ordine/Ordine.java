package model.ordine;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ordine {

    private int ID;
    private int quantita;
    private double costoTotale;

    public Ordine(int ID, int quantita, double costoTotale) {
        this.ID = ID;
        this.quantita = quantita;
        this.costoTotale = costoTotale;
    }

    public int getID() {
        return ID;
    }

    public int getQuantita() {
        return quantita;
    }

    public double getCostoTotale() {
        return costoTotale;
    }


    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCostoTotale(double costoTotale) {
        this.costoTotale = costoTotale;
    }
}
