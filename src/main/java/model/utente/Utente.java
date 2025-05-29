package model.utente;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utente {
    private int ID;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String via;
    private int civico;
    private int CAP;
    private int IDCarrello;
    private boolean admin;

    public Utente(){ }

    public Utente(int ID, String nome, String cognome, String email, String password, String via, int civico, int CAP, boolean admin, int IDCarrello) {
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.via = via;
        this.civico = civico;
        this.CAP = CAP;
        this.IDCarrello = IDCarrello;
        this.admin = admin;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getVia() {
        return via;
    }

    public int getCivico() {
        return civico;
    }

    public int getCAP() {
        return CAP;
    }

    public int getIDCarrello() {
        return IDCarrello;
    }

    public boolean getAdmin() { return admin; }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();

            digest.update(password.getBytes(StandardCharsets.UTF_8));
            this.password = String.format("%040x", new BigInteger(1, digest.digest()));
        }
        catch(NoSuchAlgorithmException e) {

            throw new RuntimeException(e);
        }

    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }

    public void setCAP(int CAP) {
        this.CAP = CAP;
    }

    public void setAdmin(boolean admin) { this.admin = admin; }

    public void setIDCarrello(int IDCarrello) {
        this.IDCarrello = IDCarrello;
    }
}
