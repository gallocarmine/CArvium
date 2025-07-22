package model.carrello;

import model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrelloDAO {

    public List<Carrello> doRetrieveAll(){

        List<Carrello> carts = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Carrello";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int id = rs.getInt("ID");
                double costoTotale = rs.getDouble("CostoTotale");
                int quantita = rs.getInt("Quantità");

                Carrello cart = new Carrello(id, costoTotale, quantita);
                carts.add(cart);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return carts;
    }


    public Carrello doRetrieveById(int id) {

        Carrello cart = null;

        try (Connection con = new ConPool().getConnection()) {
            String sql = "SELECT * FROM Carrello WHERE ID = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        double costoTotale = rs.getDouble("CostoTotale");
                        int quantita = rs.getInt("Quantità");

                        cart = new Carrello(id, costoTotale, quantita);
                    }
                }
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return cart;
    }


    public int doRetrieveLastID(){

        int id = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT ID FROM Carrello ORDER BY ID DESC LIMIT 1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                id = rs.getInt("ID");
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return id;
    }


    public int doSave(Carrello cart){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Carrello (CostoTotale, Quantità) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, cart.getCostoTotale());
            ps.setInt(2, cart.getQuantita());
            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }


    public int doUpdateByID(Carrello cart){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "UPDATE Carrello SET CostoTotale = ?, Quantità = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, cart.getCostoTotale());
            ps.setInt(2, cart.getQuantita());
            ps.setInt(3, cart.getID());
            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }


    public int doDeleteByID(int id){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "DELETE FROM Carrello WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
