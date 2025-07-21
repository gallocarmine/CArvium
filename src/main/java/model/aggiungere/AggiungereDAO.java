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


    public List<Aggiungere> doRetrieveById(int idCart) {

        List<Aggiungere> adds = new ArrayList<>();

        try (Connection con = new ConPool().getConnection()) {

            String sql = "SELECT * FROM Aggiungere WHERE ID_Carrello = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCart);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                String spareId = rs.getString("ID_Ricambi");
                int quantity = rs.getInt("Quantità");
                Aggiungere add =  new Aggiungere(idCart, spareId, quantity);
                adds.add(add);
            }

        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return adds;
    }


    public Aggiungere doRetrieveByCartSpare(int idCart, String spareId) {

        Aggiungere add = null;

        try (Connection con = new ConPool().getConnection()) {
            String sql = "SELECT * FROM Aggiungere WHERE ID_Carrello = ? AND ID_Ricambi = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCart);
            ps.setString(2, spareId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int quantity = rs.getInt("Quantità");
                add = new Aggiungere(idCart, spareId, quantity);
            }

        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return add;
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


    public int doUpdateQuantity(int idCart, String spareId, int quantity) {

        int result = 0;

        try (Connection con = new ConPool().getConnection()) {

            String sql = "UPDATE Aggiungere SET Quantità = ? WHERE ID_Carrello = ? AND ID_Ricambi = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, idCart);
            ps.setString(3, spareId);

            result = ps.executeUpdate();

        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }


    public int doRemoveById(int idCart, String spareId) {

        int result = 0;

        try (Connection con = new ConPool().getConnection()) {

            String sql = "DELETE FROM Aggiungere WHERE ID_Carrello = ? AND ID_Ricambi = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCart);
            ps.setString(2, spareId);

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected > 0) result = 1;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }
}
