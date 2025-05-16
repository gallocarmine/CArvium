package model.utente;

import model.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtenteDAO {

    public List<Utente> doRetrieveAll(){

        List<Utente> users = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Utente";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                int id = rs.getInt("ID");
                String nome = rs.getString("Nome");
                String cognome = rs.getString("Cognome");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                String via = rs.getString("Via");
                int civico = rs.getInt("Civico");
                int CAP = rs.getInt("CAP");
                boolean admin = rs.getBoolean("Admin");
                int idCarrello = rs.getInt("ID_Carrello");

                Utente user = new Utente(id, nome, cognome, email, password, via, civico, CAP, admin, idCarrello);
                users.add(user);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return users;
    }

    public Utente doRetrieveByEmailPassword(String email, String password){

        Utente user = null;

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Utente WHERE Email = ? AND  Password = SHA1(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int id = rs.getInt("ID");
                String nome = rs.getString("Nome");
                String cognome = rs.getString("Cognome");
                String via = rs.getString("Via");
                int civico = rs.getInt("Civico");
                int CAP = rs.getInt("CAP");
                int idCarrello = rs.getInt("ID_Carrello");
                boolean admin = rs.getBoolean("Admin");

                user = new Utente(id, nome, cognome, email, password, via, civico, CAP, admin, idCarrello);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return user;
    }


    public int doSave(Utente user){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Utente (Nome, Cognome, Email, Password, Via, Civico, CAP, Admin, ID_Carrello) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getCognome());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getVia());
            ps.setInt(6, user.getCivico());
            ps.setInt(7, user.getCAP());
            ps.setBoolean(8, user.getAdmin());
            ps.setInt(9, user.getIDCarrello());

            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }
}
