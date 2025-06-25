package model.generare;

import java.time.LocalDateTime;

public class Generare {

    private int IDOrdine;
    private int IDCarrello;
    private LocalDateTime data;

    public Generare(int IDOrdine, int IDCarrello, LocalDateTime date) {
        this.IDOrdine = IDOrdine;
        this.IDCarrello = IDCarrello;
        this.data = date;
    }

    public int getIDOrdine() {
        return IDOrdine;
    }

    public int getIDCarrello() {
        return IDCarrello;
    }

    public LocalDateTime getData() {
        return data;
    }


    public void setIDOrdine(int IDOrdine) {
        this.IDOrdine = IDOrdine;
    }

    public void setIDCarrello(int IDCarrello) {
        this.IDCarrello = IDCarrello;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
