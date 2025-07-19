package model.ricambi;

import model.ConPool;
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

                int id = rs.getInt("ID");
                String nome = rs.getString("Nome");
                double prezzo = rs.getDouble("Prezzo");
                String categoria = rs.getString("Categoria");
                int quantita = rs.getInt("Quantità");
                int anno = rs.getInt("Anno");
                int idModelloAuto = rs.getInt("ID_ModelloAuto");
                int idMarcaAuto = rs.getInt("ID_MarcaAuto");

                Ricambi spare = new Ricambi(id, nome, prezzo, categoria, quantita, anno, idModelloAuto, idMarcaAuto);
                spares.add(spare);
            }

            rs.close();

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return spares;
    }


    public Ricambi doRetrieveByID(int id){

        Ricambi spare = null;

        try(Connection con = new ConPool().getConnection()){

            String sql = "SELECT * FROM Ricambi WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                String nome = rs.getString("Nome");
                double prezzo = rs.getDouble("Prezzo");
                String categoria= rs.getString("Categoria");
                int quantita = rs.getInt("Quantità");
                int anno = rs.getInt("Anno");
                int idModelloAuto = rs.getInt("ID_ModelloAuto");
                int idMarcaAuto = rs.getInt("ID_MarcaAuto");


                spare = new Ricambi(id, nome, prezzo, categoria, quantita, anno, idModelloAuto, idMarcaAuto);
            }

            rs.close();
        }
        catch(SQLException e){

            System.err.println(e.getMessage());
        }

        return spare;
    }
}

