package model.ordine;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ordine {
    private int ID;
    private LocalDateTime data;
    private int IDUtente;

    public Ordine(int ID, LocalDateTime data, int IDUtente) {
        this.ID = ID;
        this.data = data;
        this.IDUtente = IDUtente;
    }

    public int getID() {
        return ID;
    }

    public LocalDateTime getData() {
        return data;
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

    public void setIDUtente(int IDUtente) {
        this.IDUtente = IDUtente;
    }
}
