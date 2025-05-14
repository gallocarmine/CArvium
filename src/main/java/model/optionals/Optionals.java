package model.optionals;

public class Optionals {
    private int ID;
    private String name;
    private double prezzo;
    private String descrizione;
    private int IDModelloAuto;
    private int IDMarcaAuto;

    public Optionals(int ID, String name, double prezzo, String descrizione, int IDModelloAuto, int IDMarcaAuto) {
        this.ID = ID;
        this.name = name;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.IDModelloAuto = IDModelloAuto;
        this.IDMarcaAuto = IDMarcaAuto;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getIDModelloAuto() {
        return IDModelloAuto;
    }

    public int getIDMarcaAuto() {
        return IDMarcaAuto;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setIDModelloAuto(int IDModelloAuto) {
        this.IDModelloAuto = IDModelloAuto;
    }

    public void setIDMarcaAuto(int IDMarcaAuto) {
        this.IDMarcaAuto = IDMarcaAuto;
    }
}
