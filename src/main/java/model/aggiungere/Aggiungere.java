package model.aggiungere;

public class Aggiungere {

    private int IDCarrello;
    private String IDRicambi;
    private int quantita;

    public Aggiungere(int IDCarrello, String IDRicambi, int quantita) {

        this.IDCarrello = IDCarrello;
        this.IDRicambi = IDRicambi;
        this.quantita = quantita;
    }

    public int getIDCarrello() {
        return IDCarrello;
    }

    public String getIDRicambio() {
        return IDRicambi;
    }

    public int getQuantita() {return quantita;}


    public void setIDCarrello(int IDCarrello) {
        this.IDCarrello = IDCarrello;
    }

    public void setIDRicambio(String IDRicambi) {
        this.IDRicambi = IDRicambi;
    }

    public void setQuantita(int quantita) {this.quantita = quantita;}
}
