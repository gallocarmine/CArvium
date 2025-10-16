package model.aggiungere;

public class Aggiungere {

    private int IDCarrello;
    private String IDRicambio;
    private int quantita;


    public Aggiungere(){

    }

    public Aggiungere(int IDCarrello, String IDRicambio, int quantita) {

        this.IDCarrello = IDCarrello;
        this.IDRicambio = IDRicambio;
        this.quantita = quantita;
    }

    public int getIDCarrello() {
        return IDCarrello;
    }

    public String getIDRicambio() {
        return IDRicambio;
    }

    public int getQuantita() {return quantita;}


    public void setIDCarrello(int IDCarrello) {
        this.IDCarrello = IDCarrello;
    }

    public void setIDRicambio(String IDRicambi) {
        this.IDRicambio = IDRicambi;
    }

    public void setQuantita(int quantita) {this.quantita = quantita;}
}
