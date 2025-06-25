package model.salvare;

import model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalvareDAO {

    public List<Salvare> doRetrieveAll(){

        List<Salvare> saves = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Salvare";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int idModelloAuto = rs.getInt("ID_ModelloAuto");
                int idMarcaAuto = rs.getInt("ID_MarcaAuto");
                int idUtente = rs.getInt("ID_Utente");

                Salvare save = new Salvare(idModelloAuto, idMarcaAuto, idUtente);
                saves.add(save);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return saves;
    }

    public int doSave(Salvare save){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Salvare (ID_ModelloAuto, ID_MarcaAuto, ID_Utente) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, save.getIDModelloAuto());
            ps.setInt(2, save.getIDMarcaAuto());
            ps.setInt(3, save.getIDUtente());
            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
