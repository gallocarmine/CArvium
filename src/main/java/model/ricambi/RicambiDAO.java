package model.ricambi;

import model.ConPool;
import model.modelloAuto.ModelloAuto;
import model.utente.Utente;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RicambiDAO {

    public List<Ricambi> doRetrieveAll() {

        List<Ricambi> spares = new ArrayList<>();

        try (Connection con = new ConPool().getConnection()) {

            String sql = "SELECT * FROM Ricambi";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String id = rs.getString("ID");
                double prezzo = rs.getDouble("Prezzo");
                String categoria = rs.getString("Categoria");
                int quantita = rs.getInt("Quantità");
                int anno = rs.getInt("Anno");
                String idModelloAuto = rs.getString("ID_ModelloAuto");
                String idMarcaAuto = rs.getString("ID_MarcaAuto");

                Ricambi spare = new Ricambi(id, prezzo, categoria, quantita, anno, idModelloAuto, idMarcaAuto);
                spares.add(spare);
            }

            rs.close();

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return spares;
    }


    public Ricambi doRetrieveByID(String id){

        Ricambi spare = null;

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Ricambi WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                double prezzo = rs.getDouble("Prezzo");
                String categoria = rs.getString("Categoria");
                int quantita = rs.getInt("Quantità");
                int anno = rs.getInt("Anno");
                String idModelloAuto = rs.getString("ID_ModelloAuto");
                String idMarcaAuto = rs.getString("ID_MarcaAuto");


                spare = new Ricambi(id, prezzo, categoria, quantita, anno, idModelloAuto, idMarcaAuto);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return spare;
    }


    public List<Ricambi> doRetrieveByFilter(String brand, String category, int year, int minPrice, int maxPrice) {

        List<Ricambi> spares = new ArrayList<>();

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Ricambi WHERE (? = 'all' OR  Id_MarcaAuto = ?) " +
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
                double prezzo = rs.getDouble("Prezzo");
                String categoria = rs.getString("Categoria");
                int quantita = rs.getInt("Quantità");
                int anno = rs.getInt("Anno");
                String idModelloAuto = rs.getString("ID_ModelloAuto");
                String idMarcaAuto = rs.getString("ID_MarcaAuto");

                Ricambi spare = new Ricambi(id, prezzo, categoria, quantita, anno, idModelloAuto, idMarcaAuto);
                spares.add(spare);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return spares;
    }
}

