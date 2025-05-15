package model.ricambi;

import model.ConPool;

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
                LocalDateTime anno = rs.getTimestamp("Anno").toLocalDateTime();
                String pathname = rs.getString("Pathname");
                int idModelloAuto = rs.getInt("ID_ModelloAuto");
                int idMarcaAuto = rs.getInt("ID_MarcaAuto");

                Ricambi spare = new Ricambi(id, nome, prezzo, categoria, anno, pathname, idModelloAuto, idMarcaAuto);
                spares.add(spare);
            }

            rs.close();

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return spares;
    }
}

