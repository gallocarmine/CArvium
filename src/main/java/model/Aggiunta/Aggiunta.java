package model.Aggiunta;

public class Aggiunta {

    private int IDCarrello;
    private int IDRicambi;

    public Aggiunta(int IDCarrello, int IDRicambi) {

        this.IDCarrello = IDCarrello;
        this.IDRicambi = IDRicambi;
    }

    public int getIDCarrello() {
        return IDCarrello;
    }

    public int getIDRicambio() {
        return IDRicambi;
    }

    public void setIDCarrello(int IDCarrello) {
        this.IDCarrello = IDCarrello;
    }

    public void setIDRicambio(int IDRicambi) {
        this.IDRicambi = IDRicambi;
    }

}
