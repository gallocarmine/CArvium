package model.ordine;

import model.ConPool;

import java.sql.*;
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
                int quantita = rs.getInt("Quantità");
                double costoTotale = rs.getInt("CostoTotale");

                Ordine order = new Ordine(id, quantita, costoTotale);
                orders.add(order);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }
        return orders;
    }

    public int doSave(Ordine order){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Ordine (Data, ID_Utente) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, order.getID());
            ps.setInt(2, order.getQuantita());
            ps.setDouble(3, order.getCostoTotale());

            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
