package model.ricambi;

import java.time.LocalDateTime;

public class Ricambi {
    private int ID;
    private String nome;
    private double prezzo;
    private String categoria;
    private LocalDateTime anno;
    private String pathname;
    private int IDModelloAuto;
    private int IDMarcaAuto;

    public Ricambi(int ID, String nome, double prezzo, String categoria, LocalDateTime anno, String pathname, int IDModelloAuto, int IDMarcaAuto) {
        this.ID = ID;
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.anno = anno;
        this.pathname = pathname;
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

    public LocalDateTime getAnno() {
        return anno;
    }

    public String getPathname() {
        return pathname;
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

    public void setAnno(LocalDateTime anno) {
        this.anno = anno;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public void setIDModelloAuto(int IDModelloAuto) {
        this.IDModelloAuto = IDModelloAuto;
    }

    public void setIDMarcaAuto(int IDMarcaAuto) {
        this.IDMarcaAuto = IDMarcaAuto;
    }
}
