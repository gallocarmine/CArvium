package model.aggiungere;

import model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AggiungereDAO {

    public List<Aggiungere> doRetrieveAll(){

        List<Aggiungere> adds = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Aggiungere";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int idCarrello = rs.getInt("ID_Carrello");
                String idRicambio = rs.getString("ID_Ricambi");
                int quantita = rs.getInt("Quantità");

                Aggiungere add = new Aggiungere(idCarrello, idRicambio, quantita);
                adds.add(add);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return adds;
    }

    public int doSave(Aggiungere add){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Aggiungere (ID_Carrello, ID_Ricambi, Quantità) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, add.getIDCarrello());
            ps.setString(2, add.getIDRicambio());
            ps.setInt(3, add.getQuantita());
            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
