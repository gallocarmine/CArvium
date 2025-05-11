package model.configurazione;

import java.time.LocalDateTime;

public class Configurazione {

    private int ID;
    private LocalDateTime data;
    private int IDModelloAuto;
    private int IDMarcaAuto;
    private int IDUtente;

    public Configurazione(int ID, LocalDateTime data, int IDModelloAuto, int IDMarcaAuto, int IDUtente) {

        this.ID = ID;
        this.data = data;
        this.IDModelloAuto = IDModelloAuto;
        this.IDMarcaAuto = IDMarcaAuto;
        this.IDUtente = IDUtente;
    }

    public int getIDModelloAuto() {
        return IDModelloAuto;
    }

    public int getID() {
        return ID;
    }

    public LocalDateTime getData() {
        return data;
    }

    public int getIDMarcaAuto() {
        return IDMarcaAuto;
    }

    public int getIDUtente() {
        return IDUtente;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setIDModelloAuto(int IDModelloAuto) {
        this.IDModelloAuto = IDModelloAuto;
    }

    public void setIDMarcaAuto(int IDMarcaAuto) {
        this.IDMarcaAuto = IDMarcaAuto;
    }

    public void setIDUtente(int IDUtente) {
        this.IDUtente = IDUtente;
    }
}
