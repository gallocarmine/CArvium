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
                int quantita = rs.getInt("Quantità");
                double costoTotale = rs.getInt("CostoTotale");
                LocalDateTime data = rs.getTimestamp("Data").toLocalDateTime();
                int idCarrello = rs.getInt("IDCarrello");

                Ordine order = new Ordine(id, quantita, costoTotale, data, idCarrello);
                orders.add(order);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }
        return orders;
    }


    public List<Ordine> doRetrieveByIDCart(int idCart){

        List<Ordine> orders = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Ordine WHERE ID_Carrello = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCart);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int id = rs.getInt("ID");
                int quantita = rs.getInt("Quantità");
                double costoTotale = rs.getInt("CostoTotale");
                LocalDateTime data = rs.getTimestamp("Data").toLocalDateTime();

                Ordine order = new Ordine(id, quantita, costoTotale, data, idCart);
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

            String sql = "INSERT INTO Ordine (ID, Quantità, CostoTotale, Data, IDCarrello) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, order.getID());
            ps.setInt(2, order.getQuantita());
            ps.setDouble(3, order.getCostoTotale());
            ps.setTimestamp(4, Timestamp.valueOf(order.getData()));
            ps.setInt(5, order.getIDCarrello());


            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
