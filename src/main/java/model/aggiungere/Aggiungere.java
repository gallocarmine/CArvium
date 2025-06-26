package model.aggiungere;

public class Aggiungere {

    private int IDCarrello;
    private int IDRicambi;
    private int quantita;

    public Aggiungere(int IDCarrello, int IDRicambi, int quantita) {

        this.IDCarrello = IDCarrello;
        this.IDRicambi = IDRicambi;
        this.quantita = quantita;
    }

    public int getIDCarrello() {
        return IDCarrello;
    }

    public int getIDRicambio() {
        return IDRicambi;
    }

    public int getQuantita() {return quantita;}


    public void setIDCarrello(int IDCarrello) {
        this.IDCarrello = IDCarrello;
    }

    public void setIDRicambio(int IDRicambi) {
        this.IDRicambi = IDRicambi;
    }

    public void setQuantita(int quantita) {this.quantita = quantita;}
}
