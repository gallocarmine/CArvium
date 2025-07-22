package model.modelloAuto;

import java.time.LocalDateTime;

public class ModelloAuto {

    private String ID;
    private String IDMarcaAuto;
    private double prezzo;
    private String categoria;
    private String descrizione;
    private int anno;
    private String pathanme;

    public ModelloAuto(String ID, String IDMarcaAuto, double prezzo, String categoria, String descrizione, int anno) {

        this.ID = ID;
        this.IDMarcaAuto = IDMarcaAuto;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.descrizione = descrizione;
        this.anno = anno;
    }

    public String getID() {
        return ID;
    }

    public String getIDMarcaAuto() {
        return IDMarcaAuto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getAnno() {
        return anno;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public void setIDMarcaAuto(String IDMarcaAuto) { this.IDMarcaAuto = IDMarcaAuto;}

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
}
