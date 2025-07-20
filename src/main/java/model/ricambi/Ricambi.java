package model.ricambi;

import java.time.LocalDateTime;

public class Ricambi {
    private String ID;
    private double prezzo;
    private String categoria;
    private int quantita;
    private int anno;
    private String IDModelloAuto;
    private String IDMarcaAuto;

    public Ricambi(String ID, double prezzo, String categoria, int quantita, int anno, String IDModelloAuto, String IDMarcaAuto) {
        this.ID = ID;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.quantita = quantita;
        this.anno = anno;
        this.IDModelloAuto = IDModelloAuto;
        this.IDMarcaAuto = IDMarcaAuto;
    }

    public String getID() {
        return ID;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantita() { return quantita; }

    public int getAnno() {
        return anno;
    }

    public String getIDModelloAuto() {
        return IDModelloAuto;
    }

    public String getIDMarcaAuto() {
        return IDMarcaAuto;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantita(int quantita) { this.quantita = quantita; }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setIDModelloAuto(String IDModelloAuto) {
        this.IDModelloAuto = IDModelloAuto;
    }

    public void setIDMarcaAuto(String IDMarcaAuto) {
        this.IDMarcaAuto = IDMarcaAuto;
    }
}
