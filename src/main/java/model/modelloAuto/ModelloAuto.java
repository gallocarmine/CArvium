package model.modelloAuto;

import java.time.LocalDateTime;

public class ModelloAuto {

    private int ID;
    private int IDMarcaAuto;
    private String nome;
    private double prezzo;
    private String categoria;
    private String descrizione;
    private LocalDateTime data;
    private String pathanme;

    public ModelloAuto(int ID, int IDMarcaAuto, String nome, double prezzo, String categoria, String descrizione, LocalDateTime data, String pathanme) {

        this.ID = ID;
        this.IDMarcaAuto = IDMarcaAuto;
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.descrizione = descrizione;
        this.data = data;
        this.pathanme = pathanme;
    }

    public int getID() {
        return ID;
    }

    public int getIDMarcaAuto() {
        return IDMarcaAuto;
    }

    public String getNome() {
        return nome;
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

    public LocalDateTime getData() {
        return data;
    }

    public String getPathanme() {
        return pathanme;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIDMarcaAuto(int IDMarcaAuto) {
        this.IDMarcaAuto = IDMarcaAuto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setPathanme(String pathanme) {
        this.pathanme = pathanme;
    }
}
