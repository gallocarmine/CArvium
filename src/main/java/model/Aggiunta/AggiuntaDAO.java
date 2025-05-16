package model.Aggiunta;

import model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AggiuntaDAO {

    public List<Aggiunta> doRetrieveAll(){

        List<Aggiunta> adds = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Aggiungere";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int idCarrello = rs.getInt("ID_Carrello");
                int idRicambio = rs.getInt("ID_Ricambi");

                Aggiunta add = new Aggiunta(idCarrello, idRicambio);
                adds.add(add);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return adds;
    }

    public int doSave(Aggiunta add){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Aggiungere (ID_Carrello, ID_Ricambi) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, add.getIDCarrello());
            ps.setInt(2, add.getIDRicambio());
            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
