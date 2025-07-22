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

                String idModelloAuto = rs.getString("ID_ModelloAuto");
                String idMarcaAuto = rs.getString("ID_MarcaAuto");
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


    public List<Salvare> doRetrieveAllById(int userId){

        List<Salvare> saves = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Salvare WHERE ID_Utente = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, userId);

            ResultSet rs = st.executeQuery();

            while(rs.next()){

                String idModelloAuto = rs.getString("ID_ModelloAuto");
                String idMarcaAuto = rs.getString("ID_MarcaAuto");
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


    public Salvare doRetrieveById(String modelId, String brandId, int userId){

        Salvare save = null;

            try(Connection con = new ConPool().getConnection()){

                String sql = "SELECT * FROM Salvare WHERE ID_ModelloAuto = ? AND ID_MarcaAuto = ? AND ID_Utente = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, modelId);
                st.setString(2, brandId);
                st.setInt(3, userId);

                ResultSet rs = st.executeQuery();

                while(rs.next()){

                    String idModelloAuto = rs.getString("ID_ModelloAuto");
                    String idMarcaAuto = rs.getString("ID_MarcaAuto");
                    int idUtente = rs.getInt("ID_Utente");

                    save = new Salvare(idModelloAuto, idMarcaAuto, idUtente);
                }

                rs.close();
            }
            catch(SQLException e){

                System.err.println(e.getMessage());
            }

            return save;
    }


    public int doSave(Salvare save){

        int result = 0;

        try(Connection con = new ConPool().getConnection()){

            String sql = "INSERT INTO Salvare (ID_ModelloAuto, ID_MarcaAuto, ID_Utente) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, save.getIDModelloAuto());
            ps.setString(2, save.getIDMarcaAuto());
            ps.setInt(3, save.getIDUtente());
            result = ps.executeUpdate();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return result;
    }


    public int doRemoveById(String modelId, String brandId, int userId) {

        int result = 0;

        try (Connection con = new ConPool().getConnection()) {

            String sql = "DELETE FROM Salvare WHERE ID_ModelloAuto = ? AND ID_MarcaAuto = ? AND ID_Utente = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, modelId);
            st.setString(2, brandId);
            st.setInt(3, userId);


            if(st.executeUpdate() > 0) result = 1;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }
}
