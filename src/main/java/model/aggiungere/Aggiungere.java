package model.aggiungere;

public class Aggiungere {

    private int IDCarrello;
    private int IDRicambi;

    public Aggiungere(int IDCarrello, int IDRicambi) {

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
