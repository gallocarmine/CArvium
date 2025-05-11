package model.marcaAuto;

public class MarcaAuto {

    private int ID;
    private String nome;
    private String pathname;

    public MarcaAuto(int ID, String nome, String pathname) {

        this.ID = ID;
        this.nome = nome;
        this.pathname = pathname;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getPathname() {
        return pathname;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }
}
