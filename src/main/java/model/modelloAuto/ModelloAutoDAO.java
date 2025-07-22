package model.modelloAuto;

import model.ConPool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ModelloAutoDAO {

    public List<ModelloAuto> doRetrieveAll(){

        List<ModelloAuto> models = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM ModelloAuto";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                String id = rs.getString("ID");
                String idMarcaAuto = rs.getString("ID_MarcaAuto");
                double prezzo = rs.getDouble("Prezzo");
                String categoria = rs.getString("Categoria");
                String descrizione = rs.getString("Descrizione");
                int anno = rs.getInt("Anno");

                ModelloAuto model = new ModelloAuto(id, idMarcaAuto, prezzo, categoria, descrizione, anno);
                models.add(model);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return models;
    }


    public ModelloAuto doRetrieveById(String modelId, String brandId){

        ModelloAuto model = null;

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM ModelloAuto WHERE ID = ? AND ID_MarcaAuto = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, modelId);
            st.setString(2, brandId);
            ResultSet rs = st.executeQuery();

            while(rs.next()){

                String id = rs.getString("ID");
                String idMarcaAuto = rs.getString("ID_MarcaAuto");
                double prezzo = rs.getDouble("Prezzo");
                String categoria = rs.getString("Categoria");
                String descrizione = rs.getString("Descrizione");
                int anno = rs.getInt("Anno");

                model = new ModelloAuto(id, idMarcaAuto, prezzo, categoria, descrizione, anno);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return model;
    }


    public List<ModelloAuto> doRetrieveByFilter(String brand, String category, int year, int minPrice, int maxPrice) {

        List<ModelloAuto> models = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM ModelloAuto WHERE (? = 'all' OR  Id_MarcaAuto = ?) " +
                    "AND (? = 'all' OR  Categoria = ?) AND (? = 0 OR Anno = ?) " +
                    "AND ((? = 0 OR Prezzo >= ?) AND (? = 0 OR Prezzo <= ?))";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, brand);
            ps.setString(2, brand);
            ps.setString(3, category);
            ps.setString(4, category);
            ps.setInt(5, year);
            ps.setInt(6, year);
            ps.setInt(7, minPrice);
            ps.setInt(8, minPrice);
            ps.setInt(9, maxPrice);
            ps.setInt(10, maxPrice);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                String id = rs.getString("ID");
                String idMarcaAuto = rs.getString("ID_MarcaAuto");
                double prezzo = rs.getDouble("Prezzo");
                String categoria = rs.getString("Categoria");
                String descrizione = rs.getString("Descrizione");
                int anno = rs.getInt("Anno");

                ModelloAuto modelCar = new ModelloAuto(id, idMarcaAuto, prezzo, categoria, descrizione, anno);
                models.add(modelCar);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return models;
    }
}
