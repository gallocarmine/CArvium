package model.ordine;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ordine {

    private int ID;
    private int quantita;
    private double costoTotale;
    private LocalDateTime data;
    private int IDCarrello;

    public Ordine() {}


    public Ordine(int ID, int quantita, double costoTotale, LocalDateTime data, int IDCarrello) {
        this.ID = ID;
        this.quantita = quantita;
        this.costoTotale = costoTotale;
        this.data = data;
        this.IDCarrello = IDCarrello;
    }

    public Ordine(int quantita, double costoTotale, LocalDateTime data, int IDCarrello) {

        this.quantita = quantita;
        this.costoTotale = costoTotale;
        this.data = data;
        this.IDCarrello = IDCarrello;
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

    public LocalDateTime getData() { return data; }

    public int getIDCarrello() { return IDCarrello; }


    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCostoTotale(double costoTotale) {
        this.costoTotale = costoTotale;
    }

    public void setData(LocalDateTime data) { this.data = data; }

    public void setIDCarrello(int IDCarrello) { this.IDCarrello = IDCarrello; }
}
