package model.ricambi;

import java.time.LocalDateTime;

public class Ricambi {
    private int ID;
    private String nome;
    private double prezzo;
    private String categoria;
    private int quantita;
    private int anno;
    private int IDModelloAuto;
    private int IDMarcaAuto;

    public Ricambi(int ID, String nome, double prezzo, String categoria, int quantita, int anno, int IDModelloAuto, int IDMarcaAuto) {
        this.ID = ID;
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.quantita = quantita;
        this.anno = anno;
        this.IDModelloAuto = IDModelloAuto;
        this.IDMarcaAuto = IDMarcaAuto;
    }

    public int getID() {
        return ID;
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

    public int getQuantita() { return quantita; }

    public int getAnno() {
        return anno;
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

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setIDModelloAuto(int IDModelloAuto) {
        this.IDModelloAuto = IDModelloAuto;
    }

    public void setIDMarcaAuto(int IDMarcaAuto) {
        this.IDMarcaAuto = IDMarcaAuto;
    }
}
