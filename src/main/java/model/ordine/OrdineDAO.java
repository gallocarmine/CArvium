package model.ordine;

import model.ConPool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdineDAO {

    public List<Ordine> doRetrieveAll(){

        List<Ordine> orders = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Ordine";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int id = rs.getInt("ID");
                LocalDateTime data = rs.getTimestamp("Data").toLocalDateTime();
                int idUtente = rs.getInt("ID_Utente");

                Ordine order = new Ordine( id, data, idUtente);
                orders.add(order);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }
        return orders;
    }

    public int doSave(Ordine ordine){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Ordine (Data, ID_Utente) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(ordine.getData()));
            ps.setInt(2, ordine.getIDUtente());

            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
